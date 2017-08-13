package package com.ankamagames.dofus.network.messages.game.inventory;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;

public class ObjectAveragePricesMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6335;
    private boolean _isInitialized = false;
    private Vector.<uint> ids = ;
    private Vector.<Number> avgPrices = ;
    private FuncTree _idstree = ;
    private FuncTree _avgPricestree = ;
    private int _loc2_ = 0;
    private int _loc3_ = 0;
    private * _loc7_ = NaN;
    private int _loc2_ = param1.readUnsignedShort();
    private int _loc3_ = 0;
    private int _loc4_ = param1.readUnsignedShort();
    private int _loc5_ = 0;
    private int _loc3_ = 0;
    private int _loc3_ = 0;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 6335;
    }

    public ObjectAveragePricesMessage initObjectAveragePricesMessage(Vector.<uint> param1,Vector.<Number>  param2) {
         this.ids = param1;
         this.avgPrices = param2;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.ids = new Vector.<uint>();
         this.avgPrices = new Vector.<Number>();
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
         this.serializeAs_ObjectAveragePricesMessage(param1);
    }

    public void serializeAs_ObjectAveragePricesMessage(ICustomDataOutput param1) {
         param1.writeShort(this.ids.length);
         int _loc2_ = 0;
         while(_loc2_ < this.ids.length)
            if(this.ids[_loc2_] < 0)
               throw new Exception("Forbidden value (" + this.ids[_loc2_] + ") on element 1 (starting at 1) of ids.");
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_ObjectAveragePricesMessage(param1);
    }

    public void deserializeAs_ObjectAveragePricesMessage(ICustomDataInput param1) {
         int _loc6_ = 0;
         * _loc7_ = NaN;
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
            _loc6_ = param1.readVarUhShort();
            if(_loc6_ < 0)
               throw new Exception("Forbidden value (" + _loc6_ + ") on elements of ids.");
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_ObjectAveragePricesMessage(param1);
    }

    public void deserializeAsyncAs_ObjectAveragePricesMessage(FuncTree param1) {
         this._idstree = param1.addChild(this._idstreeFunc);
         this._avgPricestree = param1.addChild(this._avgPricestreeFunc);
    }

    private void _idstreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
            this._idstree.addChild(this._idsFunc);
            _loc3_++;
    }

    private void _idsFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readVarUhShort();
         if(_loc2_ < 0)
            throw new Exception("Forbidden value (" + _loc2_ + ") on elements of ids.");
    }

    private void _avgPricestreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
            this._avgPricestree.addChild(this._avgPricesFunc);
            _loc3_++;
    }

    private void _avgPricesFunc(ICustomDataInput param1) {
         Number _loc2_ = param1.readVarUhLong();
         if(_loc2_ < 0 || _loc2_ > 9.007199254740992E15)
            throw new Exception("Forbidden value (" + _loc2_ + ") on elements of avgPrices.");
    }

}