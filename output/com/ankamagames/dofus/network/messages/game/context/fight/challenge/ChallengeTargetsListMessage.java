package com.ankamagames.dofus.network.messages.game.context.fight.challenge;

import java.lang.Exception;
import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class ChallengeTargetsListMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public Vector<Number> targetIds;
  public Vector<Integer> targetCells;
  private FuncTree _targetIdstree;
  private FuncTree _targetCellstree;
  public static final int protocolId = 5613;

  public void serialize(ICustomDataOutput param1) {
    param1.writeShort(this.targetIds.length);
    int _loc2_ = 0;
    while (_loc2_ < this.targetIds.length) {
      if (this.targetIds[_loc2_] < -9.007199254740992E15
          || this.targetIds[_loc2_] > 9.007199254740992E15) {
        throw new Exception(
            "Forbidden value ("
                + this.targetIds[_loc2_]
                + ") on element 1 (starting at 1) of targetIds.");
      }
      param1.writeDouble(this.targetIds[_loc2_]);
      _loc2_++;
    }
    param1.writeShort(this.targetCells.length);
    int _loc3_ = 0;
    while (_loc3_ < this.targetCells.length) {
      if (this.targetCells[_loc3_] < -1 || this.targetCells[_loc3_] > 559) {
        throw new Exception(
            "Forbidden value ("
                + this.targetCells[_loc3_]
                + ") on element 2 (starting at 1) of targetCells.");
      }
      param1.writeShort(this.targetCells[_loc3_]);
      _loc3_++;
    }
  }

  public void deserialize(ICustomDataInput param1) {
    Object _loc6_ = NaN;
    Object _loc7_ = 0;
    int _loc2_ = param1.readUnsignedShort();
    int _loc3_ = 0;
    while (_loc3_ < _loc2_) {
      _loc6_ = param1.readDouble();
      if (_loc6_ < -9.007199254740992E15 || _loc6_ > 9.007199254740992E15) {
        throw new Exception("Forbidden value (" + _loc6_ + ") on elements of targetIds.");
      }
      this.targetIds.push(_loc6_);
      _loc3_++;
    }
    int _loc4_ = param1.readUnsignedShort();
    int _loc5_ = 0;
    while (_loc5_ < _loc4_) {
      _loc7_ = param1.readShort();
      if (_loc7_ < -1 || _loc7_ > 559) {
        throw new Exception("Forbidden value (" + _loc7_ + ") on elements of targetCells.");
      }
      this.targetCells.push(_loc7_);
      _loc5_++;
    }
  }
}
