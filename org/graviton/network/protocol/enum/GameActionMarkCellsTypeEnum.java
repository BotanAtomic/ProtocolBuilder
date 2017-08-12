package org.graviton.network.protocol.enums;

public enum GameActionMarkCellsTypeEnum {

    CELLS_CIRCLE(0),
    CELLS_CROSS(1),
    CELLS_SQUARE(2);

    private final int value;
    public GameActionMarkCellsTypeEnum(int value) {
        this.value = value;
    }

    public int values() { return this.value; }

}