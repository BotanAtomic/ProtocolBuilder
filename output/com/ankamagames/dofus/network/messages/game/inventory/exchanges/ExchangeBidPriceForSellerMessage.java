package com.ankamagames.dofus.network.messages.game.inventory.exchanges;

import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;

public class ExchangeBidPriceForSellerMessage extends ExchangeBidPriceMessage implements INetworkMessage {

    private int protocolId = 6464;
    private boolean _isInitialized = false;
    private boolean allIdentical = false;
    private Vector<Number> minimalPrices;
    private FuncTree _minimalPricestree;


    public boolean isInitialized() {
         return super.isInitialized && this._isInitialized;
    }

    public int getMessageId() {
         return 6464;
    }

    public ExchangeBidPriceForSellerMessage initExchangeBidPriceForSellerMessage(int param1,Number  param2,boolean  param3,Vector<Number>  param4) {
         super.initExchangeBidPriceMessage(param1,param2);
         this.allIdentical = param3;
         this.minimalPrices = param4;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         super.reset();
         this.allIdentical = false;
         this.minimalPrices = new Vector.<Number>();
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
         this.serializeAs_ExchangeBidPriceForSellerMessage(param1);
    }

    public void serializeAs_ExchangeBidPriceForSellerMessage(ICustomDataOutput param1) {
         super.serializeAs_ExchangeBidPriceMessage(param1);
         param1.writeBoolean(this.allIdentical);
         param1.writeShort(this.minimalPrices.length);
         int _loc2_ = 0;
         while(_loc2_ < this.minimalPrices.length)
         {
            if(this.minimalPrices[_loc2_] < 0 || this.minimalPrices[_loc2_] > 9.007199254740992E15)
            {
               throw new Exception("Forbidden value (" + this.minimalPrices[_loc2_] + ") on element 2 (starting at 1) of minimalPrices.");
            }
            param1.writeVarLong(this.minimalPrices[_loc2_]);
            _loc2_++;
         }
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_ExchangeBidPriceForSellerMessage(param1);
    }

    public void deserializeAs_ExchangeBidPriceForSellerMessage(ICustomDataInput param1) {
         * _loc4_ = NaN;
         super.deserialize(param1);
         this._allIdenticalFunc(param1);
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            _loc4_ = param1.readVarUhLong();
            if(_loc4_ < 0 || _loc4_ > 9.007199254740992E15)
            {
               throw new Exception("Forbidden value (" + _loc4_ + ") on elements of minimalPrices.");
            }
            this.minimalPrices.push(_loc4_);
            _loc3_++;
         }
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_ExchangeBidPriceForSellerMessage(param1);
    }

    public void deserializeAsyncAs_ExchangeBidPriceForSellerMessage(FuncTree param1) {
         super.deserializeAsync(param1);
         param1.addChild(this._allIdenticalFunc);
         this._minimalPricestree = param1.addChild(this._minimalPricestreeFunc);
    }

    private void _allIdenticalFunc(ICustomDataInput param1) {
         this.allIdentical = param1.readBoolean();
    }

    private void _minimalPricestreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            this._minimalPricestree.addChild(this._minimalPricesFunc);
            _loc3_++;
         }
    }

    private void _minimalPricesFunc(ICustomDataInput param1) {
         Number _loc2_ = param1.readVarUhLong();
         if(_loc2_ < 0 || _loc2_ > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + _loc2_ + ") on elements of minimalPrices.");
         }
         this.minimalPrices.push(_loc2_);
    }

}