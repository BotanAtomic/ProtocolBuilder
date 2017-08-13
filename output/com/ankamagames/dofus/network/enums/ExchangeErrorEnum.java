package com.ankamagames.dofus.network.enums;

public enum ExchangeErrorEnum {

    REQUEST_IMPOSSIBLE(1),
    REQUEST_CHARACTER_OCCUPIED(2),
    REQUEST_CHARACTER_JOB_NOT_EQUIPED(3),
    REQUEST_CHARACTER_TOOL_TOO_FAR(4),
    REQUEST_CHARACTER_OVERLOADED(5),
    REQUEST_CHARACTER_NOT_SUSCRIBER(6),
    REQUEST_CHARACTER_RESTRICTED(7),
    REQUEST_CHARACTER_GUEST(8),
    SELL_ERROR(63),
    BUY_ERROR(64),
    MOUNT_PADDOCK_ERROR(10),
    BID_SEARCH_ERROR(11);

    private final int value;
    public ExchangeErrorEnum(int value) {
        this.value = value;
    }

    public int value() {
      return this.value;
    }

    public ExchangeErrorEnum get(int value) {
        return Stream.of(values()).filter(current -> current.value == value).findAny().orElse(null);
    }

}