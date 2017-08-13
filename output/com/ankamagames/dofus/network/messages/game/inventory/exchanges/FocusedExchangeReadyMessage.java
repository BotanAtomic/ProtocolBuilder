package com.ankamagames.dofus.network.messages.game.inventory.exchanges;

import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;

public class FocusedExchangeReadyMessage extends ExchangeReadyMessage implements INetworkMessage {

    private int protocolId = 6701;
    private boolean _isInitialized = false;
    private int focusActionId = 0;


    public boolean isInitialized() {
         return super.isInitialized && this._isInitialized;
    }

    public int getMessageId() {
         return 6701;
    }

    public FocusedExchangeReadyMessage initFocusedExchangeReadyMessage(boolean param1,int  param2,int  param3) {
         super.initExchangeReadyMessage(param1,param2);
         this.focusActionId = param3;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         super.reset();
         this.focusActionId = 0;
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
         this.serializeAs_FocusedExchangeReadyMessage(param1);
    }

    public void serializeAs_FocusedExchangeReadyMessage(ICustomDataOutput param1) {
         super.serializeAs_ExchangeReadyMessage(param1);
         if(this.focusActionId < 0)
         {
            throw new Exception("Forbidden value (" + this.focusActionId + ") on element focusActionId.");
         }
         param1.writeVarInt(this.focusActionId);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_FocusedExchangeReadyMessage(param1);
    }

    public void deserializeAs_FocusedExchangeReadyMessage(ICustomDataInput param1) {
         super.deserialize(param1);
         this._focusActionIdFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_FocusedExchangeReadyMessage(param1);
    }

    public void deserializeAsyncAs_FocusedExchangeReadyMessage(FuncTree param1) {
         super.deserializeAsync(param1);
         param1.addChild(this._focusActionIdFunc);
    }

    private void _focusActionIdFunc(ICustomDataInput param1) {
         this.focusActionId = param1.readVarUhInt();
         if(this.focusActionId < 0)
         {
            throw new Exception("Forbidden value (" + this.focusActionId + ") on element of FocusedExchangeReadyMessage.focusActionId.");
         }
    }

}