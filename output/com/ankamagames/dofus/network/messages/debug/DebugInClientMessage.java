package com.ankamagames.dofus.network.messages.debug;

import java.lang.Exception;
import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class DebugInClientMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public int level = 0;
  public String message = "";
  public static final int protocolId = 6028;

  public void serialize(ICustomDataOutput param1) {
    param1.writeByte(this.level);
    param1.writeUTF(this.message);
  }

  public void deserialize(ICustomDataInput param1) {
    this.level = param1.readByte();
    if (this.level < 0) {
      throw new Error("Forbidden value (" + this.level + ") on element of MountClientData.level.");
    }

    this.message = param1.readUTF();
  }
}
