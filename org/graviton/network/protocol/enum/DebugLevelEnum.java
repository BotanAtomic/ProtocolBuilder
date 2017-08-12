package org.graviton.network.protocol.enums;

public enum DebugLevelEnum {

    LEVEL_TRACE(0),
    LEVEL_DEBUG(1),
    LEVEL_INFO(2),
    LEVEL_WARN(3),
    LEVEL_ERROR(4),
    LEVEL_FATAL(5);

    private final int value;
    public DebugLevelEnum(int value) {
        this.value = value;
    }

    public int values() { return this.value; }

}