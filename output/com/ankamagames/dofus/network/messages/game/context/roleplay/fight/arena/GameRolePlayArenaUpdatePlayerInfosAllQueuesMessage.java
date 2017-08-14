package com.ankamagames.dofus.network.messages.game.context.roleplay.fight.arena;

import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.context.roleplay.fight.arena.ArenaRankInfos;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class GameRolePlayArenaUpdatePlayerInfosAllQueuesMessage
    extends GameRolePlayArenaUpdatePlayerInfosMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public ArenaRankInfos team;
  public ArenaRankInfos duel;
  private FuncTree _teamtree;
  private FuncTree _dueltree;
  public static final int protocolId = 6728;

  @Override
  public void serialize(ICustomDataOutput param1) {
    this.solo.serializeAs_ArenaRankInfos(param1);

    this.team.serializeAs_ArenaRankInfos(param1);
    this.duel.serializeAs_ArenaRankInfos(param1);
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

    this.team = new ArenaRankInfos();
    this.team.deserialize(param1);
    this.duel = new ArenaRankInfos();
    this.duel.deserialize(param1);
  }
}
