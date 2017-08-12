package org.graviton.network.protocol.enums;

public enum HavenBagDailyLoteryErrorEnum {

    HAVENBAG_DAILY_LOTERY_OK(0),
    HAVENBAG_DAILY_LOTERY_ALREADYUSED(1),
    HAVENBAG_DAILY_LOTERY_ERROR(2);

    private final int value;
    public HavenBagDailyLoteryErrorEnum(int value) {
        this.value = value;
    }

    public int values() { return this.value; }

}