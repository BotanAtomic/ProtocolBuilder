package org.graviton.attribute;

import lombok.Data;
import org.graviton.utils.StringUtils;

import java.io.File;
import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.graviton.attribute.ActionScriptVariable.resolveVariableType;

/**
 * Created by Botan on 12/08/2017 : 19:51
 */

@Data
public class ActionScriptClass {
    private String content, name, implementedClass, extendsClass, packageName;
    private List<ActionScriptVariable> variables;
    private List<ActionScriptFunction> functions;
    private List<String> importLines = new ArrayList<>();

    Map<Integer, String> fileLines = new TreeMap<>();

    public ActionScriptClass(String content) {
        this.generateLines(this.content = content);

        this.packageName = StringUtils.splitCharacter(content, '\n', 1)[0] + ";";
        this.generateImportedClass();
        this.name = getName(content);
        this.extendsClass = loadExtendsClass(content);
        this.implementedClass = loadImplementedClass(content);

        this.variables = loadVariables();

        this.functions = getFunctions(content);
    }

    private void generateLines(String content) {
        AtomicInteger lineCounter = new AtomicInteger();

        Stream.of(content.split("\n")).forEach(line -> {
            lineCounter.incrementAndGet();
            fileLines.put(lineCounter.get(), line);
        });

        this.fileLines = Collections.unmodifiableMap(fileLines);
    }

    private String getName(String content) {
        String classData = content.split("public class ")[1];
        return classData.split(" ")[0];
    }

    private String loadExtendsClass(String content) {
        String classData = content.split(this.name)[1];
        if (!classData.contains("extends"))
            return "";
        return classData.split("extends ")[1].split(" ")[0];
    }

    private String loadImplementedClass(String content) {
        String classData = content.split(this.name)[1];
        if (!classData.contains("implements"))
            return "";
        return classData.split("implements ")[1].split(" ")[0].replaceAll("\\r|\\n", "");
    }

    private void generateImportedClass() {
        fileLines.values().stream().filter(line -> line.contains("import") && line.contains("ankama")).forEach(line -> importLines.add(line.trim() + "\n"));

        if (content.contains("new Error"))
            importLines.add("import java.lang.Exception;\n");
    }

    private List<ActionScriptVariable> loadVariables() {
        AtomicBoolean variableArea = new AtomicBoolean(true);

        return fileLines.values().stream().filter(line -> {
            if (line.contains("function")) variableArea.set(false);
            return variableArea.get();
        }).filter(line -> ((line.contains("var ") || line.contains("const")) && variableArea.get())).map(ActionScriptVariable::build).collect(Collectors.toList());
    }

