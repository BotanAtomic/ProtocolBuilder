package com.ankamagames.dofus.network.enums;

public enum DirectionsEnum {
  DIRECTION_EAST(0),
  DIRECTION_SOUTH_EAST(1),
  DIRECTION_SOUTH(2),
  DIRECTION_SOUTH_WEST(3),
  DIRECTION_WEST(4),
  DIRECTION_NORTH_WEST(5),
  DIRECTION_NORTH(6),
  DIRECTION_NORTH_EAST(7);
  private final int value;

  public DirectionsEnum(int value) {
    this.value = value;
  }

  public int value() {
    return this.value;
  }

  public DirectionsEnum get(int value) {
    return Stream.of(values()).filter(current -> current.value == value).findAny().orElse(null);
  }
}
