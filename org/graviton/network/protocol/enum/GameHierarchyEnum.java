package org.graviton.network.protocol.enums;

public enum GameHierarchyEnum {

    UNAVAILABLE(-1),
    PLAYER(0),
    MODERATOR(10),
    GAMEMASTER_PADAWAN(20),
    GAMEMASTER(30),
    ADMIN(40);

    private final int value;
    public GameHierarchyEnum(int value) {
        this.value = value;
    }

    public int values() { return this.value; }

}