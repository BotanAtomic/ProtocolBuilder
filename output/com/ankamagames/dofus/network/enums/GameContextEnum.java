package com.ankamagames.dofus.network.enums;

public enum GameContextEnum {

    ROLE_PLAY(1),
    FIGHT(2);

    private final int value;
    public GameContextEnum(int value) {
        this.value = value;
    }

    public int value() {
      return this.value;
    }

    public GameContextEnum get(int value) {
        return Stream.of(values()).filter(current -> current.value == value).findAny().orElse(null);
    }

}