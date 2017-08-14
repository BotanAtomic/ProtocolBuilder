package com.ankamagames.dofus.network.types.game.context.roleplay;

import java.lang.Exception;
import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class HumanOptionAlliance extends HumanOption implements INetworkType {

  public AllianceInformations allianceInformations;
  public int aggressable = 0;
  private FuncTree _allianceInformationstree;
  public static final int protocolId = 425;

  @Override
  public void serialize(ICustomDataOutput param1) {

    this.allianceInformations.serializeAs_AllianceInformations(param1);
    param1.writeByte(this.aggressable);
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

    this.allianceInformations = new AllianceInformations();
    this.allianceInformations.deserialize(param1);
    this.aggressable = param1.readByte();
    if (this.aggressable < 0) {
      throw new Exception(
          "Forbidden value ("
              + this.aggressable
              + ") on element of HumanOptionAlliance.aggressable.");
    }
  }
}
