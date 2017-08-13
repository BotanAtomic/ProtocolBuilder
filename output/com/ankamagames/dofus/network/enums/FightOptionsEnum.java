package com.ankamagames.dofus.network.enums;

public enum FightOptionsEnum {

    FIGHT_OPTION_SET_SECRET(0;),
    FIGHT_OPTION_SET_TO_PARTY_ONLY(1;),
    FIGHT_OPTION_SET_CLOSED(2;),
    FIGHT_OPTION_ASK_FOR_HELP(3;);

    private final int value;
    public FightOptionsEnum(int value) {
        this.value = value;
    }

    public int value() {
      return this.value;
    }

    public FightOptionsEnum get(int value) {
        return Stream.of(values()).filter(current -> current.value == value).findAny().orElse(null);
    }

}