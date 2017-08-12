package org.graviton.network.protocol.enums;

public enum SocialGroupInvitationStateEnum {

    SOCIAL_GROUP_INVITATION_FAILED(0),
    SOCIAL_GROUP_INVITATION_SENT(1),
    SOCIAL_GROUP_INVITATION_CANCELED(2),
    SOCIAL_GROUP_INVITATION_OK(3);

    private final int value;
    public SocialGroupInvitationStateEnum(int value) {
        this.value = value;
    }

    public int values() { return this.value; }

}