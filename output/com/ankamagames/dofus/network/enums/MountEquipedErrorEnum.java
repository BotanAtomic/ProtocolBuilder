package com.ankamagames.dofus.network.enums;

public enum MountEquipedErrorEnum {

    UNSET(0),
    SET(1),
    RIDING(2);

    private final int value;
    public MountEquipedErrorEnum(int value) {
        this.value = value;
    }

    public int value() {
      return this.value;
    }

    public MountEquipedErrorEnum get(int value) {
        return Stream.of(values()).filter(current -> current.value == value).findAny().orElse(null);
    }

}