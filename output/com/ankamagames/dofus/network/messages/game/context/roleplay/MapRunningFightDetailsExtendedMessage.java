package com.ankamagames.dofus.network.messages.game.context.roleplay;

import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.context.roleplay.party.NamedPartyTeam;
import com.ankamagames.dofus.network.types.game.context.fight.GameFightFighterLightInformations;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class MapRunningFightDetailsExtendedMessage extends MapRunningFightDetailsMessage
    implements INetworkMessage {

  private boolean _isInitialized = false;
  public Vector<NamedPartyTeam> namedPartyTeams;
  private FuncTree _namedPartyTeamstree;
  public static final int protocolId = 6500;

  @Override
  public void serialize(ICustomDataOutput param1) {
    if (this.fightId < 0) {
      throw new Error("Forbidden value (" + this.fightId + ") on element fightId.");
    }
    param1.writeInt(this.fightId);
    param1.writeShort(this.attackers.length);
    int _loc2_ = 0;
    while (_loc2_ < this.attackers.length) {
      param1.writeShort(((GameFightFighterLightInformations) (this.attackers[_loc2_])).getTypeId());
      ((GameFightFighterLightInformations) this.attackers[_loc2_]).serialize(param1);
      _loc2_++;
    }
    param1.writeShort(this.defenders.length);
    int _loc3_ = 0;
    while (_loc3_ < this.defenders.length) {
      param1.writeShort(((GameFightFighterLightInformations) (this.defenders[_loc3_])).getTypeId());
      ((GameFightFighterLightInformations) this.defenders[_loc3_]).serialize(param1);
      _loc3_++;
    }

    param1.writeShort(this.namedPartyTeams.length);
    int _loc2_ = 0;
    while (_loc2_ < this.namedPartyTeams.length) {
      ((NamedPartyTeam) this.namedPartyTeams[_loc2_]).serializeAs_(param1);
      _loc2_++;
    }
  }

  @Override
  public void deserialize(ICustomDataInput param1) {
    NamedPartyTeam _loc4_ = null;
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

    int _loc2_ = param1.readUnsignedShort();
    int _loc3_ = 0;
    while (_loc3_ < _loc2_) {
      _loc4_ = new NamedPartyTeam();
      _loc4_.deserialize(param1);
      this.namedPartyTeams.push(_loc4_);
      _loc3_++;
    }
  }
}
