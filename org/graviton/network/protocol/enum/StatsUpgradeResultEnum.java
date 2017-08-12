package org.graviton.network.protocol.enums;

public enum StatsUpgradeResultEnum {

    NONE(-1),
    SUCCESS(0),
    RESTRICTED(1),
    GUEST(2),
    IN_FIGHT(3),
    NOT_ENOUGH_POINT(4);

    private final int value;
    public StatsUpgradeResultEnum(int value) {
        this.value = value;
    }

    public int values() { return this.value; }

}