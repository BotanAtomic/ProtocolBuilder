package org.graviton.network.protocol.enums;

public enum ExchangeReplayStopReasonEnum {

    STOPPED_REASON_OK(1),
    STOPPED_REASON_USER(2),
    STOPPED_REASON_MISSING_RESSOURCE(3),
    STOPPED_REASON_IMPOSSIBLE_MODIFICATION(4);

    private final int value;
    public ExchangeReplayStopReasonEnum(int value) {
        this.value = value;
    }

    public int values() { return this.value; }

}