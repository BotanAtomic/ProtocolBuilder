package com.ankamagames.dofus.network.enums;

public enum PresetDeleteResultEnum {
  PRESET_DEL_OK(1),
  PRESET_DEL_ERR_UNKNOWN(2),
  PRESET_DEL_ERR_BAD_PRESET_ID(3);
  private final int value;

  public PresetDeleteResultEnum(int value) {
    this.value = value;
  }

  public int value() {
    return this.value;
  }

  public PresetDeleteResultEnum get(int value) {
    return Stream.of(values()).filter(current -> current.value == value).findAny().orElse(null);
  }
}
