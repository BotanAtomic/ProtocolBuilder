package org.graviton.network.protocol.enums;

public enum ClientTechnologyEnum {

    CLIENT_TECHNOLOGY_UNKNOWN(0),
    CLIENT_AIR(1),
    CLIENT_FLASH(2);

    private final int value;
    public ClientTechnologyEnum(int value) {
        this.value = value;
    }

    public int values() { return this.value; }

}