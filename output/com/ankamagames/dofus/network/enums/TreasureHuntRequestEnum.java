package com.ankamagames.dofus.network.enums;

public enum TreasureHuntRequestEnum {
  TREASURE_HUNT_ERROR_UNDEFINED(0),
  TREASURE_HUNT_ERROR_NO_QUEST_FOUND(2),
  TREASURE_HUNT_ERROR_ALREADY_HAVE_QUEST(3),
  TREASURE_HUNT_ERROR_NOT_AVAILABLE(4),
  TREASURE_HUNT_ERROR_DAILY_LIMIT_EXCEEDED(5),
  TREASURE_HUNT_OK(1);
  private final int value;

  public TreasureHuntRequestEnum(int value) {
    this.value = value;
  }

  public int value() {
    return this.value;
  }

  public TreasureHuntRequestEnum get(int value) {
    return Stream.of(values()).filter(current -> current.value == value).findAny().orElse(null);
  }
}
