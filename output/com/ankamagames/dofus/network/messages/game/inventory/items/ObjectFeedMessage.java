package com.ankamagames.dofus.network.messages.game.inventory.items;

import java.lang.Exception;
import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class ObjectFeedMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public int objectUID = 0;
  public int foodUID = 0;
  public int foodQuantity = 0;
  public static final int protocolId = 6290;

  public void serialize(ICustomDataOutput param1) {
    if (this.objectUID < 0) {
      throw new Exception("Forbidden value (" + this.objectUID + ") on element objectUID.");
    }
    param1.writeVarInt(this.objectUID);
    if (this.foodUID < 0) {
      throw new Exception("Forbidden value (" + this.foodUID + ") on element foodUID.");
    }
    param1.writeVarInt(this.foodUID);
    if (this.foodQuantity < 0) {
      throw new Exception("Forbidden value (" + this.foodQuantity + ") on element foodQuantity.");
    }
    param1.writeVarInt(this.foodQuantity);
  }

  public void deserialize(ICustomDataInput param1) {
    this.objectUID = param1.readVarUhInt();
    if (this.objectUID < 0) {
      throw new Exception(
          "Forbidden value ("
              + this.objectUID
              + ") on element of ObjectItemToSellInHumanVendorShop.objectUID.");
    }

    this.foodUID = param1.readVarUhInt();
    if (this.foodUID < 0) {
      throw new Exception(
          "Forbidden value (" + this.foodUID + ") on element of ObjectFeedMessage.foodUID.");
    }

    this.foodQuantity = param1.readVarUhInt();
    if (this.foodQuantity < 0) {
      throw new Exception(
          "Forbidden value ("
              + this.foodQuantity
              + ") on element of ObjectFeedMessage.foodQuantity.");
    }
  }
}
