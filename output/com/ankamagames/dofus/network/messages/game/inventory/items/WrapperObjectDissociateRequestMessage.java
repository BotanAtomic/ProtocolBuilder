package com.ankamagames.dofus.network.messages.game.inventory.items;

import java.lang.Exception;
import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class WrapperObjectDissociateRequestMessage extends NetworkMessage
    implements INetworkMessage {

  private boolean _isInitialized = false;
  public int hostUID = 0;
  public int hostPos = 0;
  public static final int protocolId = 6524;

  public void serialize(ICustomDataOutput param1) {
    if (this.hostUID < 0) {
      throw new Error("Forbidden value (" + this.hostUID + ") on element hostUID.");
    }
    param1.writeVarInt(this.hostUID);
    if (this.hostPos < 0 || this.hostPos > 255) {
      throw new Error("Forbidden value (" + this.hostPos + ") on element hostPos.");
    }
    param1.writeByte(this.hostPos);
  }

  public void deserialize(ICustomDataInput param1) {
    this.hostUID = param1.readVarUhInt();
    if (this.hostUID < 0) {
      throw new Error(
          "Forbidden value ("
              + this.hostUID
              + ") on element of WrapperObjectDissociateRequestMessage.hostUID.");
    }

    this.hostPos = param1.readUnsignedByte();
    if (this.hostPos < 0 || this.hostPos > 255) {
      throw new Error(
          "Forbidden value ("
              + this.hostPos
              + ") on element of WrapperObjectDissociateRequestMessage.hostPos.");
    }
  }
}
