package com.ankamagames.dofus.network.messages.game.inventory.exchanges;

import java.lang.Exception;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class ExchangeBidPriceForSellerMessage extends ExchangeBidPriceMessage
    implements INetworkMessage {

  private boolean _isInitialized = false;
  public boolean allIdentical = false;
  public Vector<Number> minimalPrices;
  private FuncTree _minimalPricestree;
  public static final int protocolId = 6464;

  @Override
  public void serialize(ICustomDataOutput param1) {
    if (this.genericId < 0) {
      throw new Error("Forbidden value (" + this.genericId + ") on element genericId.");
    }
    param1.writeVarShort(this.genericId);
    if (this.averagePrice < -9.007199254740992E15 || this.averagePrice > 9.007199254740992E15) {
      throw new Error("Forbidden value (" + this.averagePrice + ") on element averagePrice.");
    }
    param1.writeVarLong(this.averagePrice);

    param1.writeBoolean(this.allIdentical);
    param1.writeShort(this.minimalPrices.length);
    int _loc2_ = 0;
    while (_loc2_ < this.minimalPrices.length) {
      if (this.minimalPrices[_loc2_] < 0 || this.minimalPrices[_loc2_] > 9.007199254740992E15) {
        throw new Error(
            "Forbidden value ("
                + this.minimalPrices[_loc2_]
                + ") on element 2 (starting at 1) of minimalPrices.");
      }
      param1.writeVarLong(this.minimalPrices[_loc2_]);
      _loc2_++;
    }
  }

  @Override
  public void deserialize(ICustomDataInput param1) {
    Object _loc4_ = NaN;
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

    this.allIdentical = param1.readBoolean();

    int _loc2_ = param1.readUnsignedShort();
    int _loc3_ = 0;
    while (_loc3_ < _loc2_) {
      _loc4_ = param1.readVarUhLong();
      if (_loc4_ < 0 || _loc4_ > 9.007199254740992E15) {
        throw new Error("Forbidden value (" + _loc4_ + ") on elements of minimalPrices.");
      }
      this.minimalPrices.push(_loc4_);
      _loc3_++;
    }
  }
}
