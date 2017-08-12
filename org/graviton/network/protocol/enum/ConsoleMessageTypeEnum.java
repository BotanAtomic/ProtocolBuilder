package org.graviton.network.protocol.enums;

public enum ConsoleMessageTypeEnum {

    CONSOLE_TEXT_MESSAGE(0),
    CONSOLE_INFO_MESSAGE(1),
    CONSOLE_ERR_MESSAGE(2);

    private final int value;
    public ConsoleMessageTypeEnum(int value) {
        this.value = value;
    }

    public int values() { return this.value; }

}