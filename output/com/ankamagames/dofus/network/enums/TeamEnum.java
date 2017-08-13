package com.ankamagames.dofus.network.enums;

public enum TeamEnum {

    TEAM_CHALLENGER(0),
    TEAM_DEFENDER(1),
    TEAM_SPECTATOR(2);

    private final int value;
    public TeamEnum(int value) {
        this.value = value;
    }

    public int value() {
      return this.value;
    }

    public TeamEnum get(int value) {
        return Stream.of(values()).filter(current -> current.value == value).findAny().orElse(null);
    }

}