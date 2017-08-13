package com.ankamagames.dofus.network.enums;

public enum FightSpellCastCriticalEnum {

    NORMAL(1),
    CRITICAL_HIT(2),
    CRITICAL_FAIL(3);

    private final int value;
    public FightSpellCastCriticalEnum(int value) {
        this.value = value;
    }

    public int value() {
      return this.value;
    }

    public FightSpellCastCriticalEnum get(int value) {
        return Stream.of(values()).filter(current -> current.value == value).findAny().orElse(null);
    }

}