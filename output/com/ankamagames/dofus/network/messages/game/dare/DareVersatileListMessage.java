package com.ankamagames.dofus.network.messages.game.dare;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.dare.DareVersatileInformations;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class DareVersatileListMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public Vector<DareVersatileInformations> dares;
  private FuncTree _darestree;
  public static final int protocolId = 6657;

  public void serialize(ICustomDataOutput param1) {
    param1.writeShort(this.dares.length);
    int _loc2_ = 0;
    while (_loc2_ < this.dares.length) {
      ((DareVersatileInformations) this.dares[_loc2_]).serializeAs_(param1);
      _loc2_++;
    }
  }

  public void deserialize(ICustomDataInput param1) {
    DareVersatileInformations _loc4_ = null;
    int _loc2_ = param1.readUnsignedShort();
    int _loc3_ = 0;
    while (_loc3_ < _loc2_) {
      _loc4_ = new DareVersatileInformations();
      _loc4_.deserialize(param1);
      this.dares.push(_loc4_);
      _loc3_++;
    }
  }
}
