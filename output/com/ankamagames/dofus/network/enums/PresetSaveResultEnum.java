package com.ankamagames.dofus.network.enums;

public enum PresetSaveResultEnum {

    PRESET_SAVE_OK(1),
    PRESET_SAVE_ERR_UNKNOWN(2),
    PRESET_SAVE_ERR_TOO_MANY(3);

    private final int value;
    public PresetSaveResultEnum(int value) {
        this.value = value;
    }

    public int value() {
      return this.value;
    }

    public PresetSaveResultEnum get(int value) {
        return Stream.of(values()).filter(current -> current.value == value).findAny().orElse(null);
    }

}