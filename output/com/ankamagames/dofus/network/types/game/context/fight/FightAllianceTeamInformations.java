package com.ankamagames.dofus.network.types.game.context.fight;

import java.lang.Exception;
import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class FightAllianceTeamInformations extends FightTeamInformations implements INetworkType {

  public int relation = 0;
  public static final int protocolId = 439;

  @Override
  public void serialize(ICustomDataOutput param1) {
    param1.writeByte(this.teamId);
    if (this.leaderId < -9.007199254740992E15 || this.leaderId > 9.007199254740992E15) {
      throw new Error("Forbidden value (" + this.leaderId + ") on element leaderId.");
    }
    param1.writeDouble(this.leaderId);
    param1.writeByte(this.teamSide);
    param1.writeByte(this.teamTypeId);
    if (this.nbWaves < 0) {
      throw new Error("Forbidden value (" + this.nbWaves + ") on element nbWaves.");
    }
    param1.writeByte(this.nbWaves);

    param1.writeShort(this.teamMembers.length);
    int _loc2_ = 0;
    while (_loc2_ < this.teamMembers.length) {
      param1.writeShort(((FightTeamMemberInformations) (this.teamMembers[_loc2_])).getTypeId());
      ((FightTeamMemberInformations) this.teamMembers[_loc2_]).serialize(param1);
      _loc2_++;
    }

    param1.writeByte(this.relation);
  }

  @Override
  public void deserialize(ICustomDataInput param1) {
    this.uid = param1.readUTF();

    this.figure = param1.readVarUhShort();
    if (this.figure < 0) {
      throw new Error(
          "Forbidden value (" + this.figure + ") on element of KrosmasterFigure.figure.");
    }

    this.pedestal = param1.readVarUhShort();
    if (this.pedestal < 0) {
      throw new Error(
          "Forbidden value (" + this.pedestal + ") on element of KrosmasterFigure.pedestal.");
    }

    this.bound = param1.readBoolean();

    this.relation = param1.readByte();
    if (this.relation < 0) {
      throw new Error(
          "Forbidden value ("
              + this.relation
              + ") on element of FightAllianceTeamInformations.relation.");
    }
  }
}
