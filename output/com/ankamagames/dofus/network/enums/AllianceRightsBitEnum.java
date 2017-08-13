package com.ankamagames.dofus.network.enums;

public enum AllianceRightsBitEnum {

    ALLIANCE_RIGHT_NONE(0;),
    ALLIANCE_RIGHT_BOSS(1;),
    ALLIANCE_RIGHT_MANAGE_PRISMS(2;),
    ALLIANCE_RIGHT_TALK_IN_CHAN(4;),
    ALLIANCE_RIGHT_RECRUIT_GUILDS(8;),
    ALLIANCE_RIGHT_KICK_GUILDS(16;),
    ALLIANCE_RIGHT_MANAGE_RIGHTS(32;);

    private final int value;
    public AllianceRightsBitEnum(int value) {
        this.value = value;
    }

    public int value() {
      return this.value;
    }

    public AllianceRightsBitEnum get(int value) {
        return Stream.of(values()).filter(current -> current.value == value).findAny().orElse(null);
    }

}