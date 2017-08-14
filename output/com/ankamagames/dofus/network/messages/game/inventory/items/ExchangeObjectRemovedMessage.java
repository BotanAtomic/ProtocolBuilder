package com.ankamagames.dofus.network.messages.game.inventory.items;

import java.lang.Exception;
import com.ankamagames.dofus.network.messages.game.inventory.exchanges.ExchangeObjectMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class ExchangeObjectRemovedMessage extends ExchangeObjectMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public int objectUID = 0;
  public static final int protocolId = 5517;

  @Override
  public void serialize(ICustomDataOutput param1) {
    param1.writeBoolean(this.remote);

    if (this.objectUID < 0) {
      throw new Exception("Forbidden value (" + this.objectUID + ") on element objectUID.");
    }
    param1.writeVarInt(this.objectUID);
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

    this.objectUID = param1.readVarUhInt();
    if (this.objectUID < 0) {
      throw new Exception(
          "Forbidden value ("
              + this.objectUID
              + ") on element of ObjectItemToSellInHumanVendorShop.objectUID.");
    }
  }
}
