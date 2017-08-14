package com.ankamagames.dofus.network.messages.game.context.mount;

import java.lang.Exception;
import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class PaddockBuyResultMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public int paddockId = 0;
  public boolean bought = false;
  public Number realPrice = 0;
  public static final int protocolId = 6516;

  public void serialize(ICustomDataOutput param1) {
    param1.writeInt(this.paddockId);
    param1.writeBoolean(this.bought);
    if (this.realPrice < 0 || this.realPrice > 9.007199254740992E15) {
      throw new Error("Forbidden value (" + this.realPrice + ") on element realPrice.");
    }
    param1.writeVarLong(this.realPrice);
  }

  public void deserialize(ICustomDataInput param1) {
    this.paddockId = param1.readInt();

    this.bought = param1.readBoolean();

    this.realPrice = param1.readVarUhLong();
    if (this.realPrice < 0 || this.realPrice > 9.007199254740992E15) {
      throw new Error(
          "Forbidden value ("
              + this.realPrice
              + ") on element of HouseSellingUpdateMessage.realPrice.");
    }
  }
}
