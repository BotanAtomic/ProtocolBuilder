package com.ankamagames.dofus.network.types.game.context;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class EntityMovementInformations extends Object implements INetworkType {

  public int id = 0;
  public Vector<Integer> steps;
  private FuncTree _stepstree;
  public static final int protocolId = 63;

  public void serialize(ICustomDataOutput param1) {
    param1.writeInt(this.id);
    param1.writeShort(this.steps.length);
    int _loc2_ = 0;
    while (_loc2_ < this.steps.length) {
      param1.writeByte(this.steps[_loc2_]);
      _loc2_++;
    }
  }

  public void deserialize(ICustomDataInput param1) {
    Object _loc4_ = 0;
    this.id = param1.readUTF();

    int _loc2_ = param1.readUnsignedShort();
    int _loc3_ = 0;
    while (_loc3_ < _loc2_) {
      _loc4_ = param1.readByte();
      this.steps.push(_loc4_);
      _loc3_++;
    }
  }
}
