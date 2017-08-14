package com.ankamagames.dofus.network.messages.game.inventory.items;

import java.lang.Exception;
import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class ObjectMovementMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public int objectUID = 0;
  public int position = 63;
  public static final int protocolId = 3010;

  public void serialize(ICustomDataOutput param1) {
    if (this.objectUID < 0) {
      throw new Error("Forbidden value (" + this.objectUID + ") on element objectUID.");
    }
    param1.writeVarInt(this.objectUID);
    param1.writeByte(this.position);
  }

  public void deserialize(ICustomDataInput param1) {
    this.objectUID = param1.readVarUhInt();
    if (this.objectUID < 0) {
      throw new Error(
          "Forbidden value ("
              + this.objectUID
              + ") on element of ObjectItemToSellInHumanVendorShop.objectUID.");
    }

    this.position = param1.readUnsignedByte();
    if (this.position < 0 || this.position > 255) {
      throw new Error("Forbidden value (" + this.position + ") on element of PresetItem.position.");
    }
  }
}
