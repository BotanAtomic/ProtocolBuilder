package com.ankamagames.dofus.network.enums;

public enum FightDispellableEnum {
  DISPELLABLE(1),
  DISPELLABLE_BY_DEATH(2),
  DISPELLABLE_BY_STRONG_DISPEL(3),
  REALLY_NOT_DISPELLABLE(4);
  private final int value;

  public FightDispellableEnum(int value) {
    this.value = value;
  }

  public int value() {
    return this.value;
  }

  public FightDispellableEnum get(int value) {
    return Stream.of(values()).filter(current -> current.value == value).findAny().orElse(null);
  }
}