    private List<ActionScriptFunction> getFunctions(String content) {
        List<ActionScriptFunction> functions = new ArrayList<>();

        fileLines.forEach((lineCount, line) -> {
            if (line.contains("function") && line.contains(":")) {
                ActionScriptFunction function = new ActionScriptFunction();
                function.setPublic(line.contains("public"));
                function.setType(resolveVariableType(formatFunction(line).split(" : ")[1]));

                String functionName = formatFunction(line).split(" : ")[0];

                StringBuilder constructorBuilder = new StringBuilder("(");
                if (functionName.contains(":")) {
                    Stream.of(functionName.substring(0, functionName.length() - 1).split("\\(")[1].split(",")).forEach(variable -> {
                        String[] variableData = variable.split(":");

                        if (variableData[1].contains(" = "))
                            variableData[1] = variableData[1].split(" = ")[0];

                        constructorBuilder.append(resolveVariableType(variableData[1])).append(" ").append(variableData[0]).append(",");
                    });
                    function.setName(functionName.split("\\(")[0] + constructorBuilder.substring(0, constructorBuilder.length() - 1) + ")");
                } else {
                    function.setName(functionName);
                }

                final AtomicInteger functionLineCounter = new AtomicInteger(0);

                int rightAccoladeCount = 0, leftAccoladeCount = 0;
                while (rightAccoladeCount != leftAccoladeCount || rightAccoladeCount == 0) {
                    String functionLine = fileLines.get(lineCount + functionLineCounter.getAndIncrement());
                    rightAccoladeCount += (functionLine.contains("{") ? 1 : 0);
                    leftAccoladeCount += (functionLine.contains("}") ? 1 : 0);
                }
                function.setFunctionLines(IntStream.range(lineCount + 2, lineCount + functionLineCounter.get() - 1)
                        .mapToObj(i -> formatFunctionLine(fileLines.get(i))).collect(Collectors.toList()));
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
        }
        return finalLine.replace("new Error", "new Exception");
    }

    private String formatFunction(String function) {
        return function.replace("override ", "").replace("public ", "")
                .replace("private ", "").replace("function ", "").replace("get ", "")
                .replace("set ", "").trim();
    }

    public String buildExportPath() {
        return packageName.substring(8, packageName.length() - 1).replace(".", File.separator) + File.separator;
    }

    public ActionScriptClass format(List<ActionScriptClass> protocolClass) {
        Function<String, ActionScriptClass> searchClass = s -> protocolClass.stream().filter(c -> c.getName().contains(s)).findAny().orElse(null);
        Function<String, ActionScriptFunction> internalSearchFunction = s -> functions.stream().filter(c -> c.getName().contains(s)).findAny().orElse(null);

        Function<String, ActionScriptFunction> extendSearchFunction = s -> {
            ActionScriptClass externalClass = searchClass.apply(extendsClass);
            if (externalClass == null) {
                System.err.println("Not found class " + s);
                return null;
            } else
                return externalClass.functions.stream().filter(c -> {
                    System.err.println("Search " + s + " / " + c.getName());
                    return c.getName().contains(s);
                }).findAny().orElse(null);
        };

        Function<String, ActionScriptFunction> implementSearchFunction = s -> {
            ActionScriptClass externalClass = searchClass.apply(extendsClass);
            if (externalClass == null)
                return null;
            else
                return externalClass.functions.stream().filter(c -> {
                    return c.getName().contains(s);
                }).findAny().orElse(null);
        };

        IntStream.range(0, 3).forEach(i -> {
            new ArrayList<>(this.functions).forEach(function -> {
                String name = function.getName().split("\\(")[0];
                if (name.equals("serialize") || name.equals("deserialize")) {
                    new ArrayList<>(function.getFunctionLines()).forEach(functionLine -> {
                        String finalFunctionLine = functionLine.trim();

                        if (finalFunctionLine.contains("=") || !finalFunctionLine.contains("(") || !finalFunctionLine.contains(")"))
                            return;

                        String root = finalFunctionLine.contains(".") ? finalFunctionLine.split("\\.")[0] : "";

                        if(!root.isEmpty() && ( !root.contains("this") && !root.contains("super")))
                            return;

                        if(root.contains("while") || root.contains("for") || root.contains("if") || root.contains("throw") || root.startsWith("("))
                            return;

                        String externalFunctionName = root.isEmpty() ? finalFunctionLine.split("\\(")[0] : finalFunctionLine.split("\\(")[0].substring(root.length() + 1);

                        ActionScriptFunction internalFunction = root.equals("this") ? internalSearchFunction.apply(externalFunctionName) :
                                root.equals("super") ? extendSearchFunction.apply(externalFunctionName) : (implementSearchFunction.apply(externalFunctionName));

                        if(root.equals("super")) {
                            System.err.println(root);
                        }

                        if (internalFunction == null)
                            internalFunction = internalSearchFunction.apply(externalFunctionName);

                        if (internalFunction != null) {
                            int index = function.getFunctionLines().indexOf(functionLine);
                            if (index >= 0) {
                                function.getFunctionLines().addAll(index, internalFunction.getFunctionLines());
                                function.getFunctionLines().remove(functionLine);
                            }
                        }

                    });
                }
            });
        });


        return this;
    }

    public List<ActionScriptFunction> getLogicFunctions() {
        return functions.stream().filter(function -> {
            String name = function.getName().split("\\(")[0];
            return name.equals("serialize") || name.equals("deserialize");
        }).collect(Collectors.toList());

    }

}
