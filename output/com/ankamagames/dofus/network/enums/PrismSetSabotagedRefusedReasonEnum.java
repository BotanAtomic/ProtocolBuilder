package com.ankamagames.dofus.network.enums;

public enum PrismSetSabotagedRefusedReasonEnum {

    SABOTAGE_REFUSED(-1),
    SABOTAGE_INSUFFICIENT_RIGHTS(0),
    SABOTAGE_MEMBER_ACCOUNT_NEEDED(1),
    SABOTAGE_RESTRICTED_ACCOUNT(2),
    SABOTAGE_WRONG_ALLIANCE(3),
    SABOTAGE_NO_PRISM(4),
    SABOTAGE_WRONG_STATE(5);

    private final int value;
    public PrismSetSabotagedRefusedReasonEnum(int value) {
        this.value = value;
    }

    public int value() {
      return this.value;
    }

    public PrismSetSabotagedRefusedReasonEnum get(int value) {
        return Stream.of(values()).filter(current -> current.value == value).findAny().orElse(null);
    }

}