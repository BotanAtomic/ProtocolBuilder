package com.ankamagames.dofus.network.messages.game.social;

import java.lang.Exception;
import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class ContactLookErrorMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public int requestId = 0;
  public static final int protocolId = 6045;

  public void serialize(ICustomDataOutput param1) {
    if (this.requestId < 0) {
      throw new Error("Forbidden value (" + this.requestId + ") on element requestId.");
    }
    param1.writeVarInt(this.requestId);
  }

  public void deserialize(ICustomDataInput param1) {
    this.requestId = param1.readUnsignedByte();
    if (this.requestId < 0 || this.requestId > 255) {
      throw new Error(
          "Forbidden value ("
              + this.requestId
              + ") on element of ContactLookRequestMessage.requestId.");
    }
  }
}
