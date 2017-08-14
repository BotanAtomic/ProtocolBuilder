package com.ankamagames.dofus.network.messages.game.inventory.items;

import java.lang.Exception;
import com.ankamagames.dofus.network.messages.game.inventory.exchanges.ExchangeObjectMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class ExchangeKamaModifiedMessage extends ExchangeObjectMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public Number quantity = 0;
  public static final int protocolId = 5521;

  @Override
  public void serialize(ICustomDataOutput param1) {
    param1.writeBoolean(this.remote);

    if (this.quantity < 0 || this.quantity > 9.007199254740992E15) {
      throw new Error("Forbidden value (" + this.quantity + ") on element quantity.");
    }
    param1.writeVarLong(this.quantity);
  }

  @Override
  public void deserialize(ICustomDataInput param1) {
    this.uid = param1.readUTF();

    this.figure = param1.readVarUhShort();
    if (this.figure < 0) {
      throw new Error(
          "Forbidden value (" + this.figure + ") on element of KrosmasterFigure.figure.");
    }

    this.pedestal = param1.readVarUhShort();
    if (this.pedestal < 0) {
      throw new Error(
          "Forbidden value (" + this.pedestal + ") on element of KrosmasterFigure.pedestal.");
    }

    this.bound = param1.readBoolean();

    this.quantity = param1.readVarUhInt();
    if (this.quantity < 0) {
      throw new Error(
          "Forbidden value ("
              + this.quantity
              + ") on element of ObjectItemToSellInHumanVendorShop.quantity.");
    }
  }
}
