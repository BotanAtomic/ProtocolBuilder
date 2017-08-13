package package com.ankamagames.dofus.network.messages.game.inventory.exchanges;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;

public class ExchangeIsReadyMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 5509;
    private boolean _isInitialized = false;
    private Number id = 0;
    private boolean ready = false;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 5509;
    }

    public ExchangeIsReadyMessage initExchangeIsReadyMessage(Number param1,boolean  param2) {
         this.id = param1;
         this.ready = param2;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.id = 0;
         this.ready = false;
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
         this.serializeAs_ExchangeIsReadyMessage(param1);
    }

    public void serializeAs_ExchangeIsReadyMessage(ICustomDataOutput param1) {
         if(this.id < -9.007199254740992E15 || this.id > 9.007199254740992E15)
            throw new Exception("Forbidden value (" + this.id + ") on element id.");
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_ExchangeIsReadyMessage(param1);
    }

    public void deserializeAs_ExchangeIsReadyMessage(ICustomDataInput param1) {
         this._idFunc(param1);
         this._readyFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_ExchangeIsReadyMessage(param1);
    }

    public void deserializeAsyncAs_ExchangeIsReadyMessage(FuncTree param1) {
         param1.addChild(this._idFunc);
         param1.addChild(this._readyFunc);
    }

    private void _idFunc(ICustomDataInput param1) {
         this.id = param1.readDouble();
         if(this.id < -9.007199254740992E15 || this.id > 9.007199254740992E15)
            throw new Exception("Forbidden value (" + this.id + ") on element of ExchangeIsReadyMessage.id.");
    }

    private void _readyFunc(ICustomDataInput param1) {
         this.ready = param1.readBoolean();
    }

}