package com.ankamagames.dofus.network.enums;

public enum TeleporterTypeEnum {
  TELEPORTER_ZAAP(0),
  TELEPORTER_SUBWAY(1),
  TELEPORTER_PRISM(2),
  TELEPORTER_HAVENBAG(3);
  private final int value;

  public TeleporterTypeEnum(int value) {
    this.value = value;
  }

  public int value() {
    return this.value;
  }

  public TeleporterTypeEnum get(int value) {
    return Stream.of(values()).filter(current -> current.value == value).findAny().orElse(null);
  }
}
