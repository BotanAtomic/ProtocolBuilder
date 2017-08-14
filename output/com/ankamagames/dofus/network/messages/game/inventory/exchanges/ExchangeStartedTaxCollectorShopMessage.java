package com.ankamagames.dofus.network.messages.game.inventory.exchanges;

import java.lang.Exception;
import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.data.items.ObjectItem;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class ExchangeStartedTaxCollectorShopMessage extends NetworkMessage
    implements INetworkMessage {

  private boolean _isInitialized = false;
  public Vector<ObjectItem> objects;
  public Number kamas = 0;
  private FuncTree _objectstree;
  public static final int protocolId = 6664;

  public void serialize(ICustomDataOutput param1) {
    param1.writeShort(this.objects.length);
    int _loc2_ = 0;
    while (_loc2_ < this.objects.length) {
      ((ObjectItem) this.objects[_loc2_]).serializeAs_(param1);
      _loc2_++;
    }
    if (this.kamas < 0 || this.kamas > 9.007199254740992E15) {
      throw new Error("Forbidden value (" + this.kamas + ") on element kamas.");
    }
    param1.writeVarLong(this.kamas);
  }

  public void deserialize(ICustomDataInput param1) {
    ObjectItem _loc4_ = null;
    int _loc2_ = param1.readUnsignedShort();
    int _loc3_ = 0;
    while (_loc3_ < _loc2_) {
      _loc4_ = new ObjectItem();
      _loc4_.deserialize(param1);
      this.objects.push(_loc4_);
      _loc3_++;
    }
    this.kamas = param1.readVarUhLong();
    if (this.kamas < 0 || this.kamas > 9.007199254740992E15) {
      throw new Error(
          "Forbidden value (" + this.kamas + ") on element of TaxCollectorLootInformations.kamas.");
    }
  }
}
