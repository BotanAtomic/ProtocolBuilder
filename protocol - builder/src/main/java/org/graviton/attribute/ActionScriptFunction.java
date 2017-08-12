package org.graviton.attribute;

import lombok.Data;

import java.util.List;

/**
 * Created by Botan on 12/08/2017 : 22:34
 */

@Data
public class ActionScriptFunction {
    private String name, type;
    private List<ActionScriptVariable> variables, constructorVariables;
    private List<String> functionLines;


}
