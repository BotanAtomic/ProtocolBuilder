package com.ankamagames.dofus.network.enums;

public enum TextInformationTypeEnum {
  TEXT_INFORMATION_MESSAGE(0),
  TEXT_INFORMATION_ERROR(1),
  TEXT_INFORMATION_PVP(2),
  TEXT_INFORMATION_FIGHT_LOG(3),
  TEXT_INFORMATION_POPUP(4),
  TEXT_LIVING_OBJECT(5),
  TEXT_ENTITY_TALK(6),
  TEXT_INFORMATION_FIGHT(7);
  private final int value;

  public TextInformationTypeEnum(int value) {
    this.value = value;
  }

  public int value() {
    return this.value;
  }

  public TextInformationTypeEnum get(int value) {
    return Stream.of(values()).filter(current -> current.value == value).findAny().orElse(null);
  }
}
