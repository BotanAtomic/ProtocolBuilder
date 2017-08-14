package com.ankamagames.dofus.network.messages.game.context.mount;

import java.lang.Exception;
import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class MountFeedRequestMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public int mountUid = 0;
  public int mountLocation = 0;
  public int mountFoodUid = 0;
  public int quantity = 0;
  public static final int protocolId = 6189;

  public void serialize(ICustomDataOutput param1) {
    if (this.mountUid < 0) {
      throw new Error("Forbidden value (" + this.mountUid + ") on element mountUid.");
    }
    param1.writeVarInt(this.mountUid);
    param1.writeByte(this.mountLocation);
    if (this.mountFoodUid < 0) {
      throw new Error("Forbidden value (" + this.mountFoodUid + ") on element mountFoodUid.");
    }
    param1.writeVarInt(this.mountFoodUid);
    if (this.quantity < 0) {
      throw new Error("Forbidden value (" + this.quantity + ") on element quantity.");
    }
    param1.writeVarInt(this.quantity);
  }

  public void deserialize(ICustomDataInput param1) {
    this.mountUid = param1.readVarUhInt();
    if (this.mountUid < 0) {
      throw new Error(
          "Forbidden value ("
              + this.mountUid
              + ") on element of MountFeedRequestMessage.mountUid.");
    }

    this.mountLocation = param1.readByte();

    this.mountFoodUid = param1.readVarUhInt();
    if (this.mountFoodUid < 0) {
      throw new Error(
          "Forbidden value ("
              + this.mountFoodUid
              + ") on element of MountFeedRequestMessage.mountFoodUid.");
    }

    this.quantity = param1.readVarUhInt();
    if (this.quantity < 0) {
      throw new Error(
          "Forbidden value ("
              + this.quantity
              + ") on element of ObjectItemToSellInHumanVendorShop.quantity.");
    }
  }
}
