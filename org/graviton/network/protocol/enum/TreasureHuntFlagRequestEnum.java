package org.graviton.network.protocol.enums;

public enum TreasureHuntFlagRequestEnum {

    TREASURE_HUNT_FLAG_ERROR_UNDEFINED(0),
    TREASURE_HUNT_FLAG_OK(1),
    TREASURE_HUNT_FLAG_WRONG(2),
    TREASURE_HUNT_FLAG_TOO_MANY(3),
    TREASURE_HUNT_FLAG_ERROR_IMPOSSIBLE(4),
    TREASURE_HUNT_FLAG_WRONG_INDEX(5),
    TREASURE_HUNT_FLAG_SAME_MAP(6);

    private final int value;
    public TreasureHuntFlagRequestEnum(int value) {
        this.value = value;
    }

    public int values() { return this.value; }

}