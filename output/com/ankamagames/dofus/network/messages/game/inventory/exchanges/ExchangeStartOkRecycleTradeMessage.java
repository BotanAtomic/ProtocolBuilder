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

public class ExchangeStartOkRecycleTradeMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6600;
    private boolean _isInitialized = false;
    private int percentToPrism = 0;
    private int percentToPlayer = 0;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 6600;
    }

    public ExchangeStartOkRecycleTradeMessage initExchangeStartOkRecycleTradeMessage(int param1,int  param2) {
         this.percentToPrism = param1;
         this.percentToPlayer = param2;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.percentToPrism = 0;
         this.percentToPlayer = 0;
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
         this.serializeAs_ExchangeStartOkRecycleTradeMessage(param1);
    }

    public void serializeAs_ExchangeStartOkRecycleTradeMessage(ICustomDataOutput param1) {
         if(this.percentToPrism < 0)
            throw new Exception("Forbidden value (" + this.percentToPrism + ") on element percentToPrism.");
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_ExchangeStartOkRecycleTradeMessage(param1);
    }

    public void deserializeAs_ExchangeStartOkRecycleTradeMessage(ICustomDataInput param1) {
         this._percentToPrismFunc(param1);
         this._percentToPlayerFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_ExchangeStartOkRecycleTradeMessage(param1);
    }

    public void deserializeAsyncAs_ExchangeStartOkRecycleTradeMessage(FuncTree param1) {
         param1.addChild(this._percentToPrismFunc);
         param1.addChild(this._percentToPlayerFunc);
    }

    private void _percentToPrismFunc(ICustomDataInput param1) {
         this.percentToPrism = param1.readShort();
         if(this.percentToPrism < 0)
            throw new Exception("Forbidden value (" + this.percentToPrism + ") on element of ExchangeStartOkRecycleTradeMessage.percentToPrism.");
    }

    private void _percentToPlayerFunc(ICustomDataInput param1) {
         this.percentToPlayer = param1.readShort();
         if(this.percentToPlayer < 0)
            throw new Exception("Forbidden value (" + this.percentToPlayer + ") on element of ExchangeStartOkRecycleTradeMessage.percentToPlayer.");
    }

}