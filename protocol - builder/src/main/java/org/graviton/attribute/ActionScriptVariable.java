package org.graviton.attribute;

import lombok.Data;

/**
 * Created by Botan on 12/08/2017 : 19:51
 */

@Data
public class ActionScriptVariable {
    private final String type, name, value;

    public ActionScriptVariable(String type, String name, String value) {
        this.type = type;
        this.name = name;
        this.value = value;
    }
}
