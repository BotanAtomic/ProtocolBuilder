package com.ankamagames.dofus.network.types.game.prism;

import java.lang.Exception;
import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class PrismInformation extends Object implements INetworkType {

  public int typeId = 0;
  public int state = 1;
  public int nextVulnerabilityDate = 0;
  public int placementDate = 0;
  public int rewardTokenCount = 0;
  public static final int protocolId = 428;

  public void serialize(ICustomDataOutput param1) {
    if (this.typeId < 0) {
      throw new Error("Forbidden value (" + this.typeId + ") on element typeId.");
    }
    param1.writeByte(this.typeId);
    param1.writeByte(this.state);
    if (this.nextVulnerabilityDate < 0) {
      throw new Error(
          "Forbidden value (" + this.nextVulnerabilityDate + ") on element nextVulnerabilityDate.");
    }
    param1.writeInt(this.nextVulnerabilityDate);
    if (this.placementDate < 0) {
      throw new Error("Forbidden value (" + this.placementDate + ") on element placementDate.");
    }
    param1.writeInt(this.placementDate);
    if (this.rewardTokenCount < 0) {
      throw new Error(
          "Forbidden value (" + this.rewardTokenCount + ") on element rewardTokenCount.");
    }
    param1.writeVarInt(this.rewardTokenCount);
  }

  public void deserialize(ICustomDataInput param1) {
    this.typeId = param1.readByte();
    if (this.typeId < 0) {
      throw new Error(
          "Forbidden value (" + this.typeId + ") on element of PrismInformation.typeId.");
    }

    this.state = param1.readByte();
    if (this.state < 0) {
      throw new Error("Forbidden value (" + this.state + ") on element of ContentPart.state.");
    }

    this.nextVulnerabilityDate = param1.readInt();
    if (this.nextVulnerabilityDate < 0) {
      throw new Error(
          "Forbidden value ("
              + this.nextVulnerabilityDate
              + ") on element of PrismInformation.nextVulnerabilityDate.");
    }

    this.placementDate = param1.readInt();
    if (this.placementDate < 0) {
      throw new Error(
          "Forbidden value ("
              + this.placementDate
              + ") on element of PrismInformation.placementDate.");
    }

    this.rewardTokenCount = param1.readVarUhInt();
    if (this.rewardTokenCount < 0) {
      throw new Error(
          "Forbidden value ("
              + this.rewardTokenCount
              + ") on element of PrismInformation.rewardTokenCount.");
    }
  }
}
