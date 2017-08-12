package org.graviton.network.protocol.enums;

public enum CraftResultEnum {

    CRAFT_IMPOSSIBLE(0),
    CRAFT_FAILED(1),
    CRAFT_SUCCESS(2),
    CRAFT_NEUTRAL(3);

    private final int value;
    public CraftResultEnum(int value) {
        this.value = value;
    }

    public int values() { return this.value; }

}