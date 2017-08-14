package com.ankamagames.dofus.network.messages.game.context.roleplay.fight.arena;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class GameRolePlayArenaFighterStatusMessage extends NetworkMessage
    implements INetworkMessage {

  private boolean _isInitialized = false;
  public int fightId = 0;
  public int playerId = 0;
  public boolean accepted = false;
  public static final int protocolId = 6281;

  public void serialize(ICustomDataOutput param1) {
    param1.writeInt(this.fightId);
    param1.writeInt(this.playerId);
    param1.writeBoolean(this.accepted);
  }

  public void deserialize(ICustomDataInput param1) {
    this.fightId = param1.readInt();

    this.playerId = param1.readVarUhLong();
    if (this.playerId < 0 || this.playerId > 9.007199254740992E15) {
      throw new Exception(
          "Forbidden value (" + this.playerId + ") on element of TaxCollectorMovement.playerId.");
    }

    this.accepted = param1.readBoolean();
  }
}
