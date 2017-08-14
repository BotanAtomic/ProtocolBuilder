package com.ankamagames.dofus.network.types.game.context.roleplay.job;

import java.lang.Exception;
import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class DecraftedItemStackInfo extends Object implements INetworkType {

  public int objectUID = 0;
  public Number bonusMin = 0;
  public Number bonusMax = 0;
  public Vector<uint> runesId;
  public Vector<uint> runesQty;
  private FuncTree _runesIdtree;
  private FuncTree _runesQtytree;
  public static final int protocolId = 481;

  public void serialize(ICustomDataOutput param1) {
    if (this.objectUID < 0) {
      throw new Error("Forbidden value (" + this.objectUID + ") on element objectUID.");
    }
    param1.writeVarInt(this.objectUID);
    param1.writeFloat(this.bonusMin);
    param1.writeFloat(this.bonusMax);
    param1.writeShort(this.runesId.length);
    int _loc2_ = 0;
    while (_loc2_ < this.runesId.length) {
      if (this.runesId[_loc2_] < 0) {
        throw new Error(
            "Forbidden value ("
                + this.runesId[_loc2_]
                + ") on element 4 (starting at 1) of runesId.");
      }
      param1.writeVarShort(this.runesId[_loc2_]);
      _loc2_++;
    }
    param1.writeShort(this.runesQty.length);
    int _loc3_ = 0;
    while (_loc3_ < this.runesQty.length) {
      if (this.runesQty[_loc3_] < 0) {
        throw new Error(
            "Forbidden value ("
                + this.runesQty[_loc3_]
                + ") on element 5 (starting at 1) of runesQty.");
      }
      param1.writeVarInt(this.runesQty[_loc3_]);
      _loc3_++;
    }
  }

  public void deserialize(ICustomDataInput param1) {
    int _loc6_ = 0;
    int _loc7_ = 0;
    this.objectUID = param1.readVarUhInt();
    if (this.objectUID < 0) {
      throw new Error(
          "Forbidden value ("
              + this.objectUID
              + ") on element of ObjectItemToSellInHumanVendorShop.objectUID.");
    }

    this.bonusMin = param1.readFloat();

    this.bonusMax = param1.readFloat();

    int _loc2_ = param1.readUnsignedShort();
    int _loc3_ = 0;
    while (_loc3_ < _loc2_) {
      _loc6_ = param1.readVarUhShort();
      if (_loc6_ < 0) {
        throw new Error("Forbidden value (" + _loc6_ + ") on elements of runesId.");
      }
      this.runesId.push(_loc6_);
      _loc3_++;
    }
    int _loc4_ = param1.readUnsignedShort();
    int _loc5_ = 0;
    while (_loc5_ < _loc4_) {
      _loc7_ = param1.readVarUhInt();
      if (_loc7_ < 0) {
        throw new Error("Forbidden value (" + _loc7_ + ") on elements of runesQty.");
      }
      this.runesQty.push(_loc7_);
      _loc5_++;
    }
  }
}
