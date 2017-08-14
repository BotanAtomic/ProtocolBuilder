package org.graviton.converter;

import org.graviton.attribute.ASClass;
import org.graviton.utils.StringUtils;

import java.util.stream.Stream;


/**
 * Created by Botan on 14/08/2017 : 18:13
 */
public class ActionScriptConverter {

    public static String convertToJava(ASClass asClass) {
        StringBuilder builder = new StringBuilder();
        builder.append("package ").append(asClass.getPackageName()).append(";\n\n");
        asClass.getImports().forEach(s -> builder.append("import ").append(s).append(";\n"));
        builder.append("\n");
        builder.append("public class ").append(asClass.getName());

        if (asClass.getExtendedClass() != null && !asClass.getExtendedClass().isEmpty())
            builder.append(" extends ").append(asClass.getExtendedClass());
        if (asClass.getImplementedClass() != null && !asClass.getImplementedClass().isEmpty())
            builder.append(" implements ").append(asClass.getImplementedClass());

        builder.append(" {\n\n");

        asClass.getVariables().forEach(variable -> builder.append(variable.getVisibility()).append(" ").append(variable.isConstant() ? "final static " : "").append(variable.getType()).append(" ")
                .append(variable.getName()).append(variable.getValue().isEmpty() ? "" : " = " + variable.getValue()).append(";\n"));

        builder.append("\n\n");

        asClass.getFunctions().forEach(function -> {
            builder.append(function.isOverride() ? "@Override\n"  : "");
            builder.append(function.getVisibility()).append(" ").append(function.isConstructor() ? "" : function.getType() + " ").append(function.getName());
            builder.append(function.buildParameter()).append(" {\n");
            builder.append(function.getBody().replace("\n", "\n"));
            builder.append("}\n\n");
        });

        builder.append("}");
        return builder.toString();
    }

    public static String convertToJavaEnum(ASClass asClass) {
        StringBuilder builder = new StringBuilder();
        builder.append("package ").append(asClass.getPackageName()).append(";");
        asClass.getImports().forEach(s -> builder.append("import ").append(s).append(";"));
        builder.append("public enum ").append(asClass.getName()).append(" {");

        asClass.getVariables().forEach(variable -> builder.append(variable.getName().toUpperCase()).append("(").append(variable.getValue()).append("),"));
        builder.delete(builder.length() - 1, builder.length());
        builder.append(";");

        builder.append("    private final int value;\n");
        builder.append("    public ").append(asClass.getName()).append("(int value) {\n");
        builder.append("        this.value = value;\n");
        builder.append("    }\n\n");

        builder.append("    public int value() {\n      return this.value;\n    }\n\n");
        builder.append("    public " + asClass.getName() + " get(int value) {\n");
        builder.append("        return Stream.of(values()).filter(current -> current.value == value).findAny().orElse(null);\n");
        builder.append("    }\n\n");
        builder.append("}");


        return builder.toString();
    }

    public static String convertType(String type) {
        String finalType;
        switch (type) {
            case "uint":
                finalType = "int";
                break;
            case "Boolean":
                finalType = "boolean";
                break;
            case "*":
                finalType = "Object";
                break;
            default:
                finalType = type;
        }
        if (finalType.contains("Vector"))
            finalType = finalType.replace(".", "");

        if (finalType.equals("Vector<int>"))
            finalType = "Vector<Integer>";

        return finalType;
    }

    public static String formatBody(String data) {
        System.out.println(data);
        System.out.println("----------------------------------------");
        return data;
    }

    public static String convertBodyFunction(String body, ASClass asClass) {
        // formatBody(body);
        StringBuilder builder = new StringBuilder();
        Stream.of(body.split("\n")).forEach(line -> {
            if (line.contains("var ")) {
                line = line.replace("var ", "");
                String value = line.split(" = ")[1].trim();
                String name = line.split(":")[0].trim();
                String type = convertType(line.split(":")[1].split(" ")[0]);
                String compile = type + " " + name + " = " + value;
                builder.append(compile.replaceAll("\\n|\\r", "").trim() + "\n");
            } else if (line.contains(" as ") && line.startsWith("(")) {
                String[] instanceData = line.split(" as ");
                String variable = instanceData[0].substring(1);
                String classCast = instanceData[1].split("\\)")[0];
                String functionToExecute = StringUtils.removeLastCharacter(StringUtils.remove(line, variable, classCast).split("\\.")[1]);
                builder.append("((" + classCast + ") " + variable + ")." + functionToExecute + ";\n");
            } else if (line.contains(" as ")) {
                String castIn = line.split("\\(")[0];
                line = line.replace(castIn, "");
                String[] instanceData = line.split(" as ");
                String variable = instanceData[0].substring(1);
                String classCast = instanceData[1].split("\\)")[0];
                String functionToExecute = StringUtils.removeLastCharacter(StringUtils.remove(line, variable, classCast).split("\\.")[1]);
                builder.append(castIn + "(((" + classCast + ") " + variable + "))." + functionToExecute + ";\n");
            } else builder.append(line.replaceAll("\\n|\\r", "").replaceAll("Vector.", "Vector").trim() + "\n");


        });

        /**
         *        param1.writeShort((this.datas[_loc2_] as StatisticData).getTypeId());
         */

        return builder.toString();
    }


}
