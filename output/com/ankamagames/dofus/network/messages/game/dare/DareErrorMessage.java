package com.ankamagames.dofus.network.messages.game.dare;

import java.lang.Exception;
import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class DareErrorMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public int error = 0;
  public static final int protocolId = 6667;

  public void serialize(ICustomDataOutput param1) {
    param1.writeByte(this.error);
  }

  public void deserialize(ICustomDataInput param1) {
    this.error = param1.readByte();
    if (this.error < 0) {
      throw new Exception(
          "Forbidden value (" + this.error + ") on element of ShortcutBarSwapErrorMessage.error.");
    }
  }
}
