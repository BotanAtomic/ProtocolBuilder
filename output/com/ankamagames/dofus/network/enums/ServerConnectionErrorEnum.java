package com.ankamagames.dofus.network.enums;

public enum ServerConnectionErrorEnum {

    SERVER_CONNECTION_ERROR_DUE_TO_STATUS(0;),
    SERVER_CONNECTION_ERROR_NO_REASON(1;),
    SERVER_CONNECTION_ERROR_ACCOUNT_RESTRICTED(2;),
    SERVER_CONNECTION_ERROR_COMMUNITY_RESTRICTED(3;),
    SERVER_CONNECTION_ERROR_LOCATION_RESTRICTED(4;),
    SERVER_CONNECTION_ERROR_SUBSCRIBERS_ONLY(5;),
    SERVER_CONNECTION_ERROR_REGULAR_PLAYERS_ONLY(6;);

    private final int value;
    public ServerConnectionErrorEnum(int value) {
        this.value = value;
    }

    public int value() {
      return this.value;
    }

    public ServerConnectionErrorEnum get(int value) {
        return Stream.of(values()).filter(current -> current.value == value).findAny().orElse(null);
    }

}