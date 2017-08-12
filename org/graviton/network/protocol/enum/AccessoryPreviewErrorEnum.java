package org.graviton.network.protocol.enums;

public enum AccessoryPreviewErrorEnum {

    PREVIEW_ERROR(0),
    PREVIEW_COOLDOWN(1),
    PREVIEW_BAD_ITEM(2);

    private final int value;
    public AccessoryPreviewErrorEnum(int value) {
        this.value = value;
    }

    public int values() { return this.value; }

}