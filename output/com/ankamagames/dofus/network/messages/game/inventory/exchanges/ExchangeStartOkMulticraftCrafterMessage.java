package com.ankamagames.dofus.network.messages.game.inventory.exchanges;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;

public class ExchangeStartOkMulticraftCrafterMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 5818;
    private boolean _isInitialized = false;
    private int skillId = 0;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 5818;
    }

    public ExchangeStartOkMulticraftCrafterMessage initExchangeStartOkMulticraftCrafterMessage(int param1) {
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
         this.serializeAs_ExchangeStartOkMulticraftCrafterMessage(param1);
    }

    public void serializeAs_ExchangeStartOkMulticraftCrafterMessage(ICustomDataOutput param1) {
         if(this.skillId < 0)
         {
            throw new Exception("Forbidden value (" + this.skillId + ") on element skillId.");
         }
         param1.writeVarInt(this.skillId);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_ExchangeStartOkMulticraftCrafterMessage(param1);
    }

    public void deserializeAs_ExchangeStartOkMulticraftCrafterMessage(ICustomDataInput param1) {
         this._skillIdFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_ExchangeStartOkMulticraftCrafterMessage(param1);
    }

    public void deserializeAsyncAs_ExchangeStartOkMulticraftCrafterMessage(FuncTree param1) {
         param1.addChild(this._skillIdFunc);
    }

    private void _skillIdFunc(ICustomDataInput param1) {
         this.skillId = param1.readVarUhInt();
         if(this.skillId < 0)
         {
            throw new Exception("Forbidden value (" + this.skillId + ") on element of ExchangeStartOkMulticraftCrafterMessage.skillId.");
         }
    }

}