package com.ankamagames.dofus.network.types.game.context.fight;

import java.lang.Exception;
import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class FightLoot extends Object implements INetworkType {

  public Vector<uint> objects;
  public Number kamas = 0;
  private FuncTree _objectstree;
  public static final int protocolId = 41;

  public void serialize(ICustomDataOutput param1) {
    param1.writeShort(this.objects.length);
    int _loc2_ = 0;
    while (_loc2_ < this.objects.length) {
      if (this.objects[_loc2_] < 0) {
        throw new Error(
            "Forbidden value ("
                + this.objects[_loc2_]
                + ") on element 1 (starting at 1) of objects.");
      }
      param1.writeVarShort(this.objects[_loc2_]);
      _loc2_++;
    }
    if (this.kamas < 0 || this.kamas > 9.007199254740992E15) {
      throw new Error("Forbidden value (" + this.kamas + ") on element kamas.");
    }
    param1.writeVarLong(this.kamas);
  }

  public void deserialize(ICustomDataInput param1) {
    int _loc4_ = 0;
    int _loc2_ = param1.readUnsignedShort();
    int _loc3_ = 0;
    while (_loc3_ < _loc2_) {
      _loc4_ = param1.readVarUhShort();
      if (_loc4_ < 0) {
        throw new Error("Forbidden value (" + _loc4_ + ") on elements of objects.");
      }
      this.objects.push(_loc4_);
      _loc3_++;
    }
    this.kamas = param1.readVarUhLong();
    if (this.kamas < 0 || this.kamas > 9.007199254740992E15) {
      throw new Error(
          "Forbidden value (" + this.kamas + ") on element of TaxCollectorLootInformations.kamas.");
    }
  }
}
