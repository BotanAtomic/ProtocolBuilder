package com.ankamagames.dofus.network.enums;

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

    public int value() {
      return this.value;
    }

    public GameActionMarkTypeEnum get(int value) {
        return Stream.of(values()).filter(current -> current.value == value).findAny().orElse(null);
    }

}