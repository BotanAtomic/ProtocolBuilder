package org.graviton.network.protocol.enums;

public enum PrismStateEnum {

    PRISM_STATE_INVULNERABLE(0),
    PRISM_STATE_NORMAL(1),
    PRISM_STATE_ATTACKED(2),
    PRISM_STATE_FIGHTING(3),
    PRISM_STATE_WEAKENED(4),
    PRISM_STATE_VULNERABLE(5),
    PRISM_STATE_DEFEATED(6),
    PRISM_STATE_SABOTAGED(7);

    private final int value;
    public PrismStateEnum(int value) {
        this.value = value;
    }

    public int values() { return this.value; }

}