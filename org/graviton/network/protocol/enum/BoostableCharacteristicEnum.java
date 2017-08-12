package org.graviton.network.protocol.enums;

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

    public int values() { return this.value; }

}