package com.ankamagames.dofus.network.messages.game.inventory.exchanges;

import java.lang.Exception;
import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class ExchangeBidPriceMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public int genericId = 0;
  public Number averagePrice = 0;
  public static final int protocolId = 5755;

  public void serialize(ICustomDataOutput param1) {
    if (this.genericId < 0) {
      throw new Exception("Forbidden value (" + this.genericId + ") on element genericId.");
    }
    param1.writeVarShort(this.genericId);
    if (this.averagePrice < -9.007199254740992E15 || this.averagePrice > 9.007199254740992E15) {
      throw new Exception("Forbidden value (" + this.averagePrice + ") on element averagePrice.");
    }
    param1.writeVarLong(this.averagePrice);
  }

  public void deserialize(ICustomDataInput param1) {
    int _loc2_ = param1.readVarUhShort();
    if (_loc2_ < 0) {
      throw new Exception("Forbidden value (" + _loc2_ + ") on elements of genericId.");
    }
    this.genericId.push(_loc2_);

    this.averagePrice = param1.readVarLong();
    if (this.averagePrice < -9.007199254740992E15 || this.averagePrice > 9.007199254740992E15) {
      throw new Exception(
          "Forbidden value ("
              + this.averagePrice
              + ") on element of ExchangeBidPriceMessage.averagePrice.");
    }
  }
}
