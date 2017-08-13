package com.ankamagames.dofus.network.messages.game.inventory.exchanges;

import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;

public class ExchangeStartedWithStorageMessage extends ExchangeStartedMessage implements INetworkMessage {

    private int protocolId = 6236;
    private boolean _isInitialized = false;
    private int storageMaxSlot = 0;


    public boolean isInitialized() {
         return super.isInitialized && this._isInitialized;
    }

    public int getMessageId() {
         return 6236;
    }

    public ExchangeStartedWithStorageMessage initExchangeStartedWithStorageMessage(int param1,int  param2) {
         super.initExchangeStartedMessage(param1);
         this.storageMaxSlot = param2;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         super.reset();
         this.storageMaxSlot = 0;
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
         this.serializeAs_ExchangeStartedWithStorageMessage(param1);
    }

    public void serializeAs_ExchangeStartedWithStorageMessage(ICustomDataOutput param1) {
         super.serializeAs_ExchangeStartedMessage(param1);
         if(this.storageMaxSlot < 0)
         {
            throw new Exception("Forbidden value (" + this.storageMaxSlot + ") on element storageMaxSlot.");
         }
         param1.writeVarInt(this.storageMaxSlot);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_ExchangeStartedWithStorageMessage(param1);
    }

    public void deserializeAs_ExchangeStartedWithStorageMessage(ICustomDataInput param1) {
         super.deserialize(param1);
         this._storageMaxSlotFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_ExchangeStartedWithStorageMessage(param1);
    }

    public void deserializeAsyncAs_ExchangeStartedWithStorageMessage(FuncTree param1) {
         super.deserializeAsync(param1);
         param1.addChild(this._storageMaxSlotFunc);
    }

    private void _storageMaxSlotFunc(ICustomDataInput param1) {
         this.storageMaxSlot = param1.readVarUhInt();
         if(this.storageMaxSlot < 0)
         {
            throw new Exception("Forbidden value (" + this.storageMaxSlot + ") on element of ExchangeStartedWithStorageMessage.storageMaxSlot.");
         }
    }

}