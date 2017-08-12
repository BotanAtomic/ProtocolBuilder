package org.graviton.network.protocol.enums;

public enum UpdatableMountBoostEnum {

    STAMINA(3),
    MATURITY(5),
    ENERGY(1),
    SERENITY(2),
    LOVE(4),
    TIREDNESS(6),
    RIDEABLE(7);

    private final int value;
    public UpdatableMountBoostEnum(int value) {
        this.value = value;
    }

    public int values() { return this.value; }

}