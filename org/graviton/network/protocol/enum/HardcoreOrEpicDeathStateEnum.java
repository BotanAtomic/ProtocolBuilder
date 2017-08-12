package org.graviton.network.protocol.enums;

public enum HardcoreOrEpicDeathStateEnum {

    DEATH_STATE_ALIVE(0),
    DEATH_STATE_DEAD(1),
    DEATH_STATE_WAITING_CONFIRMATION(2);

    private final int value;
    public HardcoreOrEpicDeathStateEnum(int value) {
        this.value = value;
    }

    public int values() { return this.value; }

}