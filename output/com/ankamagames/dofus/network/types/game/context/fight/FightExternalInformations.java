package com.ankamagames.dofus.network.types.game.context.fight;

import java.lang.Exception;
import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class FightExternalInformations extends Object implements INetworkType {

  public int fightId = 0;
  public int fightType = 0;
  public int fightStart = 0;
  public boolean fightSpectatorLocked = false;
  public Vector<FightTeamLightInformations> fightTeams;
  public Vector<FightOptionsInformations> fightTeamsOptions;
  private FuncTree _fightTeamstree;
  private int _fightTeamsindex = 0;
  private FuncTree _fightTeamsOptionstree;
  private int _fightTeamsOptionsindex = 0;
  public static final int protocolId = 117;

  public void serialize(ICustomDataOutput param1) {
    param1.writeInt(this.fightId);
    param1.writeByte(this.fightType);
    if (this.fightStart < 0) {
      throw new Exception("Forbidden value (" + this.fightStart + ") on element fightStart.");
    }
    param1.writeInt(this.fightStart);
    param1.writeBoolean(this.fightSpectatorLocked);
    int _loc2_ = 0;
    while (_loc2_ < 2) {
      this.fightTeams[_loc2_].serializeAs_FightTeamLightInformations(param1);
      _loc2_++;
    }
    int _loc3_ = 0;
    while (_loc3_ < 2) {
      this.fightTeamsOptions[_loc3_].serializeAs_FightOptionsInformations(param1);
      _loc3_++;
    }
  }

  public void deserialize(ICustomDataInput param1) {
    this.fightId = param1.readInt();

    this.fightType = param1.readByte();
    if (this.fightType < 0) {
      throw new Exception(
          "Forbidden value ("
              + this.fightType
              + ") on element of FightExternalInformations.fightType.");
    }

    this.fightStart = param1.readInt();
    if (this.fightStart < 0) {
      throw new Exception(
          "Forbidden value ("
              + this.fightStart
              + ") on element of FightExternalInformations.fightStart.");
    }

    this.fightSpectatorLocked = param1.readBoolean();

    int _loc2_ = 0;
    while (_loc2_ < 2) {
      this.fightTeams[_loc2_] = new FightTeamLightInformations();
      this.fightTeams[_loc2_].deserialize(param1);
      _loc2_++;
    }
    int _loc3_ = 0;
    while (_loc3_ < 2) {
      this.fightTeamsOptions[_loc3_] = new FightOptionsInformations();
      this.fightTeamsOptions[_loc3_].deserialize(param1);
      _loc3_++;
    }
  }
}
