package org.graviton.network.protocol.enums;

public enum ServerCompletionEnum {

    COMPLETION_RECOMANDATED(0),
    COMPLETION_AVERAGE(1),
    COMPLETION_HIGH(2),
    COMPLETION_COMING_SOON(3),
    COMPLETION_FULL(4);

    private final int value;
    public ServerCompletionEnum(int value) {
        this.value = value;
    }

    public int values() { return this.value; }

}