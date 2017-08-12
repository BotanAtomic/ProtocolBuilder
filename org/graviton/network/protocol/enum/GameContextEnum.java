package org.graviton.network.protocol.enums;

public enum GameContextEnum {

    ROLE_PLAY(1),
    FIGHT(2);

    private final int value;
    public GameContextEnum(int value) {
        this.value = value;
    }

    public int values() { return this.value; }

}