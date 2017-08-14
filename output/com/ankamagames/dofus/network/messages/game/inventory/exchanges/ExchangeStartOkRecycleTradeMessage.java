package com.ankamagames.dofus.network.messages.game.inventory.exchanges;

import java.lang.Exception;
import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class ExchangeStartOkRecycleTradeMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public int percentToPrism = 0;
  public int percentToPlayer = 0;
  public static final int protocolId = 6600;

  public void serialize(ICustomDataOutput param1) {
    if (this.percentToPrism < 0) {
      throw new Exception(
          "Forbidden value (" + this.percentToPrism + ") on element percentToPrism.");
    }
    param1.writeShort(this.percentToPrism);
    if (this.percentToPlayer < 0) {
      throw new Exception(
          "Forbidden value (" + this.percentToPlayer + ") on element percentToPlayer.");
    }
    param1.writeShort(this.percentToPlayer);
  }

  public void deserialize(ICustomDataInput param1) {
    this.percentToPrism = param1.readShort();
    if (this.percentToPrism < 0) {
      throw new Exception(
          "Forbidden value ("
              + this.percentToPrism
              + ") on element of ExchangeStartOkRecycleTradeMessage.percentToPrism.");
    }

    this.percentToPlayer = param1.readShort();
    if (this.percentToPlayer < 0) {
      throw new Exception(
          "Forbidden value ("
              + this.percentToPlayer
              + ") on element of ExchangeStartOkRecycleTradeMessage.percentToPlayer.");
    }
  }
}
