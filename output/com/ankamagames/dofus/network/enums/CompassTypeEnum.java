package com.ankamagames.dofus.network.enums;

public enum CompassTypeEnum {

    COMPASS_TYPE_SIMPLE(0;),
    COMPASS_TYPE_SPOUSE(1;),
    COMPASS_TYPE_PARTY(2;),
    COMPASS_TYPE_PVP_SEEK(3;),
    COMPASS_TYPE_QUEST(4;);

    private final int value;
    public CompassTypeEnum(int value) {
        this.value = value;
    }

    public int value() {
      return this.value;
    }

    public CompassTypeEnum get(int value) {
        return Stream.of(values()).filter(current -> current.value == value).findAny().orElse(null);
    }

}