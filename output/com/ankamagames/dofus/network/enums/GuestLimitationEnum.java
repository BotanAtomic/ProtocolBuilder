package com.ankamagames.dofus.network.enums;

public enum GuestLimitationEnum {

    LIMITED_TO_REGISTERED(0;),
    GUEST_LIMIT_ON_JOB_XP(1;),
    GUEST_LIMIT_ON_JOB_USE(2;),
    GUEST_LIMIT_ON_MAP(3;),
    GUEST_LIMIT_ON_ITEM(4;),
    GUEST_LIMIT_ON_VENDOR(5;),
    GUEST_LIMIT_ON_CHAT(6;),
    GUEST_LIMIT_ON_GUILD(7;);

    private final int value;
    public GuestLimitationEnum(int value) {
        this.value = value;
    }

    public int value() {
      return this.value;
    }

    public GuestLimitationEnum get(int value) {
        return Stream.of(values()).filter(current -> current.value == value).findAny().orElse(null);
    }

}