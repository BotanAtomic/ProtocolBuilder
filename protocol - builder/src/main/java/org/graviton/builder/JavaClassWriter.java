package org.graviton.builder;

import org.graviton.attribute.ActionScriptClass;
import org.graviton.utils.FileUtils;

/**
 * Created by Botan on 12/08/2017 : 21:03
 */
public class JavaClassWriter {

    public static void writeEnum(ActionScriptClass actionScriptClass) {
        StringBuilder builder = new StringBuilder();
        builder.append("package ").append(System.getProperty("default.enum.package")).append(";");
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

        builder.append("    public int values() { return this.value; }\n\n");
        builder.append("}");

        FileUtils.writeFile(builder.toString(), System.getProperty("export.enum.path") + actionScriptClass.getName() + ".java");
    }

}
