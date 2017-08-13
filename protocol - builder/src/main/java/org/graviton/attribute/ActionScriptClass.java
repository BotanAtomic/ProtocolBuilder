package org.graviton.attribute;

import lombok.Data;
import org.graviton.utils.StringUtils;

import java.io.File;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.graviton.attribute.ActionScriptVariable.resolveVariableType;

/**
 * Created by Botan on 12/08/2017 : 19:51
 */

@Data
public class ActionScriptClass {
    private String name, implementedClass, extendsClass, packageName;
    private List<ActionScriptVariable> variables;
    private List<ActionScriptFunction> functions;
    private List<String> importLines = new ArrayList<>();

    public ActionScriptClass(String content) {
        this.name = getName(content);
        this.extendsClass = getExtendsClass(content);
        this.implementedClass = getImplementedClass(content);
        this.packageName = StringUtils.splitCharacter(content, '\n', 1)[0] + ";";
        this.variables = getVariables(content);
        this.functions = getFunctions(content);
    }

    private String getName(String content) {
        String classData = content.split("public class ")[1];
        return classData.split(" ")[0];
    }

    private String getExtendsClass(String content) {
        String classData = content.split(this.name)[1];
        if (!classData.contains("extends"))
            return "";
        return classData.split("extends ")[1].split(" ")[0];
    }

    private String getImplementedClass(String content) {
        String classData = content.split(this.name)[1];
        if (!classData.contains("implements"))
            return "";
        return classData.split("implements ")[1].split(" ")[0].replaceAll("\\r|\\n", "");
    }

    private List<ActionScriptVariable> getVariables(String content) {
        List<ActionScriptVariable> variables = new ArrayList<>();
        String classData = StringUtils.splitCharacter(content, '{', 2)[1].substring(1).trim();

        Stream.of(classData.split(";")).filter(data -> !data.contains("function") && data.contains(":")).map(String::trim).forEach(variable -> {
            String name = Stream.of((variable.split(":")[0] + ":").split(" "))
                    .filter(split -> split.contains(":")).map(finalValue -> finalValue.substring(0, finalValue.length() - 1)).findFirst().orElse("");

            String type = Stream.of((":" + variable.split(":")[1]).split(" "))
                    .filter(split -> split.contains(":")).findFirst().orElse("").substring(1);

            variables.add(new ActionScriptVariable(type, name, variable.split(" =").length < 2 ? "" : variable.split(" =")[1].trim()));
        });

        return variables;
    }

    private List<ActionScriptFunction> getFunctions(String content) {
        List<ActionScriptFunction> functions = new ArrayList<>();
        Map<Integer, String> lines = new TreeMap<>();
        AtomicInteger lineCounter = new AtomicInteger();

        Stream.of(content.split("\n")).forEach(line -> {
            lineCounter.incrementAndGet();
            lines.put(lineCounter.get(), line);
        });

        lineCounter.set(0);

        Stream.of(content.split("\n")).forEach(line -> {
            lineCounter.incrementAndGet();

            if (line.contains("import")) {
                if (line.contains("ankamagames"))
                    importLines.add(line.trim() + "\n");
            } else if (line.contains("function") && line.contains(":")) {
                ActionScriptFunction function = new ActionScriptFunction();
                String[] functionData = formatFunction(line).split(" : ");
                String functionName = functionData[0];

                function.setPublic(line.contains("public"));
                function.setType(resolveVariableType(functionData[1]));

                StringBuilder functionConstructor = new StringBuilder("(");
                if (functionName.contains(":")) {
                    Stream.of(functionName.substring(0, functionName.length() - 1).split("\\(")[1].split(",")).forEach(variable -> {
                        String[] variableData = variable.split(":");

                        if (variableData[1].contains(" = "))
                            variableData[1] = variableData[1].split(" = ")[0];

                        functionConstructor.append(resolveVariableType(variableData[1])).append(" ").append(variableData[0]).append(",");
                    });
                    function.setName(functionName.split("\\(")[0] + functionConstructor.substring(0, functionConstructor.length() - 1) + ")");
                } else {
                    function.setName(functionName);
                }


                List<String> functionLines = new LinkedList<>();
                final AtomicInteger functionLineCounter = new AtomicInteger(0);

                while (true) {
                    String functionLine = lines.get(lineCounter.get() + functionLineCounter.getAndIncrement());
                    if (functionLine.contains("}"))
                        break;
                }

                IntStream.range(lineCounter.get() + 1, lineCounter.get() + functionLineCounter.get()).forEach(i -> {
                    String currentLine = lines.get(i);
                    if (StringUtils.countRealCharacter(currentLine) > 2)
                        functionLines.add(formatFunctionLine(lines.get(i)));
                });

                function.setFunctionLines(functionLines);

                functions.add(function);
            }
        });


        return functions;
    }

    private String formatFunctionLine(String line) {
        String finalLine = line;
        if (finalLine.contains("var ")) {
            String data = finalLine.split("var ")[1];
            if (data.contains("=")) {
                String[] variableData = data.split(" = ");
                finalLine = "         " + resolveVariableType(variableData[0].split(":")[1]) + " " + variableData[0].split(":")[0] + " = " + variableData[1];
            } else {
                finalLine = data.split(":")[1] + " " + data.split(":")[0] + ";";
            }
        } else if (finalLine.contains("()")) { // FUCKING FUNCTION
            //TODO : function
        }

        if (finalLine.contains("new Error")) {
            importLines.add("import java.lang.Exception;\n");
        }

        return finalLine.replace("new Error", "new Exception");
    }

    private String formatFunction(String function) {
        return function.replace("override ", "").replace("public ", "")
                .replace("private ", "").replace("function ", "").replace("get ", "").trim();
    }

    public String buildExportPath() {
        return packageName.substring(8, packageName.length() - 1).replace(".", File.separator) + File.separator;
    }

}
