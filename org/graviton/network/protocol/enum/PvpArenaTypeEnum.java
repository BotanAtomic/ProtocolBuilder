package org.graviton.network.protocol.enums;

public enum PvpArenaTypeEnum {

    ARENA_TYPE_1VS1(1),
    ARENA_TYPE_3VS3(3);

    private final int value;
    public PvpArenaTypeEnum(int value) {
        this.value = value;
    }

    public int values() { return this.value; }

}