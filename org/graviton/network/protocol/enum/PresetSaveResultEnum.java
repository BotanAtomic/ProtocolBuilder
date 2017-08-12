package org.graviton.network.protocol.enums;

public enum PresetSaveResultEnum {

    PRESET_SAVE_OK(1),
    PRESET_SAVE_ERR_UNKNOWN(2),
    PRESET_SAVE_ERR_TOO_MANY(3);

    private final int value;
    public PresetSaveResultEnum(int value) {
        this.value = value;
    }

    public int values() { return this.value; }

}