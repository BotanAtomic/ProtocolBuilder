package com.ankamagames.dofus.network.types.game.context.fight;

import java.lang.Exception;
import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.dofus.network.ProtocolTypeManager;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class FightCommonInformations extends Object implements INetworkType {

  public int fightId = 0;
  public int fightType = 0;
  public Vector<FightTeamInformations> fightTeams;
  public Vector<uint> fightTeamsPositions;
  public Vector<FightOptionsInformations> fightTeamsOptions;
  private FuncTree _fightTeamstree;
  private FuncTree _fightTeamsPositionstree;
  private FuncTree _fightTeamsOptionstree;
  public static final int protocolId = 43;

  public void serialize(ICustomDataOutput param1) {
    param1.writeInt(this.fightId);
    param1.writeByte(this.fightType);
    param1.writeShort(this.fightTeams.length);
    int _loc2_ = 0;
    while (_loc2_ < this.fightTeams.length) {
      param1.writeShort(((FightTeamInformations) (this.fightTeams[_loc2_])).getTypeId());
      ((FightTeamInformations) this.fightTeams[_loc2_]).serialize(param1);
      _loc2_++;
    }
    param1.writeShort(this.fightTeamsPositions.length);
    int _loc3_ = 0;
    while (_loc3_ < this.fightTeamsPositions.length) {
      if (this.fightTeamsPositions[_loc3_] < 0 || this.fightTeamsPositions[_loc3_] > 559) {
        throw new Exception(
            "Forbidden value ("
                + this.fightTeamsPositions[_loc3_]
                + ") on element 4 (starting at 1) of fightTeamsPositions.");
      }
      param1.writeVarShort(this.fightTeamsPositions[_loc3_]);
      _loc3_++;
    }
    param1.writeShort(this.fightTeamsOptions.length);
    int _loc4_ = 0;
    while (_loc4_ < this.fightTeamsOptions.length) {
      ((FightOptionsInformations) this.fightTeamsOptions[_loc4_]).serializeAs_(param1);
      _loc4_++;
    }
  }

  public void deserialize(ICustomDataInput param1) {
    int _loc8_ = 0;
    FightTeamInformations _loc9_ = null;
    int _loc10_ = 0;
    FightOptionsInformations _loc11_ = null;
    this.fightId = param1.readInt();

    this.fightType = param1.readByte();
    if (this.fightType < 0) {
      throw new Exception(
          "Forbidden value ("
              + this.fightType
              + ") on element of FightExternalInformations.fightType.");
    }

    int _loc2_ = param1.readUnsignedShort();
    int _loc3_ = 0;
    while (_loc3_ < _loc2_) {
      _loc8_ = param1.readUnsignedShort();
      _loc9_ = ProtocolTypeManager.getInstance(FightTeamInformations, _loc8_);
      _loc9_.deserialize(param1);
      this.fightTeams.push(_loc9_);
      _loc3_++;
    }
    int _loc4_ = param1.readUnsignedShort();
    int _loc5_ = 0;
    while (_loc5_ < _loc4_) {
      _loc10_ = param1.readVarUhShort();
      if (_loc10_ < 0 || _loc10_ > 559) {
        throw new Exception(
            "Forbidden value (" + _loc10_ + ") on elements of fightTeamsPositions.");
      }
      this.fightTeamsPositions.push(_loc10_);
      _loc5_++;
    }
    int _loc6_ = param1.readUnsignedShort();
    int _loc7_ = 0;
    while (_loc7_ < _loc6_) {
      _loc11_ = new FightOptionsInformations();
      _loc11_.deserialize(param1);
      this.fightTeamsOptions.push(_loc11_);
      _loc7_++;
    }
  }
}
