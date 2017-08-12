package org.graviton.network.protocol.enums;

public enum PlayerStateEnum {

    NOT_CONNECTED(0),
    GAME_TYPE_ROLEPLAY(1),
    GAME_TYPE_FIGHT(2),
    UNKNOWN_STATE(99);

    private final int value;
    public PlayerStateEnum(int value) {
        this.value = value;
    }

    public int values() { return this.value; }

}