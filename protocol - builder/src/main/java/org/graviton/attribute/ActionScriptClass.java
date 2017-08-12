package org.graviton.attribute;

import lombok.Data;
import org.graviton.utils.StringUtils;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by Botan on 12/08/2017 : 19:51
 */

@Data
public class ActionScriptClass {
    private String name, implementedClass, extendsClass;
    private List<ActionScriptVariable> variables;
    private List<ActionScriptFunction> functions;

    public ActionScriptClass(String content) {
        this.name = getName(content);
        this.extendsClass = getExtendsClass(content);
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

    private List<ActionScriptVariable> getVariables(String content) {
        List<ActionScriptVariable> variables = new ArrayList<>();
        String classData = StringUtils.splitCharacter(content, '{', 2)[1].substring(1).trim();

        Stream.of(classData.split(";")).filter(data -> !data.contains("function") && data.contains(":")).map(String::trim).forEach(variable -> {
            String name = Stream.of((variable.split(":")[0] + ":").split(" "))
                    .filter(split -> split.contains(":")).map(finalValue -> finalValue.substring(0, finalValue.length() - 1)).findFirst().orElse("");

            String type = Stream.of((":" + variable.split(":")[1]).split(" "))
                    .filter(split -> split.contains(":")).findFirst().orElse("").substring(1);

            variables.add(new ActionScriptVariable(type, name, variable.split(" =")[1].trim()));
        });

        return variables;
    }

    private List<ActionScriptFunction> getFunctions(String content) {
        Map<Integer, String> lines = new TreeMap<>();
        AtomicInteger lineCounter = new AtomicInteger();

        Stream.of(content.split("\n")).forEach(line -> {
            lineCounter.incrementAndGet();
            lines.put(lineCounter.get(), line);
        });

        lineCounter.set(0);

        Stream.of(content.split("\n")).forEach(line -> {
            lineCounter.incrementAndGet();

            if (line.contains("function") && line.contains(":")) {
                List<ActionScriptVariable> constructorVariables = new ArrayList<>();
                boolean isPublic = line.contains("public");
                String[] functionData = formatFunction(line).split(" : ");
                String functionName = functionData[0];
                String type = functionData[1];

                if (functionName.contains(":")) {
                    Stream.of(functionName.substring(0, functionName.length() - 1).split("\\(")[1].split(",")).forEach(variable -> {
                        String[] variableData = variable.split(":");
                        constructorVariables.add(new ActionScriptVariable(variableData[1], variableData[0], ""));
                    });
                }

                List<String> functionLines = new LinkedList<>();
                final AtomicInteger functionLineCounter = new AtomicInteger(0);

                while (true) {
                    String functionLine = lines.get(lineCounter.get() + functionLineCounter.getAndIncrement());
                    if (functionLine.contains("}"))
                        break;
                }

                System.err.println("Function content : " + functionName);
                IntStream.range(lineCounter.get() + 1, lineCounter.get() + functionLineCounter.get()).forEach(i -> {
                    String currentLine = lines.get(i);
                    if (StringUtils.countRealCharacter(currentLine) > 2)
                        functionLines.add(formatFunctionLine(lines.get(i)));
                });
                functionLines.forEach(System.err::println);
                System.err.println("END \n\n");
            }
        });


        return null;
    }

    private String formatFunctionLine(String line) {
        String finalLine = line;
        if(finalLine.contains("var")) {
            String
        }
        return finalLine.replace("new Error", "new Exception");
    }

    private String formatFunction(String function) {
        return function.replace("override ", "").replace("public ", "")
                .replace("private ", "").replace("function ", "").replace("get ", "").trim();
    }

}
