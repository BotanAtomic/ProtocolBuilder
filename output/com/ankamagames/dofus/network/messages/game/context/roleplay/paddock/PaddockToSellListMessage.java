package com.ankamagames.dofus.network.messages.game.context.roleplay.paddock;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.paddock.PaddockInformationsForSell;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class PaddockToSellListMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6138;
    private boolean _isInitialized = false;
    private int pageIndex = 0;
    private int totalPage = 0;
    private PaddockInformationsForSell[] paddockList;
    private FuncTree _paddockListtree;


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
         param1.writeShort(this.paddockList.length);
         int _loc2_ = 0;
         while(_loc2_ < this.paddockList.length)
         {
            (this.paddockList[_loc2_] as PaddockInformationsForSell).serializeAs_PaddockInformationsForSell(param1);
            _loc2_++;
         }
    }

    public void deserialize(ICustomDataInput param1) {
         PaddockInformationsForSell _loc4_ = null;
         this.pageIndex = param1.readVarUhShort();
         if(this.pageIndex < 0)
         {
            throw new Exception("Forbidden value (" + this.pageIndex + ") on element of PaddockToSellListMessage.pageIndex.");
         }
         this.totalPage = param1.readVarUhShort();
         if(this.totalPage < 0)
         {
            throw new Exception("Forbidden value (" + this.totalPage + ") on element of PaddockToSellListMessage.totalPage.");
         }
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            _loc4_ = new PaddockInformationsForSell();
            _loc4_.deserialize(param1);
            this.paddockList.push(_loc4_);
            _loc3_++;
         }
    }

}