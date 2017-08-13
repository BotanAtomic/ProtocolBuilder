package org.graviton.attribute;

import lombok.Data;

/**
 * Created by Botan on 12/08/2017 : 19:51
 */

@Data
public class ActionScriptVariable {
    private final String type, name, value;

    public ActionScriptVariable(String type, String name, String value) {
        this.type = resolveVariableType(type);
        this.name = name;
        this.value = value;
    }

    static ActionScriptVariable build(String line) {
        String variable = line.contains("var ") ? line.split("var ")[1] : line.split("const ")[1];
        String name = variable.split(":")[0];
        String type = variable.contains("=") ?
                variable.substring(0, variable.length() - 2).split(":")[1].split(" = ")[0] :
                variable.substring(0, variable.length() - 2).split(":")[1];
        String value = variable.contains("=") ? variable.substring(0, variable.length() - 1).split(" = ")[1] : "";
        return new ActionScriptVariable(type, name, value);
    }

    static String resolveVariableType(String type) {
        switch (type) {
            case "uint32":
                return "long";
            case "uint":
                return "int";
            case "Boolean":
                return type.toLowerCase();
            case "*" :
                return "Object";
            default:
                //System.err.println("Not supported variable type : " + type);
        }

        if(type.contains("Vector")) {
            String vectorType = type.split("<")[1];
            type = resolveVariableType(vectorType.substring(0 ,vectorType.length() - 1)) + "[]";
        }

        return type;
    }
}
