package com.ankamagames.dofus.network.enums;

public enum CharacterRemodelingEnum {
  CHARACTER_REMODELING_NOT_APPLICABLE(0),
  CHARACTER_REMODELING_NAME(1),
  CHARACTER_REMODELING_COLORS(2),
  CHARACTER_REMODELING_COSMETIC(4),
  CHARACTER_REMODELING_BREED(8),
  CHARACTER_REMODELING_GENDER(16),
  CHARACTER_OPT_REMODELING_NAME(32);
  private final int value;

  public CharacterRemodelingEnum(int value) {
    this.value = value;
  }

  public int value() {
    return this.value;
  }

  public CharacterRemodelingEnum get(int value) {
    return Stream.of(values()).filter(current -> current.value == value).findAny().orElse(null);
  }
}
