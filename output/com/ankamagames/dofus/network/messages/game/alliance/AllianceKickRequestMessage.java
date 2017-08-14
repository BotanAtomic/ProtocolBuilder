package com.ankamagames.dofus.network.messages.game.alliance;

import java.lang.Exception;
import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class AllianceKickRequestMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public int kickedId = 0;
  public static final int protocolId = 6400;

  public void serialize(ICustomDataOutput param1) {
    if (this.kickedId < 0) {
      throw new Error("Forbidden value (" + this.kickedId + ") on element kickedId.");
    }
    param1.writeVarInt(this.kickedId);
  }

  public void deserialize(ICustomDataInput param1) {
    this.kickedId = param1.readVarUhLong();
    if (this.kickedId < 0 || this.kickedId > 9.007199254740992E15) {
      throw new Error(
          "Forbidden value ("
              + this.kickedId
              + ") on element of GuildKickRequestMessage.kickedId.");
    }
  }
}
