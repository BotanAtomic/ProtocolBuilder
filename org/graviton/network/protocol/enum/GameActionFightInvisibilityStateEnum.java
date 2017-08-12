package org.graviton.network.protocol.enums;

public enum GameActionFightInvisibilityStateEnum {

    INVISIBLE(1),
    DETECTED(2),
    VISIBLE(3);

    private final int value;
    public GameActionFightInvisibilityStateEnum(int value) {
        this.value = value;
    }

    public int values() { return this.value; }

}