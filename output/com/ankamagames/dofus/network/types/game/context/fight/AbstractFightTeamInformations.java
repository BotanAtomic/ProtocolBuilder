package com.ankamagames.dofus.network.types.game.context.fight;

import java.lang.Exception;
import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class AbstractFightTeamInformations extends Object implements INetworkType {

  public int teamId = 2;
  public Number leaderId = 0;
  public int teamSide = 0;
  public int teamTypeId = 0;
  public int nbWaves = 0;
  public static final int protocolId = 116;

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
  }

  public void deserialize(ICustomDataInput param1) {
    this.teamId = param1.readByte();
    if (this.teamId < 0) {
      throw new Exception(
          "Forbidden value (" + this.teamId + ") on element of NamedPartyTeam.teamId.");
    }

    this.leaderId = param1.readVarUhLong();
    if (this.leaderId < 0 || this.leaderId > 9.007199254740992E15) {
      throw new Exception(
          "Forbidden value ("
              + this.leaderId
              + ") on element of GuildVersatileInformations.leaderId.");
    }

    this.teamSide = param1.readByte();

    this.teamTypeId = param1.readByte();
    if (this.teamTypeId < 0) {
      throw new Exception(
          "Forbidden value ("
              + this.teamTypeId
              + ") on element of AbstractFightTeamInformations.teamTypeId.");
    }

    this.nbWaves = param1.readByte();
    if (this.nbWaves < 0) {
      throw new Exception(
          "Forbidden value ("
              + this.nbWaves
              + ") on element of GameRolePlayGroupMonsterWaveInformations.nbWaves.");
    }
  }
}
