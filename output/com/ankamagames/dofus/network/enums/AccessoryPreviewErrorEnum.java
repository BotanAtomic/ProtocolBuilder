package com.ankamagames.dofus.network.enums;

public enum AccessoryPreviewErrorEnum {

    PREVIEW_ERROR(0),
    PREVIEW_COOLDOWN(1),
    PREVIEW_BAD_ITEM(2);

    private final int value;
    public AccessoryPreviewErrorEnum(int value) {
        this.value = value;
    }

    public int value() {
      return this.value;
    }

    public AccessoryPreviewErrorEnum get(int value) {
        return Stream.of(values()).filter(current -> current.value == value).findAny().orElse(null);
    }

}