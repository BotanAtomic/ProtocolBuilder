package org.graviton.network.protocol.enums;

public enum NicknameGeneratingFailureEnum {

    NICKNAME_GENERATOR_RETRY_TOO_SHORT(1),
    NICKNAME_GENERATOR_UNAVAILABLE(2);

    private final int value;
    public NicknameGeneratingFailureEnum(int value) {
        this.value = value;
    }

    public int values() { return this.value; }

}