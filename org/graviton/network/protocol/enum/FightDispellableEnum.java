package org.graviton.network.protocol.enums;

public enum FightDispellableEnum {

    DISPELLABLE(1),
    DISPELLABLE_BY_DEATH(2),
    DISPELLABLE_BY_STRONG_DISPEL(3),
    REALLY_NOT_DISPELLABLE(4);

    private final int value;
    public FightDispellableEnum(int value) {
        this.value = value;
    }

    public int values() { return this.value; }

}