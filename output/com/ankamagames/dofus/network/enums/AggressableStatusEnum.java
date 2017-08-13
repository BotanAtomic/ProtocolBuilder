package com.ankamagames.dofus.network.enums;

public enum AggressableStatusEnum {

    NON_AGGRESSABLE(0),
    PVP_ENABLED_AGGRESSABLE(10),
    PVP_ENABLED_NON_AGGRESSABLE(11),
    AVA_ENABLED_AGGRESSABLE(20),
    AVA_ENABLED_NON_AGGRESSABLE(21),
    AVA_DISQUALIFIED(22),
    AVA_PREQUALIFIED_AGGRESSABLE(23);

    private final int value;
    public AggressableStatusEnum(int value) {
        this.value = value;
    }

    public int value() {
      return this.value;
    }

    public AggressableStatusEnum get(int value) {
        return Stream.of(values()).filter(current -> current.value == value).findAny().orElse(null);
    }

}