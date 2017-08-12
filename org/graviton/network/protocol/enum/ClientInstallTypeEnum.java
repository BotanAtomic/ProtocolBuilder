package org.graviton.network.protocol.enums;

public enum ClientInstallTypeEnum {

    CLIENT_INSTALL_UNKNOWN(0),
    CLIENT_BUNDLE(1),
    CLIENT_STREAMING(2);

    private final int value;
    public ClientInstallTypeEnum(int value) {
        this.value = value;
    }

    public int values() { return this.value; }

}