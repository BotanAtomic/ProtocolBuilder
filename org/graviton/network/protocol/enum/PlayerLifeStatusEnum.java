package org.graviton.network.protocol.enums;

public enum PlayerLifeStatusEnum {

    STATUS_ALIVE_AND_KICKING(0),
    STATUS_TOMBSTONE(1),
    STATUS_PHANTOM(2);

    private final int value;
    public PlayerLifeStatusEnum(int value) {
        this.value = value;
    }

    public int values() { return this.value; }

}