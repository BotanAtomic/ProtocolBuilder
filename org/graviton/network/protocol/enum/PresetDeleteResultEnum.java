package org.graviton.network.protocol.enums;

public enum PresetDeleteResultEnum {

    PRESET_DEL_OK(1),
    PRESET_DEL_ERR_UNKNOWN(2),
    PRESET_DEL_ERR_BAD_PRESET_ID(3);

    private final int value;
    public PresetDeleteResultEnum(int value) {
        this.value = value;
    }

    public int values() { return this.value; }

}