package com.ankamagames.dofus.network.enums;

public enum NicknameGeneratingFailureEnum {

    NICKNAME_GENERATOR_RETRY_TOO_SHORT(1;),
    NICKNAME_GENERATOR_UNAVAILABLE(2;);

    private final int value;
    public NicknameGeneratingFailureEnum(int value) {
        this.value = value;
    }

    public int value() {
      return this.value;
    }

    public NicknameGeneratingFailureEnum get(int value) {
        return Stream.of(values()).filter(current -> current.value == value).findAny().orElse(null);
    }

}