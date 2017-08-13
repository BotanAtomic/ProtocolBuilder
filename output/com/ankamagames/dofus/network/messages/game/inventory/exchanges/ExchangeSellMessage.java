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

public class ExchangeSellMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 5778;
    private boolean _isInitialized = false;
    private int objectToSellId = 0;
    private int quantity = 0;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 5778;
    }

    public ExchangeSellMessage initExchangeSellMessage(int param1,int  param2) {
         this.objectToSellId = param1;
         this.quantity = param2;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.objectToSellId = 0;
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
         this.serializeAs_ExchangeSellMessage(param1);
    }

    public void serializeAs_ExchangeSellMessage(ICustomDataOutput param1) {
         if(this.objectToSellId < 0)
            throw new Exception("Forbidden value (" + this.objectToSellId + ") on element objectToSellId.");
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_ExchangeSellMessage(param1);
    }

    public void deserializeAs_ExchangeSellMessage(ICustomDataInput param1) {
         this._objectToSellIdFunc(param1);
         this._quantityFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_ExchangeSellMessage(param1);
    }

    public void deserializeAsyncAs_ExchangeSellMessage(FuncTree param1) {
         param1.addChild(this._objectToSellIdFunc);
         param1.addChild(this._quantityFunc);
    }

    private void _objectToSellIdFunc(ICustomDataInput param1) {
         this.objectToSellId = param1.readVarUhInt();
         if(this.objectToSellId < 0)
            throw new Exception("Forbidden value (" + this.objectToSellId + ") on element of ExchangeSellMessage.objectToSellId.");
    }

    private void _quantityFunc(ICustomDataInput param1) {
         this.quantity = param1.readVarUhInt();
         if(this.quantity < 0)
            throw new Exception("Forbidden value (" + this.quantity + ") on element of ExchangeSellMessage.quantity.");
    }

}