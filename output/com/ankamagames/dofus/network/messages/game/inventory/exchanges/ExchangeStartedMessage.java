package package com.ankamagames.dofus.network.messages.game.inventory.exchanges;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class ExchangeStartedMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 5512;
    private boolean _isInitialized = false;
    private int exchangeType = 0;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 5512;
    }

    public ExchangeStartedMessage initExchangeStartedMessage(int param1) {
         this.exchangeType = param1;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.exchangeType = 0;
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
         this.serializeAs_ExchangeStartedMessage(param1);
    }

    public void serializeAs_ExchangeStartedMessage(ICustomDataOutput param1) {
         param1.writeByte(this.exchangeType);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_ExchangeStartedMessage(param1);
    }

    public void deserializeAs_ExchangeStartedMessage(ICustomDataInput param1) {
         this._exchangeTypeFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_ExchangeStartedMessage(param1);
    }

    public void deserializeAsyncAs_ExchangeStartedMessage(FuncTree param1) {
         param1.addChild(this._exchangeTypeFunc);
    }

    private void _exchangeTypeFunc(ICustomDataInput param1) {
         this.exchangeType = param1.readByte();
    }

}