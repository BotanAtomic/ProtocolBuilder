package org.graviton.network.protocol.enums;

public enum HaapiTokenTypeEnum {

    HAAPI_APIKEY_GENERIC(0),
    HAAPI_APIKEY_SHOP(1);

    private final int value;
    public HaapiTokenTypeEnum(int value) {
        this.value = value;
    }

    public int values() { return this.value; }

}