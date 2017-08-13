package com.ankamagames.dofus.network.messages.game.inventory.exchanges;

import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;

public class ExchangeCraftResultWithObjectIdMessage extends ExchangeCraftResultMessage implements INetworkMessage {

    private int protocolId = 6000;
    private boolean _isInitialized = false;
    private int objectGenericId = 0;


    public boolean isInitialized() {
         return super.isInitialized && this._isInitialized;
    }

    public int getMessageId() {
         return 6000;
    }

    public ExchangeCraftResultWithObjectIdMessage initExchangeCraftResultWithObjectIdMessage(int param1,int  param2) {
         super.initExchangeCraftResultMessage(param1);
         this.objectGenericId = param2;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         super.reset();
         this.objectGenericId = 0;
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
         this.serializeAs_ExchangeCraftResultWithObjectIdMessage(param1);
    }

    public void serializeAs_ExchangeCraftResultWithObjectIdMessage(ICustomDataOutput param1) {
         super.serializeAs_ExchangeCraftResultMessage(param1);
         if(this.objectGenericId < 0)
         {
            throw new Exception("Forbidden value (" + this.objectGenericId + ") on element objectGenericId.");
         }
         param1.writeVarShort(this.objectGenericId);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_ExchangeCraftResultWithObjectIdMessage(param1);
    }

    public void deserializeAs_ExchangeCraftResultWithObjectIdMessage(ICustomDataInput param1) {
         super.deserialize(param1);
         this._objectGenericIdFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_ExchangeCraftResultWithObjectIdMessage(param1);
    }

    public void deserializeAsyncAs_ExchangeCraftResultWithObjectIdMessage(FuncTree param1) {
         super.deserializeAsync(param1);
         param1.addChild(this._objectGenericIdFunc);
    }

    private void _objectGenericIdFunc(ICustomDataInput param1) {
         this.objectGenericId = param1.readVarUhShort();
         if(this.objectGenericId < 0)
         {
            throw new Exception("Forbidden value (" + this.objectGenericId + ") on element of ExchangeCraftResultWithObjectIdMessage.objectGenericId.");
         }
    }

}