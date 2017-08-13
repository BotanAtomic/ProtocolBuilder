package package com.ankamagames.dofus.network.messages.game.inventory.items;

import com.ankamagames.dofus.network.messages.game.inventory.exchanges.ExchangeObjectMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;

public class ExchangePodsModifiedMessage extends ExchangeObjectMessage implements INetworkMessage {

    private int protocolId = 6670;
    private boolean _isInitialized = false;
    private int currentWeight = 0;
    private int maxWeight = 0;


    public boolean isInitialized() {
         return super.isInitialized && this._isInitialized;
    }

    public int getMessageId() {
         return 6670;
    }

    public ExchangePodsModifiedMessage initExchangePodsModifiedMessage(boolean param1,int  param2,int  param3) {
         super.initExchangeObjectMessage(param1);
         this.currentWeight = param2;
         this.maxWeight = param3;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         super.reset();
         this.currentWeight = 0;
         this.maxWeight = 0;
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
         this.serializeAs_ExchangePodsModifiedMessage(param1);
    }

    public void serializeAs_ExchangePodsModifiedMessage(ICustomDataOutput param1) {
         super.serializeAs_ExchangeObjectMessage(param1);
         if(this.currentWeight < 0)
            throw new Exception("Forbidden value (" + this.currentWeight + ") on element currentWeight.");
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_ExchangePodsModifiedMessage(param1);
    }

    public void deserializeAs_ExchangePodsModifiedMessage(ICustomDataInput param1) {
         super.deserialize(param1);
         this._currentWeightFunc(param1);
         this._maxWeightFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_ExchangePodsModifiedMessage(param1);
    }

    public void deserializeAsyncAs_ExchangePodsModifiedMessage(FuncTree param1) {
         super.deserializeAsync(param1);
         param1.addChild(this._currentWeightFunc);
         param1.addChild(this._maxWeightFunc);
    }

    private void _currentWeightFunc(ICustomDataInput param1) {
         this.currentWeight = param1.readVarUhInt();
         if(this.currentWeight < 0)
            throw new Exception("Forbidden value (" + this.currentWeight + ") on element of ExchangePodsModifiedMessage.currentWeight.");
    }

    private void _maxWeightFunc(ICustomDataInput param1) {
         this.maxWeight = param1.readVarUhInt();
         if(this.maxWeight < 0)
            throw new Exception("Forbidden value (" + this.maxWeight + ") on element of ExchangePodsModifiedMessage.maxWeight.");
    }

}