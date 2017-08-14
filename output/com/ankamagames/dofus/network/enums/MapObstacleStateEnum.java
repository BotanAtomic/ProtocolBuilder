package com.ankamagames.dofus.network.enums;

public enum MapObstacleStateEnum {
  OBSTACLE_OPENED(1),
  OBSTACLE_CLOSED(2);
  private final int value;

  public MapObstacleStateEnum(int value) {
    this.value = value;
  }

  public int value() {
    return this.value;
  }

  public MapObstacleStateEnum get(int value) {
    return Stream.of(values()).filter(current -> current.value == value).findAny().orElse(null);
  }
}
