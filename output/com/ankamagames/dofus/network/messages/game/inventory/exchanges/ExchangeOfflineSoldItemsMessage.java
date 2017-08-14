package com.ankamagames.dofus.network.messages.game.inventory.exchanges;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.data.items.ObjectItemGenericQuantityPrice;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class ExchangeOfflineSoldItemsMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public Vector<ObjectItemGenericQuantityPrice> bidHouseItems;
  public Vector<ObjectItemGenericQuantityPrice> merchantItems;
  private FuncTree _bidHouseItemstree;
  private FuncTree _merchantItemstree;
  public static final int protocolId = 6613;

  public void serialize(ICustomDataOutput param1) {
    param1.writeShort(this.bidHouseItems.length);
    int _loc2_ = 0;
    while (_loc2_ < this.bidHouseItems.length) {
      ((ObjectItemGenericQuantityPrice) this.bidHouseItems[_loc2_]).serializeAs_(param1);
      _loc2_++;
    }
    param1.writeShort(this.merchantItems.length);
    int _loc3_ = 0;
    while (_loc3_ < this.merchantItems.length) {
      ((ObjectItemGenericQuantityPrice) this.merchantItems[_loc3_]).serializeAs_(param1);
      _loc3_++;
    }
  }

  public void deserialize(ICustomDataInput param1) {
    ObjectItemGenericQuantityPrice _loc6_ = null;
    ObjectItemGenericQuantityPrice _loc7_ = null;
    int _loc2_ = param1.readUnsignedShort();
    int _loc3_ = 0;
    while (_loc3_ < _loc2_) {
      _loc6_ = new ObjectItemGenericQuantityPrice();
      _loc6_.deserialize(param1);
      this.bidHouseItems.push(_loc6_);
      _loc3_++;
    }
    int _loc4_ = param1.readUnsignedShort();
    int _loc5_ = 0;
    while (_loc5_ < _loc4_) {
      _loc7_ = new ObjectItemGenericQuantityPrice();
      _loc7_.deserialize(param1);
      this.merchantItems.push(_loc7_);
      _loc5_++;
    }
  }
}
