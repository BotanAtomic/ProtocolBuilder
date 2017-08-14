package com.ankamagames.dofus.network.messages.game.finishmoves;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.finishmoves.FinishMoveInformations;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class FinishMoveListMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public Vector<FinishMoveInformations> finishMoves;
  private FuncTree _finishMovestree;
  public static final int protocolId = 6704;

  public void serialize(ICustomDataOutput param1) {
    param1.writeShort(this.finishMoves.length);
    int _loc2_ = 0;
    while (_loc2_ < this.finishMoves.length) {
      ((FinishMoveInformations) this.finishMoves[_loc2_]).serializeAs_(param1);
      _loc2_++;
    }
  }

  public void deserialize(ICustomDataInput param1) {
    FinishMoveInformations _loc4_ = null;
    int _loc2_ = param1.readUnsignedShort();
    int _loc3_ = 0;
    while (_loc3_ < _loc2_) {
      _loc4_ = new FinishMoveInformations();
      _loc4_.deserialize(param1);
      this.finishMoves.push(_loc4_);
      _loc3_++;
    }
  }
}
