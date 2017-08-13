package com.ankamagames.dofus.network.enums;

public enum PlayerStatusEnum {

    PLAYER_STATUS_OFFLINE(0),
    PLAYER_STATUS_UNKNOWN(1),
    PLAYER_STATUS_AVAILABLE(10),
    PLAYER_STATUS_IDLE(20),
    PLAYER_STATUS_AFK(21),
    PLAYER_STATUS_PRIVATE(30),
    PLAYER_STATUS_SOLO(40);

    private final int value;
    public PlayerStatusEnum(int value) {
        this.value = value;
    }

    public int value() {
      return this.value;
    }

    public PlayerStatusEnum get(int value) {
        return Stream.of(values()).filter(current -> current.value == value).findAny().orElse(null);
    }

}