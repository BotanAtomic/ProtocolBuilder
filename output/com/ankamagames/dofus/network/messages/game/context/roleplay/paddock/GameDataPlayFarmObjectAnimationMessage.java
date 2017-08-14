package com.ankamagames.dofus.network.messages.game.context.roleplay.paddock;

import java.lang.Exception;
import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class GameDataPlayFarmObjectAnimationMessage extends NetworkMessage
    implements INetworkMessage {

  private boolean _isInitialized = false;
  public Vector<uint> cellId;
  private FuncTree _cellIdtree;
  public static final int protocolId = 6026;

  public void serialize(ICustomDataOutput param1) {
    param1.writeShort(this.cellId.length);
    int _loc2_ = 0;
    while (_loc2_ < this.cellId.length) {
      if (this.cellId[_loc2_] < 0 || this.cellId[_loc2_] > 559) {
        throw new Error(
            "Forbidden value ("
                + this.cellId[_loc2_]
                + ") on element 1 (starting at 1) of cellId.");
      }
      param1.writeVarShort(this.cellId[_loc2_]);
      _loc2_++;
    }
  }

  public void deserialize(ICustomDataInput param1) {
    int _loc4_ = 0;
    int _loc2_ = param1.readUnsignedShort();
    int _loc3_ = 0;
    while (_loc3_ < _loc2_) {
      _loc4_ = param1.readVarUhShort();
      if (_loc4_ < 0 || _loc4_ > 559) {
        throw new Error("Forbidden value (" + _loc4_ + ") on elements of cellId.");
      }
      this.cellId.push(_loc4_);
      _loc3_++;
    }
  }
}
