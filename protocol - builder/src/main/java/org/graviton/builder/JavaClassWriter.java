package org.graviton.builder;

import org.graviton.attribute.ActionScriptClass;
import org.graviton.utils.FileUtils;

/**
 * Created by Botan on 12/08/2017 : 21:03
 */
public class JavaClassWriter {

    public static void write(ActionScriptClass actionScriptClass, boolean enumeration) {
        if (enumeration) writeEnum(actionScriptClass);
        else writeClass(actionScriptClass);
    }

    public static void writeEnum(ActionScriptClass actionScriptClass) {
        StringBuilder builder = new StringBuilder();
        builder.append(actionScriptClass.getPackageName());
        builder.append("\n\n");
        builder.append("public enum ").append(actionScriptClass.getName()).append(" {\n\n");

        actionScriptClass.getVariables().forEach(variable -> {
            builder.append("    ").append(variable.getName().toUpperCase()).append("(").append(variable.getValue()).append("),\n");
        });

        builder.delete(builder.length() - 2, builder.length());
        builder.append(";\n\n");

        builder.append("    private final int value;\n");
        builder.append("    public ").append(actionScriptClass.getName()).append("(int value) {\n");
        builder.append("        this.value = value;\n");
        builder.append("    }\n\n");

        builder.append("    public int value() {\n      return this.value;\n    }\n\n");
        builder.append("    public " + actionScriptClass.getName() + " get(int value) {\n");
        builder.append("        return Stream.of(values()).filter(current -> current.value == value).findAny().orElse(null);\n");
        builder.append("    }\n\n");
        builder.append("}");

        System.err.println(builder.toString());
        FileUtils.writeFile(builder.toString(), actionScriptClass.buildExportPath() + actionScriptClass.getName() + ".java");
    }

    public static void writeClass(ActionScriptClass actionScriptClass) {
        StringBuilder builder = new StringBuilder();
        builder.append("package ").append(actionScriptClass.getPackageName());
        builder.append("\n\n");
        actionScriptClass.getImportLines().forEach(builder::append);
        builder.append("\n");
        builder.append("public class ").append(actionScriptClass.getName()).append(" ");

        if (!actionScriptClass.getExtendsClass().isEmpty())
            builder.append("extends ").append(actionScriptClass.getExtendsClass()).append(" ");
        if (!actionScriptClass.getImplementedClass().isEmpty())
            builder.append("implements ").append(actionScriptClass.getImplementedClass()).append(" ");

        builder.append("{\n\n");
        actionScriptClass.getVariables().forEach(variable -> builder.append("    private ").append(variable.getType()).append(" ")
                .append(variable.getName()).append(variable.getValue().isEmpty() ? ";" : " = " + variable.getValue()).append("\n"));

        builder.append("\n\n");
        actionScriptClass.getFunctions().forEach(function -> {
            builder.append("    ").append(function.isPublic() ? "public " : "private ").append(function.getType()).append(" ").append(function.getName());
            builder.append(" {\n");

            function.getFunctionLines().forEach(line -> builder.append(line).append("\n"));
            builder.append("    }\n\n");
        });
        builder.append("}");
        FileUtils.writeFile(builder.toString(), actionScriptClass.buildExportPath() + actionScriptClass.getName() + ".java");
    }

}
