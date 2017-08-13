package package com.ankamagames.dofus.network.messages.game.context.roleplay.houses;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.house.HouseInformationsForSell;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;

public class HouseToSellListMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6140;
    private boolean _isInitialized = false;
    private int pageIndex = 0;
    private int totalPage = 0;
    private Vector.<HouseInformationsForSell> houseList = ;
    private FuncTree _houseListtree = ;
    private int _loc2_ = 0;
    private int _loc2_ = param1.readUnsignedShort();
    private int _loc3_ = 0;
    private int _loc3_ = 0;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 6140;
    }

    public HouseToSellListMessage initHouseToSellListMessage(int param1,int  param2,Vector.<HouseInformationsForSell>  param3) {
         this.pageIndex = param1;
         this.totalPage = param2;
         this.houseList = param3;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.pageIndex = 0;
         this.totalPage = 0;
         this.houseList = new Vector.<HouseInformationsForSell>();
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
         this.serializeAs_HouseToSellListMessage(param1);
    }

    public void serializeAs_HouseToSellListMessage(ICustomDataOutput param1) {
         if(this.pageIndex < 0)
            throw new Exception("Forbidden value (" + this.pageIndex + ") on element pageIndex.");
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_HouseToSellListMessage(param1);
    }

    public void deserializeAs_HouseToSellListMessage(ICustomDataInput param1) {
         HouseInformationsForSell _loc4_ = null;
         this._pageIndexFunc(param1);
         this._totalPageFunc(param1);
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
            _loc4_ = new HouseInformationsForSell();
            _loc4_.deserialize(param1);
            this.houseList.push(_loc4_);
            _loc3_++;
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_HouseToSellListMessage(param1);
    }

    public void deserializeAsyncAs_HouseToSellListMessage(FuncTree param1) {
         param1.addChild(this._pageIndexFunc);
         param1.addChild(this._totalPageFunc);
         this._houseListtree = param1.addChild(this._houseListtreeFunc);
    }

    private void _pageIndexFunc(ICustomDataInput param1) {
         this.pageIndex = param1.readVarUhShort();
         if(this.pageIndex < 0)
            throw new Exception("Forbidden value (" + this.pageIndex + ") on element of HouseToSellListMessage.pageIndex.");
    }

    private void _totalPageFunc(ICustomDataInput param1) {
         this.totalPage = param1.readVarUhShort();
         if(this.totalPage < 0)
            throw new Exception("Forbidden value (" + this.totalPage + ") on element of HouseToSellListMessage.totalPage.");
    }

    private void _houseListtreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
            this._houseListtree.addChild(this._houseListFunc);
            _loc3_++;
    }

    private void _houseListFunc(ICustomDataInput param1) {
         HouseInformationsForSell _loc2_ = new HouseInformationsForSell();
         _loc2_.deserialize(param1);
         this.houseList.push(_loc2_);
    }

}