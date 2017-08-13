package com.ankamagames.dofus.network.enums;

public enum PartStateEnum {

    PART_NOT_INSTALLED(0;),
    PART_BEING_UPDATER(1;),
    PART_UP_TO_DATE(2;);

    private final int value;
    public PartStateEnum(int value) {
        this.value = value;
    }

    public int value() {
      return this.value;
    }

    public PartStateEnum get(int value) {
        return Stream.of(values()).filter(current -> current.value == value).findAny().orElse(null);
    }

}