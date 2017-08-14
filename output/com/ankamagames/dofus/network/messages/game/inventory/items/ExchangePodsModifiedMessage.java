package com.ankamagames.dofus.network.messages.game.inventory.items;

import java.lang.Exception;
import com.ankamagames.dofus.network.messages.game.inventory.exchanges.ExchangeObjectMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class ExchangePodsModifiedMessage extends ExchangeObjectMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public int currentWeight = 0;
  public int maxWeight = 0;
  public static final int protocolId = 6670;

  @Override
  public void serialize(ICustomDataOutput param1) {
    param1.writeBoolean(this.remote);

    if (this.currentWeight < 0) {
      throw new Exception("Forbidden value (" + this.currentWeight + ") on element currentWeight.");
    }
    param1.writeVarInt(this.currentWeight);
    if (this.maxWeight < 0) {
      throw new Exception("Forbidden value (" + this.maxWeight + ") on element maxWeight.");
    }
    param1.writeVarInt(this.maxWeight);
  }

  @Override
  public void deserialize(ICustomDataInput param1) {
    this.uid = param1.readUTF();

    this.figure = param1.readVarUhShort();
    if (this.figure < 0) {
      throw new Exception(
          "Forbidden value (" + this.figure + ") on element of KrosmasterFigure.figure.");
    }

    this.pedestal = param1.readVarUhShort();
    if (this.pedestal < 0) {
      throw new Exception(
          "Forbidden value (" + this.pedestal + ") on element of KrosmasterFigure.pedestal.");
    }

    this.bound = param1.readBoolean();

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
