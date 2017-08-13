package com.ankamagames.dofus.network.enums;

public enum ConsoleMessageTypeEnum {

    CONSOLE_TEXT_MESSAGE(0),
    CONSOLE_INFO_MESSAGE(1),
    CONSOLE_ERR_MESSAGE(2);

    private final int value;
    public ConsoleMessageTypeEnum(int value) {
        this.value = value;
    }

    public int value() {
      return this.value;
    }

    public ConsoleMessageTypeEnum get(int value) {
        return Stream.of(values()).filter(current -> current.value == value).findAny().orElse(null);
    }

}