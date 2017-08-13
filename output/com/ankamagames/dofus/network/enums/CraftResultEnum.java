package com.ankamagames.dofus.network.enums;

public enum CraftResultEnum {

    CRAFT_IMPOSSIBLE(0;),
    CRAFT_FAILED(1;),
    CRAFT_SUCCESS(2;),
    CRAFT_NEUTRAL(3;);

    private final int value;
    public CraftResultEnum(int value) {
        this.value = value;
    }

    public int value() {
      return this.value;
    }

    public CraftResultEnum get(int value) {
        return Stream.of(values()).filter(current -> current.value == value).findAny().orElse(null);
    }

}