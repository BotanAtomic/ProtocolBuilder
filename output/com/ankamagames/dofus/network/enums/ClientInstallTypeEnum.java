package com.ankamagames.dofus.network.enums;

public enum ClientInstallTypeEnum {
  CLIENT_INSTALL_UNKNOWN(0),
  CLIENT_BUNDLE(1),
  CLIENT_STREAMING(2);
  private final int value;

  public ClientInstallTypeEnum(int value) {
    this.value = value;
  }

  public int value() {
    return this.value;
  }

  public ClientInstallTypeEnum get(int value) {
    return Stream.of(values()).filter(current -> current.value == value).findAny().orElse(null);
  }
}
