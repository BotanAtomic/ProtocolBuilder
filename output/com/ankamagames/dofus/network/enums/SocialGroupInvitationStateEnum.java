package com.ankamagames.dofus.network.enums;

public enum SocialGroupInvitationStateEnum {

    SOCIAL_GROUP_INVITATION_FAILED(0;),
    SOCIAL_GROUP_INVITATION_SENT(1;),
    SOCIAL_GROUP_INVITATION_CANCELED(2;),
    SOCIAL_GROUP_INVITATION_OK(3;);

    private final int value;
    public SocialGroupInvitationStateEnum(int value) {
        this.value = value;
    }

    public int value() {
      return this.value;
    }

    public SocialGroupInvitationStateEnum get(int value) {
        return Stream.of(values()).filter(current -> current.value == value).findAny().orElse(null);
    }

}