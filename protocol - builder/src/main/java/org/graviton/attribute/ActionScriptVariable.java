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

    static String resolveVariableType(String type) {
        switch (type) {
            case "uint32":
                return "long";
            case "uint":
                return "int";
            case "Boolean":
                return type.toLowerCase();
            default:
                //System.err.println("Not supported variable type : " + type);
        }
        return type.replace("Vector.", "Vector");
    }
}
