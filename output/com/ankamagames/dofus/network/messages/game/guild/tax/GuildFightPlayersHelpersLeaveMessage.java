package com.ankamagames.dofus.network.messages.game.guild.tax;

import java.lang.Exception;
import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class GuildFightPlayersHelpersLeaveMessage extends NetworkMessage
    implements INetworkMessage {

  private boolean _isInitialized = false;
  public int fightId = 0;
  public Number playerId = 0;
  public static final int protocolId = 5719;

  public void serialize(ICustomDataOutput param1) {
    if (this.fightId < 0) {
      throw new Error("Forbidden value (" + this.fightId + ") on element fightId.");
    }
    param1.writeInt(this.fightId);
    if (this.playerId < 0 || this.playerId > 9.007199254740992E15) {
      throw new Error("Forbidden value (" + this.playerId + ") on element playerId.");
    }
    param1.writeVarLong(this.playerId);
  }

  public void deserialize(ICustomDataInput param1) {
    this.fightId = param1.readInt();

    this.playerId = param1.readVarUhLong();
    if (this.playerId < 0 || this.playerId > 9.007199254740992E15) {
      throw new Error(
          "Forbidden value (" + this.playerId + ") on element of TaxCollectorMovement.playerId.");
    }
  }
}
