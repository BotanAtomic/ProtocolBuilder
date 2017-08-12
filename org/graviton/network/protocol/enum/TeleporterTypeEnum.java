package org.graviton.network.protocol.enums;

public enum TeleporterTypeEnum {

    TELEPORTER_ZAAP(0),
    TELEPORTER_SUBWAY(1),
    TELEPORTER_PRISM(2),
    TELEPORTER_HAVENBAG(3);

    private final int value;
    public TeleporterTypeEnum(int value) {
        this.value = value;
    }

    public int values() { return this.value; }

}