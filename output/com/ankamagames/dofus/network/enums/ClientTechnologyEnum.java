package com.ankamagames.dofus.network.enums;

public enum ClientTechnologyEnum {
  CLIENT_TECHNOLOGY_UNKNOWN(0),
  CLIENT_AIR(1),
  CLIENT_FLASH(2);
  private final int value;

  public ClientTechnologyEnum(int value) {
    this.value = value;
  }

  public int value() {
    return this.value;
  }

  public ClientTechnologyEnum get(int value) {
    return Stream.of(values()).filter(current -> current.value == value).findAny().orElse(null);
  }
}
