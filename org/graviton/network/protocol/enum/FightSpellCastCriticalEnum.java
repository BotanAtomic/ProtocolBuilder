package org.graviton.network.protocol.enums;

public enum FightSpellCastCriticalEnum {

    NORMAL(1),
    CRITICAL_HIT(2),
    CRITICAL_FAIL(3);

    private final int value;
    public FightSpellCastCriticalEnum(int value) {
        this.value = value;
    }

    public int values() { return this.value; }

}