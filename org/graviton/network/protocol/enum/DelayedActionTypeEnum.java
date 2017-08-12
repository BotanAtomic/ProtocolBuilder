package org.graviton.network.protocol.enums;

public enum DelayedActionTypeEnum {

    DELAYED_ACTION_DISCONNECT(0),
    DELAYED_ACTION_OBJECT_USE(1),
    DELAYED_ACTION_JOIN_CHARACTER(2),
    DELAYED_ACTION_AGGRESSION_IMMUNE(3);

    private final int value;
    public DelayedActionTypeEnum(int value) {
        this.value = value;
    }

    public int values() { return this.value; }

}