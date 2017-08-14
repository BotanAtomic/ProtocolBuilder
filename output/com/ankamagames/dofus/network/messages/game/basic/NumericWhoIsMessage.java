package com.ankamagames.dofus.network.messages.game.basic;

import java.lang.Exception;
import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class NumericWhoIsMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public Number playerId = 0;
  public int accountId = 0;
  public static final int protocolId = 6297;

  public void serialize(ICustomDataOutput param1) {
    if (this.playerId < 0 || this.playerId > 9.007199254740992E15) {
      throw new Exception("Forbidden value (" + this.playerId + ") on element playerId.");
    }
    param1.writeVarLong(this.playerId);
    if (this.accountId < 0) {
      throw new Exception("Forbidden value (" + this.accountId + ") on element accountId.");
    }
    param1.writeInt(this.accountId);
  }

  public void deserialize(ICustomDataInput param1) {
    this.playerId = param1.readVarUhLong();
    if (this.playerId < 0 || this.playerId > 9.007199254740992E15) {
      throw new Exception(
          "Forbidden value (" + this.playerId + ") on element of TaxCollectorMovement.playerId.");
    }

    this.accountId = param1.readInt();
    if (this.accountId < 0) {
      throw new Exception(
          "Forbidden value (" + this.accountId + ") on element of GuildMember.accountId.");
    }
  }
}
