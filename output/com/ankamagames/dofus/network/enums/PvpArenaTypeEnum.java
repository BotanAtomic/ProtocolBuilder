package com.ankamagames.dofus.network.enums;

public enum PvpArenaTypeEnum {
  ARENA_TYPE_1VS1(1),
  ARENA_TYPE_3VS3(3);
  private final int value;

  public PvpArenaTypeEnum(int value) {
    this.value = value;
  }

  public int value() {
    return this.value;
  }

  public PvpArenaTypeEnum get(int value) {
    return Stream.of(values()).filter(current -> current.value == value).findAny().orElse(null);
  }
}
