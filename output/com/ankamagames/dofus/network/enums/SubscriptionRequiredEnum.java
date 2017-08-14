package com.ankamagames.dofus.network.enums;

public enum SubscriptionRequiredEnum {
  LIMITED_TO_SUBSCRIBER(0),
  LIMIT_ON_JOB_XP(1),
  LIMIT_ON_JOB_USE(2),
  LIMIT_ON_MAP(3),
  LIMIT_ON_ITEM(4),
  LIMIT_ON_VENDOR(5);
  private final int value;

  public SubscriptionRequiredEnum(int value) {
    this.value = value;
  }

  public int value() {
    return this.value;
  }

  public SubscriptionRequiredEnum get(int value) {
    return Stream.of(values()).filter(current -> current.value == value).findAny().orElse(null);
  }
}
