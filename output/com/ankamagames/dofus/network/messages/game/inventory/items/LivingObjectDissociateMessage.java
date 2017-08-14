package com.ankamagames.dofus.network.messages.game.inventory.items;

import java.lang.Exception;
import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class LivingObjectDissociateMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public int livingUID = 0;
  public int livingPosition = 0;
  public static final int protocolId = 5723;

  public void serialize(ICustomDataOutput param1) {
    if (this.livingUID < 0) {
      throw new Error("Forbidden value (" + this.livingUID + ") on element livingUID.");
    }
    param1.writeVarInt(this.livingUID);
    if (this.livingPosition < 0 || this.livingPosition > 255) {
      throw new Error("Forbidden value (" + this.livingPosition + ") on element livingPosition.");
    }
    param1.writeByte(this.livingPosition);
  }

  public void deserialize(ICustomDataInput param1) {
    this.livingUID = param1.readVarUhInt();
    if (this.livingUID < 0) {
      throw new Error(
          "Forbidden value ("
              + this.livingUID
              + ") on element of LivingObjectDissociateMessage.livingUID.");
    }

    this.livingPosition = param1.readUnsignedByte();
    if (this.livingPosition < 0 || this.livingPosition > 255) {
      throw new Error(
          "Forbidden value ("
              + this.livingPosition
              + ") on element of LivingObjectDissociateMessage.livingPosition.");
    }
  }
}
