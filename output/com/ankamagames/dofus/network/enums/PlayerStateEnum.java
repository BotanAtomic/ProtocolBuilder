package com.ankamagames.dofus.network.enums;

public enum PlayerStateEnum {
  NOT_CONNECTED(0),
  GAME_TYPE_ROLEPLAY(1),
  GAME_TYPE_FIGHT(2),
  UNKNOWN_STATE(99);
  private final int value;

  public PlayerStateEnum(int value) {
    this.value = value;
  }

  public int value() {
    return this.value;
  }

  public PlayerStateEnum get(int value) {
    return Stream.of(values()).filter(current -> current.value == value).findAny().orElse(null);
  }
}
