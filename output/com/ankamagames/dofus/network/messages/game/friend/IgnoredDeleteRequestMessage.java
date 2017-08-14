package com.ankamagames.dofus.network.messages.game.friend;

import java.lang.Exception;
import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class IgnoredDeleteRequestMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public int accountId = 0;
  public boolean session = false;
  public static final int protocolId = 5680;

  public void serialize(ICustomDataOutput param1) {
    if (this.accountId < 0) {
      throw new Error("Forbidden value (" + this.accountId + ") on element accountId.");
    }
    param1.writeInt(this.accountId);
    param1.writeBoolean(this.session);
  }

  public void deserialize(ICustomDataInput param1) {
    this.accountId = param1.readInt();
    if (this.accountId < 0) {
      throw new Error(
          "Forbidden value (" + this.accountId + ") on element of GuildMember.accountId.");
    }

    this.session = param1.readBoolean();
  }
}
