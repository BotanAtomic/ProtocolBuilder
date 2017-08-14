package com.ankamagames.dofus.network.messages.game.context.mount;

import java.lang.Exception;
import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class MountXpRatioMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public int ratio = 0;
  public static final int protocolId = 5970;

  public void serialize(ICustomDataOutput param1) {
    if (this.ratio < 0) {
      throw new Exception("Forbidden value (" + this.ratio + ") on element ratio.");
    }
    param1.writeByte(this.ratio);
  }

  public void deserialize(ICustomDataInput param1) {
    this.ratio = param1.readByte();
    if (this.ratio < 0) {
      throw new Exception(
          "Forbidden value (" + this.ratio + ") on element of MountXpRatioMessage.ratio.");
    }
  }
}
