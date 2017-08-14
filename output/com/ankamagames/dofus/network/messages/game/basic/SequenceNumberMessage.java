package com.ankamagames.dofus.network.messages.game.basic;

import java.lang.Exception;
import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class SequenceNumberMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public int number = 0;
  public static final int protocolId = 6317;

  public void serialize(ICustomDataOutput param1) {
    if (this.number < 0 || this.number > 65535) {
      throw new Exception("Forbidden value (" + this.number + ") on element number.");
    }
    param1.writeShort(this.number);
  }

  public void deserialize(ICustomDataInput param1) {
    this.number = param1.readUnsignedShort();
    if (this.number < 0 || this.number > 65535) {
      throw new Exception(
          "Forbidden value (" + this.number + ") on element of SequenceNumberMessage.number.");
    }
  }
}
