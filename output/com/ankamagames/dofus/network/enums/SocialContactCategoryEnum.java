package com.ankamagames.dofus.network.enums;

public enum SocialContactCategoryEnum {
  SOCIAL_CONTACT_FRIEND(0),
  SOCIAL_CONTACT_SPOUSE(1),
  SOCIAL_CONTACT_PARTY(2),
  SOCIAL_CONTACT_GUILD(3),
  SOCIAL_CONTACT_ALLIANCE(4),
  SOCIAL_CONTACT_CRAFTER(5),
  SOCIAL_CONTACT_INTERLOCUTOR(6),
  SOCIAL_CONTACT_FIGHT(7);
  private final int value;

  public SocialContactCategoryEnum(int value) {
    this.value = value;
  }

  public int value() {
    return this.value;
  }

  public SocialContactCategoryEnum get(int value) {
    return Stream.of(values()).filter(current -> current.value == value).findAny().orElse(null);
  }
}
