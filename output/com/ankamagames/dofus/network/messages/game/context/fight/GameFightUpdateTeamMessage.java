package com.ankamagames.dofus.network.messages.game.context.fight;

import java.lang.Exception;
import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.context.fight.FightTeamInformations;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class GameFightUpdateTeamMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public int fightId = 0;
  public FightTeamInformations team;
  private FuncTree _teamtree;
  public static final int protocolId = 5572;

  public void serialize(ICustomDataOutput param1) {
    if (this.fightId < 0) {
      throw new Exception("Forbidden value (" + this.fightId + ") on element fightId.");
    }
    param1.writeShort(this.fightId);
    this.team.serializeAs_FightTeamInformations(param1);
  }

  public void deserialize(ICustomDataInput param1) {
    this.fightId = param1.readInt();

    this.team = new FightTeamInformations();
    this.team.deserialize(param1);
  }
}
