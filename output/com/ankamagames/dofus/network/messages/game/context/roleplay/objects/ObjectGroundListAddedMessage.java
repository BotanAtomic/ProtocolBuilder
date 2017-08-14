package com.ankamagames.dofus.network.messages.game.context.roleplay.objects;

import java.lang.Exception;
import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class ObjectGroundListAddedMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public Vector<uint> cells;
  public Vector<uint> referenceIds;
  private FuncTree _cellstree;
  private FuncTree _referenceIdstree;
  public static final int protocolId = 5925;

  public void serialize(ICustomDataOutput param1) {
    param1.writeShort(this.cells.length);
    int _loc2_ = 0;
    while (_loc2_ < this.cells.length) {
      if (this.cells[_loc2_] < 0 || this.cells[_loc2_] > 559) {
        throw new Error(
            "Forbidden value (" + this.cells[_loc2_] + ") on element 1 (starting at 1) of cells.");
      }
      param1.writeVarShort(this.cells[_loc2_]);
      _loc2_++;
    }
    param1.writeShort(this.referenceIds.length);
    int _loc3_ = 0;
    while (_loc3_ < this.referenceIds.length) {
      if (this.referenceIds[_loc3_] < 0) {
        throw new Error(
            "Forbidden value ("
                + this.referenceIds[_loc3_]
                + ") on element 2 (starting at 1) of referenceIds.");
      }
      param1.writeVarShort(this.referenceIds[_loc3_]);
      _loc3_++;
    }
  }

  public void deserialize(ICustomDataInput param1) {
    int _loc6_ = 0;
    int _loc7_ = 0;
    int _loc2_ = param1.readUnsignedShort();
    int _loc3_ = 0;
    while (_loc3_ < _loc2_) {
      _loc6_ = param1.readVarUhShort();
      if (_loc6_ < 0 || _loc6_ > 559) {
        throw new Error("Forbidden value (" + _loc6_ + ") on elements of cells.");
      }
      this.cells.push(_loc6_);
      _loc3_++;
    }
    int _loc4_ = param1.readUnsignedShort();
    int _loc5_ = 0;
    while (_loc5_ < _loc4_) {
      _loc7_ = param1.readVarUhShort();
      if (_loc7_ < 0) {
        throw new Error("Forbidden value (" + _loc7_ + ") on elements of referenceIds.");
      }
      this.referenceIds.push(_loc7_);
      _loc5_++;
    }
  }
}
