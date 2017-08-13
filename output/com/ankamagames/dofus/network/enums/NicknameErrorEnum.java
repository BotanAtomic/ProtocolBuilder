package com.ankamagames.dofus.network.enums;

public enum NicknameErrorEnum {

    ALREADY_USED(1;),
    SAME_AS_LOGIN(2;),
    TOO_SIMILAR_TO_LOGIN(3;),
    INVALID_NICK(4;),
    UNKNOWN_NICK_ERROR(99;);

    private final int value;
    public NicknameErrorEnum(int value) {
        this.value = value;
    }

    public int value() {
      return this.value;
    }

    public NicknameErrorEnum get(int value) {
        return Stream.of(values()).filter(current -> current.value == value).findAny().orElse(null);
    }

}