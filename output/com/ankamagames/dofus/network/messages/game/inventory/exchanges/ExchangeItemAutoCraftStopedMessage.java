package package com.ankamagames.dofus.network.messages.game.inventory.exchanges;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class ExchangeItemAutoCraftStopedMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 5810;
    private boolean _isInitialized = false;
    private int reason = 0;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 5810;
    }

    public ExchangeItemAutoCraftStopedMessage initExchangeItemAutoCraftStopedMessage(int param1) {
         this.reason = param1;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.reason = 0;
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
         this.serializeAs_ExchangeItemAutoCraftStopedMessage(param1);
    }

    public void serializeAs_ExchangeItemAutoCraftStopedMessage(ICustomDataOutput param1) {
         param1.writeByte(this.reason);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_ExchangeItemAutoCraftStopedMessage(param1);
    }

    public void deserializeAs_ExchangeItemAutoCraftStopedMessage(ICustomDataInput param1) {
         this._reasonFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_ExchangeItemAutoCraftStopedMessage(param1);
    }

    public void deserializeAsyncAs_ExchangeItemAutoCraftStopedMessage(FuncTree param1) {
         param1.addChild(this._reasonFunc);
    }

    private void _reasonFunc(ICustomDataInput param1) {
         this.reason = param1.readByte();
    }

}