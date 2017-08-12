package org.graviton.network.protocol.enums;

public enum TreasureHuntFlagStateEnum {

    TREASURE_HUNT_FLAG_STATE_UNKNOWN(0),
    TREASURE_HUNT_FLAG_STATE_OK(1),
    TREASURE_HUNT_FLAG_STATE_WRONG(2);

    private final int value;
    public TreasureHuntFlagStateEnum(int value) {
        this.value = value;
    }

    public int values() { return this.value; }

}