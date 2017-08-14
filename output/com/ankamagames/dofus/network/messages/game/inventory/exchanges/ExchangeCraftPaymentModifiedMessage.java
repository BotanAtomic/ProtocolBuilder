package com.ankamagames.dofus.network.messages.game.inventory.exchanges;

import java.lang.Exception;
import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class ExchangeCraftPaymentModifiedMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public Number goldSum = 0;
  public static final int protocolId = 6578;

  public void serialize(ICustomDataOutput param1) {
    if (this.goldSum < 0 || this.goldSum > 9.007199254740992E15) {
      throw new Error("Forbidden value (" + this.goldSum + ") on element goldSum.");
    }
    param1.writeVarLong(this.goldSum);
  }

  public void deserialize(ICustomDataInput param1) {
    this.goldSum = param1.readVarUhLong();
    if (this.goldSum < 0 || this.goldSum > 9.007199254740992E15) {
      throw new Error(
          "Forbidden value ("
              + this.goldSum
              + ") on element of ExchangeCraftPaymentModifiedMessage.goldSum.");
    }
  }
}
