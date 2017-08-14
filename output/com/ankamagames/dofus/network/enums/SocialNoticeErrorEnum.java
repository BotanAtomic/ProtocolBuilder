package com.ankamagames.dofus.network.enums;

public enum SocialNoticeErrorEnum {
  SOCIAL_NOTICE_UNKNOWN_ERROR(0),
  SOCIAL_NOTICE_INVALID_RIGHTS(1),
  SOCIAL_NOTICE_COOLDOWN(2);
  private final int value;

  public SocialNoticeErrorEnum(int value) {
    this.value = value;
  }

  public int value() {
    return this.value;
  }

  public SocialNoticeErrorEnum get(int value) {
    return Stream.of(values()).filter(current -> current.value == value).findAny().orElse(null);
  }
}
