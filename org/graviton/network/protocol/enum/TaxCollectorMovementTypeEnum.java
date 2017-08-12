package org.graviton.network.protocol.enums;

public enum TaxCollectorMovementTypeEnum {

    TAX_COLLECTOR_UNKNOWN_ACTION(0),
    TAX_COLLECTOR_HIRED(1),
    TAX_COLLECTOR_HARVESTED(2),
    TAX_COLLECTOR_DEFEATED(3),
    TAX_COLLECTOR_DESTROYED(4);

    private final int value;
    public TaxCollectorMovementTypeEnum(int value) {
        this.value = value;
    }

    public int values() { return this.value; }

}