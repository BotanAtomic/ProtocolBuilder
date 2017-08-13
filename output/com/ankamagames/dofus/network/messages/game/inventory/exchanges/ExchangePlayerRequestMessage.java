package com.ankamagames.dofus.network.messages.game.inventory.exchanges;

import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;

public class ExchangePlayerRequestMessage extends ExchangeRequestMessage implements INetworkMessage {

    private int protocolId = 5773;
    private boolean _isInitialized = false;
    private Number target = 0;


    public boolean isInitialized() {
         return super.isInitialized && this._isInitialized;
    }

    public int getMessageId() {
         return 5773;
    }

    public ExchangePlayerRequestMessage initExchangePlayerRequestMessage(int param1,Number  param2) {
         super.initExchangeRequestMessage(param1);
         this.target = param2;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         super.reset();
         this.target = 0;
         this._isInitialized = false;
    }

    public void pack(ICustomDataOutput param1) {
         ByteArray _loc2_ = new ByteArray();
         this.serialize(new CustomDataWrapper(_loc2_));
         if(HASH_FUNCTION != null)
         {
            HASH_FUNCTION(_loc2_);
         }
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
         this.serializeAs_ExchangePlayerRequestMessage(param1);
    }

    public void serializeAs_ExchangePlayerRequestMessage(ICustomDataOutput param1) {
         super.serializeAs_ExchangeRequestMessage(param1);
         if(this.target < 0 || this.target > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.target + ") on element target.");
         }
         param1.writeVarLong(this.target);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_ExchangePlayerRequestMessage(param1);
    }

    public void deserializeAs_ExchangePlayerRequestMessage(ICustomDataInput param1) {
         super.deserialize(param1);
         this._targetFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_ExchangePlayerRequestMessage(param1);
    }

    public void deserializeAsyncAs_ExchangePlayerRequestMessage(FuncTree param1) {
         super.deserializeAsync(param1);
         param1.addChild(this._targetFunc);
    }

    private void _targetFunc(ICustomDataInput param1) {
         this.target = param1.readVarUhLong();
         if(this.target < 0 || this.target > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.target + ") on element of ExchangePlayerRequestMessage.target.");
         }
    }

}