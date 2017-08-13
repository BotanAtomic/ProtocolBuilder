package com.ankamagames.dofus.network.enums;

public enum GameActionMarkCellsTypeEnum {

    CELLS_CIRCLE(0),
    CELLS_CROSS(1),
    CELLS_SQUARE(2);

    private final int value;
    public GameActionMarkCellsTypeEnum(int value) {
        this.value = value;
    }

    public int value() {
      return this.value;
    }

    public GameActionMarkCellsTypeEnum get(int value) {
        return Stream.of(values()).filter(current -> current.value == value).findAny().orElse(null);
    }

}