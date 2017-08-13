package com.ankamagames.dofus.network.messages.game.inventory.exchanges;

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

public class ExchangeWeightMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 5793;
    private boolean _isInitialized = false;
    private int currentWeight = 0;
    private int maxWeight = 0;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 5793;
    }

    public ExchangeWeightMessage initExchangeWeightMessage(int param1,int  param2) {
         this.currentWeight = param1;
         this.maxWeight = param2;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
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
         this.serializeAs_ExchangeWeightMessage(param1);
    }

    public void serializeAs_ExchangeWeightMessage(ICustomDataOutput param1) {
         if(this.currentWeight < 0)
         {
            throw new Exception("Forbidden value (" + this.currentWeight + ") on element currentWeight.");
         }
         param1.writeVarInt(this.currentWeight);
         if(this.maxWeight < 0)
         {
            throw new Exception("Forbidden value (" + this.maxWeight + ") on element maxWeight.");
         }
         param1.writeVarInt(this.maxWeight);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_ExchangeWeightMessage(param1);
    }

    public void deserializeAs_ExchangeWeightMessage(ICustomDataInput param1) {
         this._currentWeightFunc(param1);
         this._maxWeightFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_ExchangeWeightMessage(param1);
    }

    public void deserializeAsyncAs_ExchangeWeightMessage(FuncTree param1) {
         param1.addChild(this._currentWeightFunc);
         param1.addChild(this._maxWeightFunc);
    }

    private void _currentWeightFunc(ICustomDataInput param1) {
         this.currentWeight = param1.readVarUhInt();
         if(this.currentWeight < 0)
         {
            throw new Exception("Forbidden value (" + this.currentWeight + ") on element of ExchangeWeightMessage.currentWeight.");
         }
    }

    private void _maxWeightFunc(ICustomDataInput param1) {
         this.maxWeight = param1.readVarUhInt();
         if(this.maxWeight < 0)
         {
            throw new Exception("Forbidden value (" + this.maxWeight + ") on element of ExchangeWeightMessage.maxWeight.");
         }
    }

}