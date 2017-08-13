package com.ankamagames.dofus.network.enums;

public enum TaxCollectorErrorReasonEnum {

    TAX_COLLECTOR_ERROR_UNKNOWN(0),
    TAX_COLLECTOR_NOT_FOUND(1),
    TAX_COLLECTOR_NOT_OWNED(2),
    TAX_COLLECTOR_NO_RIGHTS(3),
    TAX_COLLECTOR_MAX_REACHED(4),
    TAX_COLLECTOR_ALREADY_ONE(5),
    TAX_COLLECTOR_CANT_HIRE_YET(6),
    TAX_COLLECTOR_CANT_HIRE_HERE(7),
    TAX_COLLECTOR_NOT_ENOUGH_KAMAS(8);

    private final int value;
    public TaxCollectorErrorReasonEnum(int value) {
        this.value = value;
    }

    public int value() {
      return this.value;
    }

    public TaxCollectorErrorReasonEnum get(int value) {
        return Stream.of(values()).filter(current -> current.value == value).findAny().orElse(null);
    }

}