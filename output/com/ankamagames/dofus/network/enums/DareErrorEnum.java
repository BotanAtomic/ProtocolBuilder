package com.ankamagames.dofus.network.enums;

public enum DareErrorEnum {

    UKNOWN_ERROR(0),
    DARE_CREATION_FAILED(1),
    DARE_UNKNOWN(2),
    DARE_CANT_CANCEL(3),
    DARE_REWARD_UNKNOWN(4);

    private final int value;
    public DareErrorEnum(int value) {
        this.value = value;
    }

    public int value() {
      return this.value;
    }

    public DareErrorEnum get(int value) {
        return Stream.of(values()).filter(current -> current.value == value).findAny().orElse(null);
    }

}