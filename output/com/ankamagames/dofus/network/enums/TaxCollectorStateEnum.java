package com.ankamagames.dofus.network.enums;

public enum TaxCollectorStateEnum {
  STATE_COLLECTING(0),
  STATE_WAITING_FOR_HELP(1),
  STATE_FIGHTING(2);
  private final int value;

  public TaxCollectorStateEnum(int value) {
    this.value = value;
  }

  public int value() {
    return this.value;
  }

  public TaxCollectorStateEnum get(int value) {
    return Stream.of(values()).filter(current -> current.value == value).findAny().orElse(null);
  }
}
