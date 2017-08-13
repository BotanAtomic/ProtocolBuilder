package com.ankamagames.dofus.network.enums;

public enum TreasureHuntTypeEnum {

    TREASURE_HUNT_CLASSIC(0),
    TREASURE_HUNT_PORTAL(1),
    TREASURE_HUNT_LEGENDARY(2);

    private final int value;
    public TreasureHuntTypeEnum(int value) {
        this.value = value;
    }

    public int value() {
      return this.value;
    }

    public TreasureHuntTypeEnum get(int value) {
        return Stream.of(values()).filter(current -> current.value == value).findAny().orElse(null);
    }

}