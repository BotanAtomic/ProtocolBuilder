package org.graviton.network.protocol.enums;

public enum CompassTypeEnum {

    COMPASS_TYPE_SIMPLE(0),
    COMPASS_TYPE_SPOUSE(1),
    COMPASS_TYPE_PARTY(2),
    COMPASS_TYPE_PVP_SEEK(3),
    COMPASS_TYPE_QUEST(4);

    private final int value;
    public CompassTypeEnum(int value) {
        this.value = value;
    }

    public int values() { return this.value; }

}