package com.ankamagames.dofus.network.enums;

public enum PlayerLifeStatusEnum {
  STATUS_ALIVE_AND_KICKING(0),
  STATUS_TOMBSTONE(1),
  STATUS_PHANTOM(2);
  private final int value;

  public PlayerLifeStatusEnum(int value) {
    this.value = value;
  }

  public int value() {
    return this.value;
  }

  public PlayerLifeStatusEnum get(int value) {
    return Stream.of(values()).filter(current -> current.value == value).findAny().orElse(null);
  }
}
