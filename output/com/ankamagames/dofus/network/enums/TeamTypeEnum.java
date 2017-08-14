package com.ankamagames.dofus.network.enums;

public enum TeamTypeEnum {
  TEAM_TYPE_PLAYER(0),
  TEAM_TYPE_MONSTER(1),
  TEAM_TYPE_MUTANT(2),
  TEAM_TYPE_TAXCOLLECTOR(3),
  TEAM_TYPE_BAD_PLAYER(4),
  TEAM_TYPE_PRISM(5);
  private final int value;

  public TeamTypeEnum(int value) {
    this.value = value;
  }

  public int value() {
    return this.value;
  }

  public TeamTypeEnum get(int value) {
    return Stream.of(values()).filter(current -> current.value == value).findAny().orElse(null);
  }
}
