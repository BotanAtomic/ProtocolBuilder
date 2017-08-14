package com.ankamagames.dofus.network.messages.authorized;

import java.lang.Exception;
import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class ConsoleMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public int type = 0;
  public String content = "";
  public static final int protocolId = 75;

  public void serialize(ICustomDataOutput param1) {
    param1.writeByte(this.type);
    param1.writeUTF(this.content);
  }

  public void deserialize(ICustomDataInput param1) {
    this.type = param1.readByte();
    if (this.type < 0) {
      throw new Exception(
          "Forbidden value (" + this.type + ") on element of UpdateMountBoost.type.");
    }

    this.content = param1.readUTF();
  }
}
