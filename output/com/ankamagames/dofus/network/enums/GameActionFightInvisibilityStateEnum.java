package com.ankamagames.dofus.network.enums;

public enum GameActionFightInvisibilityStateEnum {
  INVISIBLE(1),
  DETECTED(2),
  VISIBLE(3);
  private final int value;

  public GameActionFightInvisibilityStateEnum(int value) {
    this.value = value;
  }

  public int value() {
    return this.value;
  }

  public GameActionFightInvisibilityStateEnum get(int value) {
    return Stream.of(values()).filter(current -> current.value == value).findAny().orElse(null);
  }
}
