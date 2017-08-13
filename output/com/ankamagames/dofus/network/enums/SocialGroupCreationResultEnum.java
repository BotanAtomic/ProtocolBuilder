package com.ankamagames.dofus.network.enums;

public enum SocialGroupCreationResultEnum {

    SOCIAL_GROUP_CREATE_OK(1;),
    SOCIAL_GROUP_CREATE_ERROR_NAME_INVALID(2;),
    SOCIAL_GROUP_CREATE_ERROR_ALREADY_IN_GROUP(3;),
    SOCIAL_GROUP_CREATE_ERROR_NAME_ALREADY_EXISTS(4;),
    SOCIAL_GROUP_CREATE_ERROR_EMBLEM_ALREADY_EXISTS(5;),
    SOCIAL_GROUP_CREATE_ERROR_LEAVE(6;),
    SOCIAL_GROUP_CREATE_ERROR_CANCEL(7;),
    SOCIAL_GROUP_CREATE_ERROR_REQUIREMENT_UNMET(8;),
    SOCIAL_GROUP_CREATE_ERROR_EMBLEM_INVALID(9;),
    SOCIAL_GROUP_CREATE_ERROR_TAG_INVALID(10;),
    SOCIAL_GROUP_CREATE_ERROR_TAG_ALREADY_EXISTS(11;),
    SOCIAL_GROUP_CREATE_ERROR_NEEDS_SUBGROUP(12;),
    SOCIAL_GROUP_CREATE_ERROR_UNKNOWN(99;);

    private final int value;
    public SocialGroupCreationResultEnum(int value) {
        this.value = value;
    }

    public int value() {
      return this.value;
    }

    public SocialGroupCreationResultEnum get(int value) {
        return Stream.of(values()).filter(current -> current.value == value).findAny().orElse(null);
    }

}