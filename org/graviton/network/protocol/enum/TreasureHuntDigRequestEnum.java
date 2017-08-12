package org.graviton.network.protocol.enums;

public enum TreasureHuntDigRequestEnum {

    TREASURE_HUNT_DIG_ERROR_UNDEFINED(0),
    TREASURE_HUNT_DIG_NEW_HINT(1),
    TREASURE_HUNT_DIG_FINISHED(2),
    TREASURE_HUNT_DIG_WRONG(3),
    TREASURE_HUNT_DIG_LOST(4),
    TREASURE_HUNT_DIG_ERROR_IMPOSSIBLE(5),
    TREASURE_HUNT_DIG_WRONG_AND_YOU_KNOW_IT(6);

    private final int value;
    public TreasureHuntDigRequestEnum(int value) {
        this.value = value;
    }

    public int values() { return this.value; }

}