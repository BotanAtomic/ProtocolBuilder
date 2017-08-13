package package com.ankamagames.dofus.network.messages.game.inventory.exchanges;

import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;

public class ExchangePlayerMultiCraftRequestMessage extends ExchangeRequestMessage implements INetworkMessage {

    private int protocolId = 5784;
    private boolean _isInitialized = false;
    private Number target = 0;
    private int skillId = 0;


    public boolean isInitialized() {
         return super.isInitialized && this._isInitialized;
    }

    public int getMessageId() {
         return 5784;
    }

    public ExchangePlayerMultiCraftRequestMessage initExchangePlayerMultiCraftRequestMessage(int param1,Number  param2,int  param3) {
         super.initExchangeRequestMessage(param1);
         this.target = param2;
         this.skillId = param3;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         super.reset();
         this.target = 0;
         this.skillId = 0;
         this._isInitialized = false;
    }

    public void pack(ICustomDataOutput param1) {
         ByteArray _loc2_ = new ByteArray();
         this.serialize(new CustomDataWrapper(_loc2_));
         if(HASH_FUNCTION != null)
            HASH_FUNCTION(_loc2_);
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
         this.serializeAs_ExchangePlayerMultiCraftRequestMessage(param1);
    }

    public void serializeAs_ExchangePlayerMultiCraftRequestMessage(ICustomDataOutput param1) {
         super.serializeAs_ExchangeRequestMessage(param1);
         if(this.target < 0 || this.target > 9.007199254740992E15)
            throw new Exception("Forbidden value (" + this.target + ") on element target.");
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_ExchangePlayerMultiCraftRequestMessage(param1);
    }

    public void deserializeAs_ExchangePlayerMultiCraftRequestMessage(ICustomDataInput param1) {
         super.deserialize(param1);
         this._targetFunc(param1);
         this._skillIdFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_ExchangePlayerMultiCraftRequestMessage(param1);
    }

    public void deserializeAsyncAs_ExchangePlayerMultiCraftRequestMessage(FuncTree param1) {
         super.deserializeAsync(param1);
         param1.addChild(this._targetFunc);
         param1.addChild(this._skillIdFunc);
    }

    private void _targetFunc(ICustomDataInput param1) {
         this.target = param1.readVarUhLong();
         if(this.target < 0 || this.target > 9.007199254740992E15)
            throw new Exception("Forbidden value (" + this.target + ") on element of ExchangePlayerMultiCraftRequestMessage.target.");
    }

    private void _skillIdFunc(ICustomDataInput param1) {
         this.skillId = param1.readVarUhInt();
         if(this.skillId < 0)
            throw new Exception("Forbidden value (" + this.skillId + ") on element of ExchangePlayerMultiCraftRequestMessage.skillId.");
    }

}