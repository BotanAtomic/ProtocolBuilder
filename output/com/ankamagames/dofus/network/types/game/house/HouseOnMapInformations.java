package com.ankamagames.dofus.network.types.game.house;

import java.lang.Exception;
import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class HouseOnMapInformations extends HouseInformations implements INetworkType {

  public Vector<uint> doorsOnMap;
  public Vector<HouseInstanceInformations> houseInstances;
  private FuncTree _doorsOnMaptree;
  private FuncTree _houseInstancestree;
  public static final int protocolId = 510;

  @Override
  public void serialize(ICustomDataOutput param1) {
    if (this.houseId < 0) {
      throw new Error("Forbidden value (" + this.houseId + ") on element houseId.");
    }
    param1.writeVarInt(this.houseId);
    if (this.modelId < 0) {
      throw new Error("Forbidden value (" + this.modelId + ") on element modelId.");
    }
    param1.writeVarShort(this.modelId);

    param1.writeShort(this.doorsOnMap.length);
    int _loc2_ = 0;
    while (_loc2_ < this.doorsOnMap.length) {
      if (this.doorsOnMap[_loc2_] < 0) {
        throw new Error(
            "Forbidden value ("
                + this.doorsOnMap[_loc2_]
                + ") on element 1 (starting at 1) of doorsOnMap.");
      }
      param1.writeInt(this.doorsOnMap[_loc2_]);
      _loc2_++;
    }
    param1.writeShort(this.houseInstances.length);
    int _loc3_ = 0;
    while (_loc3_ < this.houseInstances.length) {
      ((HouseInstanceInformations) this.houseInstances[_loc3_]).serializeAs_(param1);
      _loc3_++;
    }
  }

  @Override
  public void deserialize(ICustomDataInput param1) {
    int _loc6_ = 0;
    HouseInstanceInformations _loc7_ = null;
    this.uid = param1.readUTF();

    this.figure = param1.readVarUhShort();
    if (this.figure < 0) {
      throw new Error(
          "Forbidden value (" + this.figure + ") on element of KrosmasterFigure.figure.");
    }

    this.pedestal = param1.readVarUhShort();
    if (this.pedestal < 0) {
      throw new Error(
          "Forbidden value (" + this.pedestal + ") on element of KrosmasterFigure.pedestal.");
    }

    this.bound = param1.readBoolean();

    int _loc2_ = param1.readUnsignedShort();
    int _loc3_ = 0;
    while (_loc3_ < _loc2_) {
      _loc6_ = param1.readInt();
      if (_loc6_ < 0) {
        throw new Error("Forbidden value (" + _loc6_ + ") on elements of doorsOnMap.");
      }
      this.doorsOnMap.push(_loc6_);
      _loc3_++;
    }
    int _loc4_ = param1.readUnsignedShort();
    int _loc5_ = 0;
    while (_loc5_ < _loc4_) {
      _loc7_ = new HouseInstanceInformations();
      _loc7_.deserialize(param1);
      this.houseInstances.push(_loc7_);
      _loc5_++;
    }
  }
}
