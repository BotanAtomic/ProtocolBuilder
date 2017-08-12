package org.graviton.network.protocol.enums;

public enum PartyNameErrorEnum {

    PARTY_NAME_UNDEFINED_ERROR(0),
    PARTY_NAME_INVALID(1),
    PARTY_NAME_ALREADY_USED(2),
    PARTY_NAME_UNALLOWED_RIGHTS(3),
    PARTY_NAME_UNALLOWED_NOW(4);

    private final int value;
    public PartyNameErrorEnum(int value) {
        this.value = value;
    }

    public int values() { return this.value; }

}