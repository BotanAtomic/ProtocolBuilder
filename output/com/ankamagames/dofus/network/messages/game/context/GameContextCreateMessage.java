package com.ankamagames.dofus.network.messages.game.context;

import java.lang.Exception;
import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class GameContextCreateMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public int context = 1;
  public static final int protocolId = 200;

  public void serialize(ICustomDataOutput param1) {
    param1.writeByte(this.context);
  }

  public void deserialize(ICustomDataInput param1) {
    this.context = param1.readByte();
    if (this.context < 0) {
      throw new Error(
          "Forbidden value (" + this.context + ") on element of GameContextCreateMessage.context.");
    }
  }
}
