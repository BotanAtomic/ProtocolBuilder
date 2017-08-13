package com.ankamagames.dofus.network.enums;

public enum PvpArenaStepEnum {

    ARENA_STEP_REGISTRED(0),
    ARENA_STEP_WAITING_FIGHT(1),
    ARENA_STEP_STARTING_FIGHT(2),
    ARENA_STEP_UNREGISTER(3);

    private final int value;
    public PvpArenaStepEnum(int value) {
        this.value = value;
    }

    public int value() {
      return this.value;
    }

    public PvpArenaStepEnum get(int value) {
        return Stream.of(values()).filter(current -> current.value == value).findAny().orElse(null);
    }

}