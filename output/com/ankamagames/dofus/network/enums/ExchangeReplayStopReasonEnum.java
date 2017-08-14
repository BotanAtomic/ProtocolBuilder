package com.ankamagames.dofus.network.enums;

public enum ExchangeReplayStopReasonEnum {
  STOPPED_REASON_OK(1),
  STOPPED_REASON_USER(2),
  STOPPED_REASON_MISSING_RESSOURCE(3),
  STOPPED_REASON_IMPOSSIBLE_MODIFICATION(4);
  private final int value;

  public ExchangeReplayStopReasonEnum(int value) {
    this.value = value;
  }

  public int value() {
    return this.value;
  }

  public ExchangeReplayStopReasonEnum get(int value) {
    return Stream.of(values()).filter(current -> current.value == value).findAny().orElse(null);
  }
}
