package com.ankamagames.dofus.network.enums;

public enum BoostableCharacteristicEnum {

    BOOSTABLE_CHARAC_STRENGTH(10),
    BOOSTABLE_CHARAC_VITALITY(11),
    BOOSTABLE_CHARAC_WISDOM(12),
    BOOSTABLE_CHARAC_CHANCE(13),
    BOOSTABLE_CHARAC_AGILITY(14),
    BOOSTABLE_CHARAC_INTELLIGENCE(15);

    private final int value;
    public BoostableCharacteristicEnum(int value) {
        this.value = value;
    }

    public int value() {
      return this.value;
    }

    public BoostableCharacteristicEnum get(int value) {
        return Stream.of(values()).filter(current -> current.value == value).findAny().orElse(null);
    }

}