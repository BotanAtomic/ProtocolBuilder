package com.ankamagames.dofus.network.messages.game.inventory.spells;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.data.items.SpellItem;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class SpellListMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public boolean spellPrevisualization = false;
  public Vector<SpellItem> spells;
  private FuncTree _spellstree;
  public static final int protocolId = 1200;

  public void serialize(ICustomDataOutput param1) {
    param1.writeBoolean(this.spellPrevisualization);
    param1.writeShort(this.spells.length);
    int _loc2_ = 0;
    while (_loc2_ < this.spells.length) {
      ((SpellItem) this.spells[_loc2_]).serializeAs_(param1);
      _loc2_++;
    }
  }

  public void deserialize(ICustomDataInput param1) {
    SpellItem _loc4_ = null;
    this.spellPrevisualization = param1.readBoolean();

    int _loc2_ = param1.readUnsignedShort();
    int _loc3_ = 0;
    while (_loc3_ < _loc2_) {
      _loc4_ = new SpellItem();
      _loc4_.deserialize(param1);
      this.spells.push(_loc4_);
      _loc3_++;
    }
  }
}
