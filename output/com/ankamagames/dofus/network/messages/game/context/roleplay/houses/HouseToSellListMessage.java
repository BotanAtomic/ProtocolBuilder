package com.ankamagames.dofus.network.messages.game.context.roleplay.houses;

import java.lang.Exception;
import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.house.HouseInformationsForSell;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class HouseToSellListMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public int pageIndex = 0;
  public int totalPage = 0;
  public Vector<HouseInformationsForSell> houseList;
  private FuncTree _houseListtree;
  public static final int protocolId = 6140;

  public void serialize(ICustomDataOutput param1) {
    if (this.pageIndex < 0) {
      throw new Error("Forbidden value (" + this.pageIndex + ") on element pageIndex.");
    }
    param1.writeVarShort(this.pageIndex);
    if (this.totalPage < 0) {
      throw new Error("Forbidden value (" + this.totalPage + ") on element totalPage.");
    }
    param1.writeVarShort(this.totalPage);
    param1.writeShort(this.houseList.length);
    int _loc2_ = 0;
    while (_loc2_ < this.houseList.length) {
      ((HouseInformationsForSell) this.houseList[_loc2_]).serializeAs_(param1);
      _loc2_++;
    }
  }

  public void deserialize(ICustomDataInput param1) {
    HouseInformationsForSell _loc4_ = null;
    this.pageIndex = param1.readVarUhShort();
    if (this.pageIndex < 0) {
      throw new Error(
          "Forbidden value ("
              + this.pageIndex
              + ") on element of PaddockToSellListRequestMessage.pageIndex.");
    }

    this.totalPage = param1.readVarUhShort();
    if (this.totalPage < 0) {
      throw new Error(
          "Forbidden value ("
              + this.totalPage
              + ") on element of PaddockToSellListMessage.totalPage.");
    }

    int _loc2_ = param1.readUnsignedShort();
    int _loc3_ = 0;
    while (_loc3_ < _loc2_) {
      _loc4_ = new HouseInformationsForSell();
      _loc4_.deserialize(param1);
      this.houseList.push(_loc4_);
      _loc3_++;
    }
  }
}
