package org.graviton.network.protocol.enums;

public enum TeamEnum {

    TEAM_CHALLENGER(0),
    TEAM_DEFENDER(1),
    TEAM_SPECTATOR(2);

    private final int value;
    public TeamEnum(int value) {
        this.value = value;
    }

    public int values() { return this.value; }

}