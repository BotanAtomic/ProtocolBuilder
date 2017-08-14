package com.ankamagames.dofus.network.messages.game.inventory.storage;

import com.ankamagames.dofus.network.messages.game.inventory.items.InventoryContentMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.data.items.ObjectItem;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class StorageInventoryContentMessage extends InventoryContentMessage
    implements INetworkMessage {

  private boolean _isInitialized = false;
  public static final int protocolId = 5646;

  @Override
  public void serialize(ICustomDataOutput param1) {
    param1.writeShort(this.objects.length);
    int _loc2_ = 0;
    while (_loc2_ < this.objects.length) {
      ((ObjectItem) this.objects[_loc2_]).serializeAs_(param1);
      _loc2_++;
    }
    if (this.kamas < 0 || this.kamas > 9.007199254740992E15) {
      throw new Exception("Forbidden value (" + this.kamas + ") on element kamas.");
    }
    param1.writeVarLong(this.kamas);
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
