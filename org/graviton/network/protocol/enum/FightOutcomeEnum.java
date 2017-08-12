package org.graviton.network.protocol.enums;

public enum FightOutcomeEnum {

    RESULT_LOST(0),
    RESULT_DRAW(1),
    RESULT_VICTORY(2),
    RESULT_TAX(5),
    RESULT_DEFENDER_GROUP(6);

    private final int value;
    public FightOutcomeEnum(int value) {
        this.value = value;
    }

    public int values() { return this.value; }

}