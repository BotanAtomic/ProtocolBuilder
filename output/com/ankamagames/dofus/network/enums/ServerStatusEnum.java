package com.ankamagames.dofus.network.enums;

public enum ServerStatusEnum {
  STATUS_UNKNOWN(0),
  OFFLINE(1),
  STARTING(2),
  ONLINE(3),
  NOJOIN(4),
  SAVING(5),
  STOPING(6),
  FULL(7);
  private final int value;

  public ServerStatusEnum(int value) {
    this.value = value;
  }

  public int value() {
    return this.value;
  }

  public ServerStatusEnum get(int value) {
    return Stream.of(values()).filter(current -> current.value == value).findAny().orElse(null);
  }
}
