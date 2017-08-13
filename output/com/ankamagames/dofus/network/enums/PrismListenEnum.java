package com.ankamagames.dofus.network.enums;

public enum PrismListenEnum {

    PRISM_LISTEN_NONE(0;),
    PRISM_LISTEN_MINE(1;),
    PRISM_LISTEN_ALL(2;);

    private final int value;
    public PrismListenEnum(int value) {
        this.value = value;
    }

    public int value() {
      return this.value;
    }

    public PrismListenEnum get(int value) {
        return Stream.of(values()).filter(current -> current.value == value).findAny().orElse(null);
    }

}