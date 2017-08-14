package com.ankamagames.dofus.network.messages.game.inventory.items;

import com.ankamagames.dofus.network.messages.game.inventory.exchanges.ExchangeObjectMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.data.items.ObjectItem;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class ExchangeObjectsModifiedMessage extends ExchangeObjectMessage
    implements INetworkMessage {

  private boolean _isInitialized = false;
  public Vector<ObjectItem> object;
  private FuncTree _objecttree;
  public static final int protocolId = 6533;

  @Override
  public void serialize(ICustomDataOutput param1) {
    param1.writeBoolean(this.remote);

    param1.writeShort(this.object.length);
    int _loc2_ = 0;
    while (_loc2_ < this.object.length) {
      ((ObjectItem) this.object[_loc2_]).serializeAs_(param1);
      _loc2_++;
    }
  }

  @Override
  public void deserialize(ICustomDataInput param1) {
    ObjectItem _loc4_ = null;
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

    int _loc2_ = param1.readUnsignedShort();
    int _loc3_ = 0;
    while (_loc3_ < _loc2_) {
      _loc4_ = new ObjectItem();
      _loc4_.deserialize(param1);
      this.object.push(_loc4_);
      _loc3_++;
    }
  }
}
