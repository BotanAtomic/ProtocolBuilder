package com.ankamagames.dofus.network.enums;

public enum BuildTypeEnum {
  RELEASE(0),
  BETA(1),
  ALPHA(2),
  TESTING(3),
  INTERNAL(4),
  DEBUG(5),
  EXPERIMENTAL(6);
  private final int value;

  public BuildTypeEnum(int value) {
    this.value = value;
  }

  public int value() {
    return this.value;
  }

  public BuildTypeEnum get(int value) {
    return Stream.of(values()).filter(current -> current.value == value).findAny().orElse(null);
  }
}
