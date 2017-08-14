package com.ankamagames.dofus.network.types.game.context.fight;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.dofus.network.ProtocolTypeManager;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class FightTeamInformations extends AbstractFightTeamInformations implements INetworkType {

  public Vector<FightTeamMemberInformations> teamMembers;
  private FuncTree _teamMemberstree;
  public static final int protocolId = 33;

  @Override
  public void serialize(ICustomDataOutput param1) {
    param1.writeByte(this.teamId);
    if (this.leaderId < -9.007199254740992E15 || this.leaderId > 9.007199254740992E15) {
      throw new Exception("Forbidden value (" + this.leaderId + ") on element leaderId.");
    }
    param1.writeDouble(this.leaderId);
    param1.writeByte(this.teamSide);
    param1.writeByte(this.teamTypeId);
    if (this.nbWaves < 0) {
      throw new Exception("Forbidden value (" + this.nbWaves + ") on element nbWaves.");
    }
    param1.writeByte(this.nbWaves);

    param1.writeShort(this.teamMembers.length);
    int _loc2_ = 0;
    while (_loc2_ < this.teamMembers.length) {
      param1.writeShort(((FightTeamMemberInformations) (this.teamMembers[_loc2_])).getTypeId());
      ((FightTeamMemberInformations) this.teamMembers[_loc2_]).serialize(param1);
      _loc2_++;
    }
  }

  @Override
  public void deserialize(ICustomDataInput param1) {
    int _loc4_ = 0;
    FightTeamMemberInformations _loc5_ = null;
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

    int _loc2_ = param1.readUnsignedShort();
    int _loc3_ = 0;
    while (_loc3_ < _loc2_) {
      _loc4_ = param1.readUnsignedShort();
      _loc5_ = ProtocolTypeManager.getInstance(FightTeamMemberInformations, _loc4_);
      _loc5_.deserialize(param1);
      this.teamMembers.push(_loc5_);
      _loc3_++;
    }
  }
}
