package com.ankamagames.dofus.network.enums;

public enum GuildInformationsTypeEnum {

    INFO_GENERAL(1),
    INFO_MEMBERS(2),
    INFO_BOOSTS(3),
    INFO_PADDOCKS(4),
    INFO_HOUSES(5),
    INFO_TAX_COLLECTOR_GUILD_ONLY(6),
    INFO_TAX_COLLECTOR_ALLIANCE(7),
    INFO_TAX_COLLECTOR_LEAVE(8);

    private final int value;
    public GuildInformationsTypeEnum(int value) {
        this.value = value;
    }

    public int value() {
      return this.value;
    }

    public GuildInformationsTypeEnum get(int value) {
        return Stream.of(values()).filter(current -> current.value == value).findAny().orElse(null);
    }

}