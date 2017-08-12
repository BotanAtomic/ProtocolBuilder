package org.graviton.network.protocol.enums;

public enum TaxCollectorStateEnum {

    STATE_COLLECTING(0),
    STATE_WAITING_FOR_HELP(1),
    STATE_FIGHTING(2);

    private final int value;
    public TaxCollectorStateEnum(int value) {
        this.value = value;
    }

    public int values() { return this.value; }

}