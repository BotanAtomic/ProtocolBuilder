package com.ankamagames.dofus.network.enums;

public enum PartyTypeEnum {

    PARTY_TYPE_UNDEFINED(0;),
    PARTY_TYPE_CLASSICAL(1;),
    PARTY_TYPE_DUNGEON(2;),
    PARTY_TYPE_ARENA(3;);

    private final int value;
    public PartyTypeEnum(int value) {
        this.value = value;
    }

    public int value() {
      return this.value;
    }

    public PartyTypeEnum get(int value) {
        return Stream.of(values()).filter(current -> current.value == value).findAny().orElse(null);
    }

}