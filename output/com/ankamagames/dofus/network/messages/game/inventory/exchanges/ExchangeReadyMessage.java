package package com.ankamagames.dofus.network.messages.game.inventory.exchanges;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;

public class ExchangeReadyMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 5511;
    private boolean _isInitialized = false;
    private boolean ready = false;
    private int step = 0;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 5511;
    }

    public ExchangeReadyMessage initExchangeReadyMessage(boolean param1,int  param2) {
         this.ready = param1;
         this.step = param2;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.ready = false;
         this.step = 0;
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
         this.serializeAs_ExchangeReadyMessage(param1);
    }

    public void serializeAs_ExchangeReadyMessage(ICustomDataOutput param1) {
         param1.writeBoolean(this.ready);
         if(this.step < 0)
            throw new Exception("Forbidden value (" + this.step + ") on element step.");
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_ExchangeReadyMessage(param1);
    }

    public void deserializeAs_ExchangeReadyMessage(ICustomDataInput param1) {
         this._readyFunc(param1);
         this._stepFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_ExchangeReadyMessage(param1);
    }

    public void deserializeAsyncAs_ExchangeReadyMessage(FuncTree param1) {
         param1.addChild(this._readyFunc);
         param1.addChild(this._stepFunc);
    }

    private void _readyFunc(ICustomDataInput param1) {
         this.ready = param1.readBoolean();
    }

    private void _stepFunc(ICustomDataInput param1) {
         this.step = param1.readVarUhShort();
         if(this.step < 0)
            throw new Exception("Forbidden value (" + this.step + ") on element of ExchangeReadyMessage.step.");
    }

}