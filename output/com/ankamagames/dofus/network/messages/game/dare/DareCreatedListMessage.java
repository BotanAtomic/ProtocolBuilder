package com.ankamagames.dofus.network.messages.game.dare;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.dare.DareInformations;
import com.ankamagames.dofus.network.types.game.dare.DareVersatileInformations;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class DareCreatedListMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public Vector<DareInformations> daresFixedInfos;
  public Vector<DareVersatileInformations> daresVersatilesInfos;
  private FuncTree _daresFixedInfostree;
  private FuncTree _daresVersatilesInfostree;
  public static final int protocolId = 6663;

  public void serialize(ICustomDataOutput param1) {
    param1.writeShort(this.daresFixedInfos.length);
    int _loc2_ = 0;
    while (_loc2_ < this.daresFixedInfos.length) {
      ((DareInformations) this.daresFixedInfos[_loc2_]).serializeAs_(param1);
      _loc2_++;
    }
    param1.writeShort(this.daresVersatilesInfos.length);
    int _loc3_ = 0;
    while (_loc3_ < this.daresVersatilesInfos.length) {
      ((DareVersatileInformations) this.daresVersatilesInfos[_loc3_]).serializeAs_(param1);
      _loc3_++;
    }
  }

  public void deserialize(ICustomDataInput param1) {
    DareInformations _loc6_ = null;
    DareVersatileInformations _loc7_ = null;
    int _loc2_ = param1.readUnsignedShort();
    int _loc3_ = 0;
    while (_loc3_ < _loc2_) {
      _loc6_ = new DareInformations();
      _loc6_.deserialize(param1);
      this.daresFixedInfos.push(_loc6_);
      _loc3_++;
    }
    int _loc4_ = param1.readUnsignedShort();
    int _loc5_ = 0;
    while (_loc5_ < _loc4_) {
      _loc7_ = new DareVersatileInformations();
      _loc7_.deserialize(param1);
      this.daresVersatilesInfos.push(_loc7_);
      _loc5_++;
    }
  }
}
