package com.ankamagames.dofus.network.enums;

public enum PartyJoinErrorEnum {

    PARTY_JOIN_ERROR_UNKNOWN(0;),
    PARTY_JOIN_ERROR_PLAYER_NOT_FOUND(1;),
    PARTY_JOIN_ERROR_PARTY_NOT_FOUND(2;),
    PARTY_JOIN_ERROR_PARTY_FULL(3;),
    PARTY_JOIN_ERROR_PLAYER_BUSY(4;),
    PARTY_JOIN_ERROR_PLAYER_ALREADY_INVITED(6;),
    PARTY_JOIN_ERROR_PLAYER_TOO_SOLLICITED(7;),
    PARTY_JOIN_ERROR_PLAYER_LOYAL(8;),
    PARTY_JOIN_ERROR_UNMODIFIABLE(9;),
    PARTY_JOIN_ERROR_UNMET_CRITERION(10;),
    PARTY_JOIN_ERROR_NOT_ENOUGH_ROOM(11;),
    PARTY_JOIN_ERROR_COMPOSITION_CHANGED(12;),
    PARTY_JOIN_ERROR_PLAYER_IN_TUTORIAL(13;);

    private final int value;
    public PartyJoinErrorEnum(int value) {
        this.value = value;
    }

    public int value() {
      return this.value;
    }

    public PartyJoinErrorEnum get(int value) {
        return Stream.of(values()).filter(current -> current.value == value).findAny().orElse(null);
    }

}