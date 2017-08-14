package com.ankamagames.dofus.network.types.game.context.fight;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.dofus.network.types.game.context.roleplay.BasicAllianceInformations;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class FightTeamMemberWithAllianceCharacterInformations
    extends FightTeamMemberCharacterInformations implements INetworkType {

  public BasicAllianceInformations allianceInfos;
  private FuncTree _allianceInfostree;
  public static final int protocolId = 426;

  @Override
  public void serialize(ICustomDataOutput param1) {
    if (this.id < -9.007199254740992E15 || this.id > 9.007199254740992E15) {
      throw new Exception("Forbidden value (" + this.id + ") on element id.");
    }
    param1.writeDouble(this.id);

    param1.writeUTF(this.name);
    if (this.level < 0 || this.level > 255) {
      throw new Exception("Forbidden value (" + this.level + ") on element level.");
    }
    param1.writeByte(this.level);

    this.allianceInfos.serializeAs_BasicAllianceInformations(param1);
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

    this.allianceInfos = new BasicAllianceInformations();
    this.allianceInfos.deserialize(param1);
  }
}
