package com.ankamagames.dofus.network.messages.game.inventory.exchanges;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class ExchangeBidHouseItemRemoveOkMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public int sellerId = 0;
  public static final int protocolId = 5946;

  public void serialize(ICustomDataOutput param1) {
    param1.writeInt(this.sellerId);
  }

  public void deserialize(ICustomDataInput param1) {
    this.sellerId = param1.readDouble();
    if (this.sellerId < -9.007199254740992E15 || this.sellerId > 9.007199254740992E15) {
      throw new Exception(
          "Forbidden value ("
              + this.sellerId
              + ") on element of ExchangeStartOkHumanVendorMessage.sellerId.");
    }
  }
}
