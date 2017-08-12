package org.graviton.network.protocol.enums;

public enum PartyTypeEnum {

    PARTY_TYPE_UNDEFINED(0),
    PARTY_TYPE_CLASSICAL(1),
    PARTY_TYPE_DUNGEON(2),
    PARTY_TYPE_ARENA(3);

    private final int value;
    public PartyTypeEnum(int value) {
        this.value = value;
    }

    public int values() { return this.value; }

}