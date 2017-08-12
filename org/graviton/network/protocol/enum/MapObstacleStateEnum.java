package org.graviton.network.protocol.enums;

public enum MapObstacleStateEnum {

    OBSTACLE_OPENED(1),
    OBSTACLE_CLOSED(2);

    private final int value;
    public MapObstacleStateEnum(int value) {
        this.value = value;
    }

    public int values() { return this.value; }

}