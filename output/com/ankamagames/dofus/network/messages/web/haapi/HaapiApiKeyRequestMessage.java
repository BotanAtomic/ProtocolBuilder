package com.ankamagames.dofus.network.messages.web.haapi;

import java.lang.Exception;
import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class HaapiApiKeyRequestMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public int keyType = 0;
  public static final int protocolId = 6648;

  public void serialize(ICustomDataOutput param1) {
    param1.writeByte(this.keyType);
  }

  public void deserialize(ICustomDataInput param1) {
    this.keyType = param1.readByte();
    if (this.keyType < 0) {
      throw new Error(
          "Forbidden value ("
              + this.keyType
              + ") on element of HaapiApiKeyRequestMessage.keyType.");
    }
  }
}
