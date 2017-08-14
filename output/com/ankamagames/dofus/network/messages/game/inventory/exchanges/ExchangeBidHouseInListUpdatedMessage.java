package com.ankamagames.dofus.network.messages.game.inventory.exchanges;

import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.data.items.effects.ObjectEffect;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class ExchangeBidHouseInListUpdatedMessage extends ExchangeBidHouseInListAddedMessage
    implements INetworkMessage {

  private boolean _isInitialized = false;
  public static final int protocolId = 6337;

  @Override
  public void serialize(ICustomDataOutput param1) {
    param1.writeInt(this.itemUID);
    param1.writeInt(this.objGenericId);
    param1.writeShort(this.effects.length);
    int _loc2_ = 0;
    while (_loc2_ < this.effects.length) {
      param1.writeShort(((ObjectEffect) (this.effects[_loc2_])).getTypeId());
      ((ObjectEffect) this.effects[_loc2_]).serialize(param1);
      _loc2_++;
    }
    param1.writeShort(this.prices.length);
    int _loc3_ = 0;
    while (_loc3_ < this.prices.length) {
      if (this.prices[_loc3_] < 0 || this.prices[_loc3_] > 9.007199254740992E15) {
        throw new Exception(
            "Forbidden value ("
                + this.prices[_loc3_]
                + ") on element 4 (starting at 1) of prices.");
      }
      param1.writeVarLong(this.prices[_loc3_]);
      _loc3_++;
    }
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
  }
}
