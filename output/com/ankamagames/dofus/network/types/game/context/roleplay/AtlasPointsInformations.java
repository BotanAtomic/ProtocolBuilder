package com.ankamagames.dofus.network.types.game.context.roleplay;

import java.lang.Exception;
import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.dofus.network.types.game.context.MapCoordinatesExtended;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class AtlasPointsInformations extends Object implements INetworkType {

  public int type = 0;
  public Vector<MapCoordinatesExtended> coords;
  private FuncTree _coordstree;
  public static final int protocolId = 175;

  public void serialize(ICustomDataOutput param1) {
    param1.writeByte(this.type);
    param1.writeShort(this.coords.length);
    int _loc2_ = 0;
    while (_loc2_ < this.coords.length) {
      ((MapCoordinatesExtended) this.coords[_loc2_]).serializeAs_(param1);
      _loc2_++;
    }
  }

  public void deserialize(ICustomDataInput param1) {
    MapCoordinatesExtended _loc4_ = null;
    this.type = param1.readByte();
    if (this.type < 0) {
      throw new Exception(
          "Forbidden value (" + this.type + ") on element of UpdateMountBoost.type.");
    }

    int _loc2_ = param1.readUnsignedShort();
    int _loc3_ = 0;
    while (_loc3_ < _loc2_) {
      _loc4_ = new MapCoordinatesExtended();
      _loc4_.deserialize(param1);
      this.coords.push(_loc4_);
      _loc3_++;
    }
  }
}
