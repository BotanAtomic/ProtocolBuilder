package com.ankamagames.dofus.network.enums;

public enum PresetSaveUpdateErrorEnum {

    PRESET_UPDATE_ERR_UNKNOWN(1),
    PRESET_UPDATE_ERR_BAD_PRESET_ID(2),
    PRESET_UPDATE_ERR_BAD_POSITION(3),
    PRESET_UPDATE_ERR_BAD_OBJECT_ID(4);

    private final int value;
    public PresetSaveUpdateErrorEnum(int value) {
        this.value = value;
    }

    public int value() {
      return this.value;
    }

    public PresetSaveUpdateErrorEnum get(int value) {
        return Stream.of(values()).filter(current -> current.value == value).findAny().orElse(null);
    }

}