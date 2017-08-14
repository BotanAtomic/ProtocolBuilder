package com.ankamagames.dofus.network.messages.game.inventory.exchanges;

import java.lang.Exception;
import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class ExchangeWeightMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public int currentWeight = 0;
  public int maxWeight = 0;
  public static final int protocolId = 5793;

  public void serialize(ICustomDataOutput param1) {
    if (this.currentWeight < 0) {
      throw new Exception("Forbidden value (" + this.currentWeight + ") on element currentWeight.");
    }
    param1.writeVarInt(this.currentWeight);
    if (this.maxWeight < 0) {
      throw new Exception("Forbidden value (" + this.maxWeight + ") on element maxWeight.");
    }
    param1.writeVarInt(this.maxWeight);
  }

  public void deserialize(ICustomDataInput param1) {
    this.currentWeight = param1.readVarUhInt();
    if (this.currentWeight < 0) {
      throw new Exception(
          "Forbidden value ("
              + this.currentWeight
              + ") on element of ExchangePodsModifiedMessage.currentWeight.");
    }

    this.maxWeight = param1.readVarUhInt();
    if (this.maxWeight < 0) {
      throw new Exception(
          "Forbidden value ("
              + this.maxWeight
              + ") on element of ExchangePodsModifiedMessage.maxWeight.");
    }
  }
}
