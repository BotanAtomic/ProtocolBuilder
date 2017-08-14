package com.ankamagames.dofus.network.messages.game.inventory.items;

import java.lang.Exception;
import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class InventoryWeightMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public int weight = 0;
  public int weightMax = 0;
  public static final int protocolId = 3009;

  public void serialize(ICustomDataOutput param1) {
    if (this.weight < 0) {
      throw new Exception("Forbidden value (" + this.weight + ") on element weight.");
    }
    param1.writeVarInt(this.weight);
    if (this.weightMax < 0) {
      throw new Exception("Forbidden value (" + this.weightMax + ") on element weightMax.");
    }
    param1.writeVarInt(this.weightMax);
  }

  public void deserialize(ICustomDataInput param1) {
    this.weight = param1.readVarUhInt();
    if (this.weight < 0) {
      throw new Exception(
          "Forbidden value (" + this.weight + ") on element of InventoryWeightMessage.weight.");
    }

    this.weightMax = param1.readVarUhInt();
    if (this.weightMax < 0) {
      throw new Exception(
          "Forbidden value ("
              + this.weightMax
              + ") on element of InventoryWeightMessage.weightMax.");
    }
  }
}
