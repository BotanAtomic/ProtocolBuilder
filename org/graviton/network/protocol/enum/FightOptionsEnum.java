package org.graviton.network.protocol.enums;

public enum FightOptionsEnum {

    FIGHT_OPTION_SET_SECRET(0),
    FIGHT_OPTION_SET_TO_PARTY_ONLY(1),
    FIGHT_OPTION_SET_CLOSED(2),
    FIGHT_OPTION_ASK_FOR_HELP(3);

    private final int value;
    public FightOptionsEnum(int value) {
        this.value = value;
    }

    public int values() { return this.value; }

}