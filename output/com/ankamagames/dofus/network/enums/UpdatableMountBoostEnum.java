package com.ankamagames.dofus.network.enums;

public enum UpdatableMountBoostEnum {

    STAMINA(3;),
    MATURITY(5;),
    ENERGY(1;),
    SERENITY(2;),
    LOVE(4;),
    TIREDNESS(6;),
    RIDEABLE(7;);

    private final int value;
    public UpdatableMountBoostEnum(int value) {
        this.value = value;
    }

    public int value() {
      return this.value;
    }

    public UpdatableMountBoostEnum get(int value) {
        return Stream.of(values()).filter(current -> current.value == value).findAny().orElse(null);
    }

}