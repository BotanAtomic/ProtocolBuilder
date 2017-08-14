package com.ankamagames.dofus.network.enums;

public enum GameHierarchyEnum {
  UNAVAILABLE(-1),
  PLAYER(0),
  MODERATOR(10),
  GAMEMASTER_PADAWAN(20),
  GAMEMASTER(30),
  ADMIN(40);
  private final int value;

  public GameHierarchyEnum(int value) {
    this.value = value;
  }

  public int value() {
    return this.value;
  }

  public GameHierarchyEnum get(int value) {
    return Stream.of(values()).filter(current -> current.value == value).findAny().orElse(null);
  }
}
