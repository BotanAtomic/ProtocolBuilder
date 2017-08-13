package com.ankamagames.dofus.network.enums;

public enum TreasureHuntFlagStateEnum {

    TREASURE_HUNT_FLAG_STATE_UNKNOWN(0;),
    TREASURE_HUNT_FLAG_STATE_OK(1;),
    TREASURE_HUNT_FLAG_STATE_WRONG(2;);

    private final int value;
    public TreasureHuntFlagStateEnum(int value) {
        this.value = value;
    }

    public int value() {
      return this.value;
    }

    public TreasureHuntFlagStateEnum get(int value) {
        return Stream.of(values()).filter(current -> current.value == value).findAny().orElse(null);
    }

}