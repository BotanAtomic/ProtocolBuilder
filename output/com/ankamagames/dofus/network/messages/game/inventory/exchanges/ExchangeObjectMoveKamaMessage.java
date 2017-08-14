package com.ankamagames.dofus.network.messages.game.inventory.exchanges;

import java.lang.Exception;
import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class ExchangeObjectMoveKamaMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public Number quantity = 0;
  public static final int protocolId = 5520;

  public void serialize(ICustomDataOutput param1) {
    if (this.quantity < -9.007199254740992E15 || this.quantity > 9.007199254740992E15) {
      throw new Error("Forbidden value (" + this.quantity + ") on element quantity.");
    }
    param1.writeVarLong(this.quantity);
  }

  public void deserialize(ICustomDataInput param1) {
    this.quantity = param1.readVarUhInt();
    if (this.quantity < 0) {
      throw new Error(
          "Forbidden value ("
              + this.quantity
              + ") on element of ObjectItemToSellInHumanVendorShop.quantity.");
    }
  }
}
