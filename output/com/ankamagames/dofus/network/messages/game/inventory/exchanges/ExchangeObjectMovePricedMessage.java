package com.ankamagames.dofus.network.messages.game.inventory.exchanges;

import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;

public class ExchangeObjectMovePricedMessage extends ExchangeObjectMoveMessage implements INetworkMessage {

    private int protocolId = 5514;
    private boolean _isInitialized = false;
    private Number price = 0;


    public boolean isInitialized() {
         return super.isInitialized && this._isInitialized;
    }

    public int getMessageId() {
         return 5514;
    }

    public ExchangeObjectMovePricedMessage initExchangeObjectMovePricedMessage(int param1,int  param2,Number  param3) {
         super.initExchangeObjectMoveMessage(param1,param2);
         this.price = param3;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         super.reset();
         this.price = 0;
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
         this.serializeAs_ExchangeObjectMovePricedMessage(param1);
    }

    public void serializeAs_ExchangeObjectMovePricedMessage(ICustomDataOutput param1) {
         super.serializeAs_ExchangeObjectMoveMessage(param1);
         if(this.price < 0 || this.price > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.price + ") on element price.");
         }
         param1.writeVarLong(this.price);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_ExchangeObjectMovePricedMessage(param1);
    }

    public void deserializeAs_ExchangeObjectMovePricedMessage(ICustomDataInput param1) {
         super.deserialize(param1);
         this._priceFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_ExchangeObjectMovePricedMessage(param1);
    }

    public void deserializeAsyncAs_ExchangeObjectMovePricedMessage(FuncTree param1) {
         super.deserializeAsync(param1);
         param1.addChild(this._priceFunc);
    }

    private void _priceFunc(ICustomDataInput param1) {
         this.price = param1.readVarUhLong();
         if(this.price < 0 || this.price > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.price + ") on element of ExchangeObjectMovePricedMessage.price.");
         }
    }

}