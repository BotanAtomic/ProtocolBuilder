package com.ankamagames.dofus.network.messages.game.prism;

import java.lang.Exception;
import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class PrismFightStateUpdateMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public int state = 0;
  public static final int protocolId = 6040;

  public void serialize(ICustomDataOutput param1) {
    if (this.state < 0) {
      throw new Error("Forbidden value (" + this.state + ") on element state.");
    }
    param1.writeByte(this.state);
  }

  public void deserialize(ICustomDataInput param1) {
    this.state = param1.readByte();
    if (this.state < 0) {
      throw new Error("Forbidden value (" + this.state + ") on element of ContentPart.state.");
    }
  }
}
