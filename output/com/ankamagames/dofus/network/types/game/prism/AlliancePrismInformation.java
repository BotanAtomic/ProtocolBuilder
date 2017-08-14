package com.ankamagames.dofus.network.types.game.prism;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.dofus.network.types.game.context.roleplay.AllianceInformations;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class AlliancePrismInformation extends PrismInformation implements INetworkType {

  public AllianceInformations alliance;
  private FuncTree _alliancetree;
  public static final int protocolId = 427;

  @Override
  public void serialize(ICustomDataOutput param1) {
    if (this.typeId < 0) {
      throw new Exception("Forbidden value (" + this.typeId + ") on element typeId.");
    }
    param1.writeByte(this.typeId);
    param1.writeByte(this.state);
    if (this.nextVulnerabilityDate < 0) {
      throw new Exception(
          "Forbidden value (" + this.nextVulnerabilityDate + ") on element nextVulnerabilityDate.");
    }
    param1.writeInt(this.nextVulnerabilityDate);
    if (this.placementDate < 0) {
      throw new Exception("Forbidden value (" + this.placementDate + ") on element placementDate.");
    }
    param1.writeInt(this.placementDate);
    if (this.rewardTokenCount < 0) {
      throw new Exception(
          "Forbidden value (" + this.rewardTokenCount + ") on element rewardTokenCount.");
    }
    param1.writeVarInt(this.rewardTokenCount);

    this.alliance.serializeAs_AllianceInformations(param1);
  }

  @Override
  public void deserialize(ICustomDataInput param1) {
    this.uid = param1.readUTF();

    this.figure = param1.readVarUhShort();
    if (this.figure < 0) {
      throw new Exception(
          "Forbidden value (" + this.figure + ") on element of KrosmasterFigure.figure.");
    }

    this.pedestal = param1.readVarUhShort();
    if (this.pedestal < 0) {
      throw new Exception(
          "Forbidden value (" + this.pedestal + ") on element of KrosmasterFigure.pedestal.");
    }

    this.bound = param1.readBoolean();

    this.alliance = new AllianceInformations();
    this.alliance.deserialize(param1);
  }
}
