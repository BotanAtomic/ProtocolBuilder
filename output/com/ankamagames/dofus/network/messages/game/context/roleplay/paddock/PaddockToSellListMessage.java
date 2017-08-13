package package com.ankamagames.dofus.network.messages.game.context.roleplay.paddock;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.paddock.PaddockInformationsForSell;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;

public class PaddockToSellListMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6138;
    private boolean _isInitialized = false;
    private int pageIndex = 0;
    private int totalPage = 0;
    private Vector.<PaddockInformationsForSell> paddockList = ;
    private FuncTree _paddockListtree = ;
    private int _loc2_ = 0;
    private int _loc2_ = param1.readUnsignedShort();
    private int _loc3_ = 0;
    private int _loc3_ = 0;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 6138;
    }

    public PaddockToSellListMessage initPaddockToSellListMessage(int param1,int  param2,Vector.<PaddockInformationsForSell>  param3) {
         this.pageIndex = param1;
         this.totalPage = param2;
         this.paddockList = param3;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.pageIndex = 0;
         this.totalPage = 0;
         this.paddockList = new Vector.<PaddockInformationsForSell>();
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
         this.serializeAs_PaddockToSellListMessage(param1);
    }

    public void serializeAs_PaddockToSellListMessage(ICustomDataOutput param1) {
         if(this.pageIndex < 0)
            throw new Exception("Forbidden value (" + this.pageIndex + ") on element pageIndex.");
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_PaddockToSellListMessage(param1);
    }

    public void deserializeAs_PaddockToSellListMessage(ICustomDataInput param1) {
         PaddockInformationsForSell _loc4_ = null;
         this._pageIndexFunc(param1);
         this._totalPageFunc(param1);
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
            _loc4_ = new PaddockInformationsForSell();
            _loc4_.deserialize(param1);
            this.paddockList.push(_loc4_);
            _loc3_++;
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_PaddockToSellListMessage(param1);
    }

    public void deserializeAsyncAs_PaddockToSellListMessage(FuncTree param1) {
         param1.addChild(this._pageIndexFunc);
         param1.addChild(this._totalPageFunc);
         this._paddockListtree = param1.addChild(this._paddockListtreeFunc);
    }

    private void _pageIndexFunc(ICustomDataInput param1) {
         this.pageIndex = param1.readVarUhShort();
         if(this.pageIndex < 0)
            throw new Exception("Forbidden value (" + this.pageIndex + ") on element of PaddockToSellListMessage.pageIndex.");
    }

    private void _totalPageFunc(ICustomDataInput param1) {
         this.totalPage = param1.readVarUhShort();
         if(this.totalPage < 0)
            throw new Exception("Forbidden value (" + this.totalPage + ") on element of PaddockToSellListMessage.totalPage.");
    }

    private void _paddockListtreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
            this._paddockListtree.addChild(this._paddockListFunc);
            _loc3_++;
    }

    private void _paddockListFunc(ICustomDataInput param1) {
         PaddockInformationsForSell _loc2_ = new PaddockInformationsForSell();
         _loc2_.deserialize(param1);
         this.paddockList.push(_loc2_);
    }

}