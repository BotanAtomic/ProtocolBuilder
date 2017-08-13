package com.ankamagames.dofus.network.enums;

public enum HavenBagDailyLoteryErrorEnum {

    HAVENBAG_DAILY_LOTERY_OK(0),
    HAVENBAG_DAILY_LOTERY_ALREADYUSED(1),
    HAVENBAG_DAILY_LOTERY_ERROR(2);

    private final int value;
    public HavenBagDailyLoteryErrorEnum(int value) {
        this.value = value;
    }

    public int value() {
      return this.value;
    }

    public HavenBagDailyLoteryErrorEnum get(int value) {
        return Stream.of(values()).filter(current -> current.value == value).findAny().orElse(null);
    }

}