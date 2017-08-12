package org.graviton.network.protocol.enums;

public enum MountEquipedErrorEnum {

    UNSET(0),
    SET(1),
    RIDING(2);

    private final int value;
    public MountEquipedErrorEnum(int value) {
        this.value = value;
    }

    public int values() { return this.value; }

}