package com.ankamagames.dofus.network.messages.security;

import java.lang.Exception;
import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class CheckFileMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public String filenameHash = "";
  public int type = 0;
  public String value = "";
  public static final int protocolId = 6156;

  public void serialize(ICustomDataOutput param1) {
    param1.writeUTF(this.filenameHash);
    param1.writeByte(this.type);
    param1.writeUTF(this.value);
  }

  public void deserialize(ICustomDataInput param1) {
    this.filenameHash = param1.readUTF();

    this.type = param1.readByte();
    if (this.type < 0) {
      throw new Error("Forbidden value (" + this.type + ") on element of UpdateMountBoost.type.");
    }

    this.value = param1.readInt();
  }
}
