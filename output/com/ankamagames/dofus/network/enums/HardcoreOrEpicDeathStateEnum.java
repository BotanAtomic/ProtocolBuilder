package com.ankamagames.dofus.network.enums;

public enum HardcoreOrEpicDeathStateEnum {

    DEATH_STATE_ALIVE(0),
    DEATH_STATE_DEAD(1),
    DEATH_STATE_WAITING_CONFIRMATION(2);

    private final int value;
    public HardcoreOrEpicDeathStateEnum(int value) {
        this.value = value;
    }

    public int value() {
      return this.value;
    }

    public HardcoreOrEpicDeathStateEnum get(int value) {
        return Stream.of(values()).filter(current -> current.value == value).findAny().orElse(null);
    }

}