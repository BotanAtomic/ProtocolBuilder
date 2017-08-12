package org.graviton.network.protocol.enums;

public enum PresetSaveUpdateErrorEnum {

    PRESET_UPDATE_ERR_UNKNOWN(1),
    PRESET_UPDATE_ERR_BAD_PRESET_ID(2),
    PRESET_UPDATE_ERR_BAD_POSITION(3),
    PRESET_UPDATE_ERR_BAD_OBJECT_ID(4);

    private final int value;
    public PresetSaveUpdateErrorEnum(int value) {
        this.value = value;
    }

    public int values() { return this.value; }

}