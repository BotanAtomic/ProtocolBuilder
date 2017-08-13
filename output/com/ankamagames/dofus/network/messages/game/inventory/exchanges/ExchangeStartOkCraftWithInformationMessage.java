package com.ankamagames.dofus.network.messages.game.inventory.exchanges;

import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;

public class ExchangeStartOkCraftWithInformationMessage extends ExchangeStartOkCraftMessage implements INetworkMessage {

    private int protocolId = 5941;
    private boolean _isInitialized = false;
    private int skillId = 0;


    public boolean isInitialized() {
         return super.isInitialized && this._isInitialized;
    }

    public int getMessageId() {
         return 5941;
    }

    public ExchangeStartOkCraftWithInformationMessage initExchangeStartOkCraftWithInformationMessage(int param1) {
         this.skillId = param1;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.skillId = 0;
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
         this.serializeAs_ExchangeStartOkCraftWithInformationMessage(param1);
    }

    public void serializeAs_ExchangeStartOkCraftWithInformationMessage(ICustomDataOutput param1) {
         super.serializeAs_ExchangeStartOkCraftMessage(param1);
         if(this.skillId < 0)
         {
            throw new Exception("Forbidden value (" + this.skillId + ") on element skillId.");
         }
         param1.writeVarInt(this.skillId);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_ExchangeStartOkCraftWithInformationMessage(param1);
    }

    public void deserializeAs_ExchangeStartOkCraftWithInformationMessage(ICustomDataInput param1) {
         super.deserialize(param1);
         this._skillIdFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_ExchangeStartOkCraftWithInformationMessage(param1);
    }

    public void deserializeAsyncAs_ExchangeStartOkCraftWithInformationMessage(FuncTree param1) {
         super.deserializeAsync(param1);
         param1.addChild(this._skillIdFunc);
    }

    private void _skillIdFunc(ICustomDataInput param1) {
         this.skillId = param1.readVarUhInt();
         if(this.skillId < 0)
         {
            throw new Exception("Forbidden value (" + this.skillId + ") on element of ExchangeStartOkCraftWithInformationMessage.skillId.");
         }
    }

}