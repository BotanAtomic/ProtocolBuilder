package com.ankamagames.dofus.network.messages.game.inventory.storage;

import java.lang.Exception;
import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class StorageObjectRemoveMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public int objectUID = 0;
  public static final int protocolId = 5648;

  public void serialize(ICustomDataOutput param1) {
    if (this.objectUID < 0) {
      throw new Error("Forbidden value (" + this.objectUID + ") on element objectUID.");
    }
    param1.writeVarInt(this.objectUID);
  }

  public void deserialize(ICustomDataInput param1) {
    this.objectUID = param1.readVarUhInt();
    if (this.objectUID < 0) {
      throw new Error(
          "Forbidden value ("
              + this.objectUID
              + ") on element of ObjectItemToSellInHumanVendorShop.objectUID.");
    }
  }
}
