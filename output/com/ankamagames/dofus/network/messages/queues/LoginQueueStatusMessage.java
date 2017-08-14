package com.ankamagames.dofus.network.messages.queues;

import java.lang.Exception;
import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class LoginQueueStatusMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public int position = 0;
  public int total = 0;
  public static final int protocolId = 10;

  public void serialize(ICustomDataOutput param1) {
    if (this.position < 0 || this.position > 65535) {
      throw new Exception("Forbidden value (" + this.position + ") on element position.");
    }
    param1.writeShort(this.position);
    if (this.total < 0 || this.total > 65535) {
      throw new Exception("Forbidden value (" + this.total + ") on element total.");
    }
    param1.writeShort(this.total);
  }

  public void deserialize(ICustomDataInput param1) {
    this.position = param1.readUnsignedByte();
    if (this.position < 0 || this.position > 255) {
      throw new Exception(
          "Forbidden value (" + this.position + ") on element of PresetItem.position.");
    }

    this.total = param1.readVarUhShort();
    if (this.total < 0) {
      throw new Exception(
          "Forbidden value (" + this.total + ") on element of MailStatusMessage.total.");
    }
  }
}
