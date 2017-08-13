package package com.ankamagames.dofus.network.messages.game.context.roleplay.houses;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;

public class HouseToSellListRequestMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6139;
    private boolean _isInitialized = false;
    private int pageIndex = 0;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 6139;
    }

    public HouseToSellListRequestMessage initHouseToSellListRequestMessage(int param1) {
         this.pageIndex = param1;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.pageIndex = 0;
         this._isInitialized = false;
    }

    public void pack(ICustomDataOutput param1) {
         ByteArray _loc2_ = new ByteArray();
         this.serialize(new CustomDataWrapper(_loc2_));
         writePacket(param1,this.getMessageId(),_loc2_);
    }

    public void unpack(ICustomDataInput param1,int  param2) {
         this.deserialize(param1);
    }

    public FuncTree unpackAsync(ICustomDataInput param1,int  param2) {
         FuncTree _loc3_ = new FuncTree();
         _loc3_.setRoot(param1);
         this.deserializeAsync(_loc3_);
         return _loc3_;
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_HouseToSellListRequestMessage(param1);
    }

    public void serializeAs_HouseToSellListRequestMessage(ICustomDataOutput param1) {
         if(this.pageIndex < 0)
            throw new Exception("Forbidden value (" + this.pageIndex + ") on element pageIndex.");
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_HouseToSellListRequestMessage(param1);
    }

    public void deserializeAs_HouseToSellListRequestMessage(ICustomDataInput param1) {
         this._pageIndexFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_HouseToSellListRequestMessage(param1);
    }

    public void deserializeAsyncAs_HouseToSellListRequestMessage(FuncTree param1) {
         param1.addChild(this._pageIndexFunc);
    }

    private void _pageIndexFunc(ICustomDataInput param1) {
         this.pageIndex = param1.readVarUhShort();
         if(this.pageIndex < 0)
            throw new Exception("Forbidden value (" + this.pageIndex + ") on element of HouseToSellListRequestMessage.pageIndex.");
    }

}