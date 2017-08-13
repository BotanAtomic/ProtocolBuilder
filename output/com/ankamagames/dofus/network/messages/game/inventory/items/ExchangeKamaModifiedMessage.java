package package com.ankamagames.dofus.network.messages.game.inventory.items;

import com.ankamagames.dofus.network.messages.game.inventory.exchanges.ExchangeObjectMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;

public class ExchangeKamaModifiedMessage extends ExchangeObjectMessage implements INetworkMessage {

    private int protocolId = 5521;
    private boolean _isInitialized = false;
    private Number quantity = 0;


    public boolean isInitialized() {
         return super.isInitialized && this._isInitialized;
    }

    public int getMessageId() {
         return 5521;
    }

    public ExchangeKamaModifiedMessage initExchangeKamaModifiedMessage(boolean param1,Number  param2) {
         super.initExchangeObjectMessage(param1);
         this.quantity = param2;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         super.reset();
         this.quantity = 0;
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
         this.serializeAs_ExchangeKamaModifiedMessage(param1);
    }

    public void serializeAs_ExchangeKamaModifiedMessage(ICustomDataOutput param1) {
         super.serializeAs_ExchangeObjectMessage(param1);
         if(this.quantity < 0 || this.quantity > 9.007199254740992E15)
            throw new Exception("Forbidden value (" + this.quantity + ") on element quantity.");
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_ExchangeKamaModifiedMessage(param1);
    }

    public void deserializeAs_ExchangeKamaModifiedMessage(ICustomDataInput param1) {
         super.deserialize(param1);
         this._quantityFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_ExchangeKamaModifiedMessage(param1);
    }

    public void deserializeAsyncAs_ExchangeKamaModifiedMessage(FuncTree param1) {
         super.deserializeAsync(param1);
         param1.addChild(this._quantityFunc);
    }

    private void _quantityFunc(ICustomDataInput param1) {
         this.quantity = param1.readVarUhLong();
         if(this.quantity < 0 || this.quantity > 9.007199254740992E15)
            throw new Exception("Forbidden value (" + this.quantity + ") on element of ExchangeKamaModifiedMessage.quantity.");
    }

}