package org.graviton.network.protocol.enums;

public enum GameActionMarkTypeEnum {

    GLYPH(1),
    TRAP(2),
    WALL(3),
    PORTAL(4),
    RUNE(5);

    private final int value;
    public GameActionMarkTypeEnum(int value) {
        this.value = value;
    }

    public int values() { return this.value; }

}