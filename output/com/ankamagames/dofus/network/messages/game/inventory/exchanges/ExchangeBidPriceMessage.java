package package com.ankamagames.dofus.network.messages.game.inventory.exchanges;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;

public class ExchangeBidPriceMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 5755;
    private boolean _isInitialized = false;
    private int genericId = 0;
    private Number averagePrice = 0;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 5755;
    }

    public ExchangeBidPriceMessage initExchangeBidPriceMessage(int param1,Number  param2) {
         this.genericId = param1;
         this.averagePrice = param2;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.genericId = 0;
         this.averagePrice = 0;
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
         this.serializeAs_ExchangeBidPriceMessage(param1);
    }

    public void serializeAs_ExchangeBidPriceMessage(ICustomDataOutput param1) {
         if(this.genericId < 0)
            throw new Exception("Forbidden value (" + this.genericId + ") on element genericId.");
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_ExchangeBidPriceMessage(param1);
    }

    public void deserializeAs_ExchangeBidPriceMessage(ICustomDataInput param1) {
         this._genericIdFunc(param1);
         this._averagePriceFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_ExchangeBidPriceMessage(param1);
    }

    public void deserializeAsyncAs_ExchangeBidPriceMessage(FuncTree param1) {
         param1.addChild(this._genericIdFunc);
         param1.addChild(this._averagePriceFunc);
    }

    private void _genericIdFunc(ICustomDataInput param1) {
         this.genericId = param1.readVarUhShort();
         if(this.genericId < 0)
            throw new Exception("Forbidden value (" + this.genericId + ") on element of ExchangeBidPriceMessage.genericId.");
    }

    private void _averagePriceFunc(ICustomDataInput param1) {
         this.averagePrice = param1.readVarLong();
         if(this.averagePrice < -9.007199254740992E15 || this.averagePrice > 9.007199254740992E15)
            throw new Exception("Forbidden value (" + this.averagePrice + ") on element of ExchangeBidPriceMessage.averagePrice.");
    }

}