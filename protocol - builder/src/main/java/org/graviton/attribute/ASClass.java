package org.graviton.attribute;

import lombok.Data;
import org.graviton.utils.StringUtils;

import java.io.File;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.graviton.converter.ActionScriptConverter.convertBodyFunction;
import static org.graviton.converter.ActionScriptConverter.convertType;
import static org.graviton.utils.StringUtils.remove;

/**
 * Created by Botan on 14/08/2017 : 17:23
 */

@Data
public class ASClass {
    private String name, extendedClass, implementedClass, packageName;
    private List<String> imports = new LinkedList<>();
    private List<Variable> variables = new LinkedList<>();
    private List<Function> functions = new LinkedList<>();

    public ASClass(String content) {
        if (content.contains("new Error")) { //dirty brute change
            content = content.replaceAll("new Error", "new Exception");
            imports.add("java.lang.Exception");
        }

        this.resolveClassInfo(content);
        this.resolveVariable(content);
        this.resolveFunction(content);
    }

    public static Variable parseVariable(String variableData, boolean constant, String visibility) {
        Variable variable = new Variable();
        String globalVarData[] = remove(variableData, "private", "public", " var ", " static const ", ";").split(" = ");
        String[] varData = globalVarData[0].split(":");
        variable.name = varData[0];
        variable.setType(varData[1]);
        variable.value = globalVarData.length > 1 ? globalVarData[1] : "";
        variable.visibility = visibility;
        variable.constant = constant;
        variable.creation = variableData.contains(" new ");
        return variable;
    }

    private static void parseFunctionParameter(String data, Function function) {
        Matcher matcher = Pattern.compile("\\((.)*\\)").matcher(data);
        while (matcher.find()) {
            String parameterArray = StringUtils.remove(matcher.group(), "(", ")", " = \"\"");
            if (!parameterArray.isEmpty())
                Stream.of(parameterArray.split(",")).forEach(parameter -> {
                    String type = parameter.split(":")[1].trim();
                    if (type.contains("=")) {
                        type = type.split(" = ")[0];
                    }
                    function.pushParameter(new Variable(parameter.split(":")[0].trim(), type));
                });
        }
    }

    private static String parseFunctionBody(String functionData, String[] data, ASClass asClass) {
        int count = 1, i = Arrays.asList(data).indexOf(functionData) + 2;
        StringBuilder builder = new StringBuilder();
        while (count != 0) {
            count = Objects.equals(data[i], "{") ? count + 1 : Objects.equals(data[i], "}") ? count - 1 : count;
            builder.append(data[i]).append("\n");
            i++;
        }
        return convertBodyFunction(builder.substring(0, builder.length() - 2), asClass);
    }

    private void resolveClassInfo(String content) {
        String[] result = content.split(" ");
        AtomicInteger counter = new AtomicInteger();
        Stream.of(result).forEach(line -> {
            counter.incrementAndGet();
            switch (line) {
                case "class":
                    this.name = result[counter.get()];
                    break;
                case "extends":
                    this.extendedClass = result[counter.get()];
                    break;
                case "implements":
                    this.implementedClass = result[counter.get()].replaceAll("\\n|\\r|,", "");
                    break;
            }

            if (implementedClass != null && line.contains(implementedClass) && !result[counter.get()].isEmpty()) {
                implementedClass += "," + result[counter.get()].replaceAll("\\n|\\r|,", "");
            }


        });

        Matcher matcher = Pattern.compile("import [\\w|.]+;").matcher(content);

        while (matcher.find())
            imports.add(StringUtils.removeLastCharacter(matcher.group().split(" ")[1]));

        matcher = Pattern.compile("package [\\w|.]+").matcher(content);
        if (matcher.find())
            packageName = matcher.group().replace("package ", "");
    }

    private void resolveVariable(String content) {
        String[] regexData = {"(private|public) var (.)+", "(private|public) static const (.)+"};
        Stream.of(regexData).forEach(regex -> {
            Matcher matcher = Pattern.compile(regex).matcher(content);
            while (matcher.find())
                variables.add(parseVariable(matcher.group(), regex.equals(regexData[1]), matcher.group().contains("public") ? "public" : "private"));
        });
    }

    private void resolveFunction(String content) {
        Matcher matcher = Pattern.compile("(override)* (private|public) function (.)+").matcher(content);

        while (matcher.find()) {
            Function function = new Function();
            String functionData = matcher.group().trim();
            function.body = parseFunctionBody(functionData, Stream.of(content.split("\n"))
                    .map(String::trim).collect(Collectors.toList()).toArray(new String[]{}), this);
            function.override = functionData.contains("override");
            function.visibility = functionData.contains("public") ? "public" : "private";
            functionData = StringUtils.remove(functionData, "override", function.visibility + " function ", " get ", " set ");
            function.setType(functionData.contains(":") ? functionData.split(" : ")[1] : "constructor");
            function.name = functionData.split("\\(")[0];

            if (function.name.split(" ").length > 1)
                function.name = function.name.split(" ")[1];

            parseFunctionParameter(StringUtils.remove(functionData, function.name), function);

            functions.add(function);
        }
    }

    public String buildExportPath() {
        return packageName.replace(".", File.separator) + File.separator + name + ".java";
    }

    public void replaceMainFunction(Map<String, Function> allFunctions) {
        AtomicInteger counter = new AtomicInteger(1);

        while (counter.get() != 0) {
            counter.set(0);
            this.functions.stream().filter(function -> function.name.equals("serialize") ||
                    function.name.equals("deserialize")).forEach(currentFunction -> {
                Stream.of(currentFunction.body.split("\n")).forEach(line -> {
                    if (line.startsWith("this.") || line.startsWith("super.")) {
                        if (line.contains("(") && line.contains(")") && !line.contains("=")) {
                            Function function = allFunctions.get(line.split("\\.")[1].split("\\(")[0]);
                            if (function == null) {
                                return;
                            }
                            if (!function.getBody().isEmpty()) {
                                currentFunction.body = currentFunction.body.replace(line, function.body);
                                counter.incrementAndGet();
                            }
                        }
                    }
                });
            });
        }

        this.functions = this.functions.stream().filter(function -> function.name.equals("serialize") ||
                function.name.equals("deserialize")).collect(Collectors.toList());
    }

    @Data
    public static class Variable {
        String name, type, value, visibility;
        boolean constant, creation;

        private Variable(String name, String type) {
            this.name = name;
            this.setType(type);
        }

        private Variable() {

        }

        private void setType(String type) {
            this.type = convertType(type);
        }
    }

    @Data
    public static class Function {
        String name, visibility, body, type;
        List<Variable> parameters = new LinkedList<>();
        boolean override;

        private void pushParameter(Variable variable) {
            parameters.add(variable);
        }

        private void setType(String type) {
            this.type = convertType(type);
        }

        public String buildParameter() {
            if (parameters.isEmpty()) return "()";
            StringBuilder builder = new StringBuilder("(");
            parameters.forEach(parameter -> builder.append(parameter.getType()).append(" ").append(parameter.getName()).append(", "));
            return builder.substring(0, builder.length() - 2) + ")";
        }

        public boolean isConstructor() {
            return this.type.equals("constructor");
        }
    }

}
