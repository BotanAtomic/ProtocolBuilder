package org.graviton.network.protocol.enums;

public enum PrismListenEnum {

    PRISM_LISTEN_NONE(0),
    PRISM_LISTEN_MINE(1),
    PRISM_LISTEN_ALL(2);

    private final int value;
    public PrismListenEnum(int value) {
        this.value = value;
    }

    public int values() { return this.value; }

}