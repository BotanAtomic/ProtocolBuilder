package com.ankamagames.dofus.network.enums;

public enum PlayableBreedEnum {
  UNDEFINED(0),
  FECA(1),
  OSAMODAS(2),
  ENUTROF(3),
  SRAM(4),
  XELOR(5),
  ECAFLIP(6),
  ENIRIPSA(7),
  IOP(8),
  CRA(9),
  SADIDA(10),
  SACRIEUR(11),
  PANDAWA(12),
  ROUBLARD(13),
  ZOBAL(14),
  STEAMER(15),
  ELIOTROPE(16),
  HUPPERMAGE(17),
  OUGINAK(18);
  private final int value;

  public PlayableBreedEnum(int value) {
    this.value = value;
  }

  public int value() {
    return this.value;
  }

  public PlayableBreedEnum get(int value) {
    return Stream.of(values()).filter(current -> current.value == value).findAny().orElse(null);
  }
}
