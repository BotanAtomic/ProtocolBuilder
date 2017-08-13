package com.ankamagames.dofus.network.messages.game.context.roleplay.houses;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.house.HouseInformationsForSell;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class HouseToSellListMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6140;
    private boolean _isInitialized = false;
    private int pageIndex = 0;
    private int totalPage = 0;
    private HouseInformationsForSell[] houseList;
    private FuncTree _houseListtree;


    public void serialize(ICustomDataOutput param1) {
         if(this.pageIndex < 0)
         {
            throw new Exception("Forbidden value (" + this.pageIndex + ") on element pageIndex.");
         }
         param1.writeVarShort(this.pageIndex);
         if(this.totalPage < 0)
         {
            throw new Exception("Forbidden value (" + this.totalPage + ") on element totalPage.");
         }
         param1.writeVarShort(this.totalPage);
         param1.writeShort(this.houseList.length);
         int _loc2_ = 0;
         while(_loc2_ < this.houseList.length)
         {
            (this.houseList[_loc2_] as HouseInformationsForSell).serializeAs_HouseInformationsForSell(param1);
            _loc2_++;
         }
    }

    public void deserialize(ICustomDataInput param1) {
         HouseInformationsForSell _loc4_ = null;
         this.pageIndex = param1.readVarUhShort();
         if(this.pageIndex < 0)
         {
            throw new Exception("Forbidden value (" + this.pageIndex + ") on element of HouseToSellListMessage.pageIndex.");
         }
         this.totalPage = param1.readVarUhShort();
         if(this.totalPage < 0)
         {
            throw new Exception("Forbidden value (" + this.totalPage + ") on element of HouseToSellListMessage.totalPage.");
         }
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            _loc4_ = new HouseInformationsForSell();
            _loc4_.deserialize(param1);
            this.houseList.push(_loc4_);
            _loc3_++;
         }
    }

}