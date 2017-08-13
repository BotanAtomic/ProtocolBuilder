package com.ankamagames.dofus.network.enums;

public enum PartyNameErrorEnum {

    PARTY_NAME_UNDEFINED_ERROR(0;),
    PARTY_NAME_INVALID(1;),
    PARTY_NAME_ALREADY_USED(2;),
    PARTY_NAME_UNALLOWED_RIGHTS(3;),
    PARTY_NAME_UNALLOWED_NOW(4;);

    private final int value;
    public PartyNameErrorEnum(int value) {
        this.value = value;
    }

    public int value() {
      return this.value;
    }

    public PartyNameErrorEnum get(int value) {
        return Stream.of(values()).filter(current -> current.value == value).findAny().orElse(null);
    }

}