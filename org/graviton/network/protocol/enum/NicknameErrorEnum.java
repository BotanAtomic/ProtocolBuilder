package org.graviton.network.protocol.enums;

public enum NicknameErrorEnum {

    ALREADY_USED(1),
    SAME_AS_LOGIN(2),
    TOO_SIMILAR_TO_LOGIN(3),
    INVALID_NICK(4),
    UNKNOWN_NICK_ERROR(99);

    private final int value;
    public NicknameErrorEnum(int value) {
        this.value = value;
    }

    public int values() { return this.value; }

}