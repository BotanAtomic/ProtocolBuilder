package com.ankamagames.dofus.network.messages.game.context.roleplay.havenbag;

import java.lang.Exception;
import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class HavenBagFurnituresRequestMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public Vector<uint> cellIds;
  public Vector<Integer> funitureIds;
  public Vector<uint> orientations;
  private FuncTree _cellIdstree;
  private FuncTree _funitureIdstree;
  private FuncTree _orientationstree;
  public static final int protocolId = 6637;

  public void serialize(ICustomDataOutput param1) {
    param1.writeShort(this.cellIds.length);
    int _loc2_ = 0;
    while (_loc2_ < this.cellIds.length) {
      if (this.cellIds[_loc2_] < 0) {
        throw new Error(
            "Forbidden value ("
                + this.cellIds[_loc2_]
                + ") on element 1 (starting at 1) of cellIds.");
      }
      param1.writeVarShort(this.cellIds[_loc2_]);
      _loc2_++;
    }
    param1.writeShort(this.funitureIds.length);
    int _loc3_ = 0;
    while (_loc3_ < this.funitureIds.length) {
      param1.writeInt(this.funitureIds[_loc3_]);
      _loc3_++;
    }
    param1.writeShort(this.orientations.length);
    int _loc4_ = 0;
    while (_loc4_ < this.orientations.length) {
      if (this.orientations[_loc4_] < 0) {
        throw new Error(
            "Forbidden value ("
                + this.orientations[_loc4_]
                + ") on element 3 (starting at 1) of orientations.");
      }
      param1.writeByte(this.orientations[_loc4_]);
      _loc4_++;
    }
  }

  public void deserialize(ICustomDataInput param1) {
    int _loc8_ = 0;
    Object _loc9_ = 0;
    int _loc10_ = 0;
    int _loc2_ = param1.readUnsignedShort();
    int _loc3_ = 0;
    while (_loc3_ < _loc2_) {
      _loc8_ = param1.readVarUhShort();
      if (_loc8_ < 0) {
        throw new Error("Forbidden value (" + _loc8_ + ") on elements of cellIds.");
      }
      this.cellIds.push(_loc8_);
      _loc3_++;
    }
    int _loc4_ = param1.readUnsignedShort();
    int _loc5_ = 0;
    while (_loc5_ < _loc4_) {
      _loc9_ = param1.readInt();
      this.funitureIds.push(_loc9_);
      _loc5_++;
    }
    int _loc6_ = param1.readUnsignedShort();
    int _loc7_ = 0;
    while (_loc7_ < _loc6_) {
      _loc10_ = param1.readByte();
      if (_loc10_ < 0) {
        throw new Error("Forbidden value (" + _loc10_ + ") on elements of orientations.");
      }
      this.orientations.push(_loc10_);
      _loc7_++;
    }
  }
}
