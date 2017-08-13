package com.ankamagames.dofus.network.enums;

public enum HaapiTokenTypeEnum {

    HAAPI_APIKEY_GENERIC(0;),
    HAAPI_APIKEY_SHOP(1;);

    private final int value;
    public HaapiTokenTypeEnum(int value) {
        this.value = value;
    }

    public int value() {
      return this.value;
    }

    public HaapiTokenTypeEnum get(int value) {
        return Stream.of(values()).filter(current -> current.value == value).findAny().orElse(null);
    }

}