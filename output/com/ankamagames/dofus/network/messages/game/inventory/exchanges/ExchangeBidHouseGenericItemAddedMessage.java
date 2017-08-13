package com.ankamagames.dofus.network.messages.game.inventory.exchanges;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;

public class ExchangeBidHouseGenericItemAddedMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 5947;
    private boolean _isInitialized = false;
    private int objGenericId = 0;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 5947;
    }

    public ExchangeBidHouseGenericItemAddedMessage initExchangeBidHouseGenericItemAddedMessage(int param1) {
         this.objGenericId = param1;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.objGenericId = 0;
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
         this.serializeAs_ExchangeBidHouseGenericItemAddedMessage(param1);
    }

    public void serializeAs_ExchangeBidHouseGenericItemAddedMessage(ICustomDataOutput param1) {
         if(this.objGenericId < 0)
         {
            throw new Exception("Forbidden value (" + this.objGenericId + ") on element objGenericId.");
         }
         param1.writeVarShort(this.objGenericId);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_ExchangeBidHouseGenericItemAddedMessage(param1);
    }

    public void deserializeAs_ExchangeBidHouseGenericItemAddedMessage(ICustomDataInput param1) {
         this._objGenericIdFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_ExchangeBidHouseGenericItemAddedMessage(param1);
    }

    public void deserializeAsyncAs_ExchangeBidHouseGenericItemAddedMessage(FuncTree param1) {
         param1.addChild(this._objGenericIdFunc);
    }

    private void _objGenericIdFunc(ICustomDataInput param1) {
         this.objGenericId = param1.readVarUhShort();
         if(this.objGenericId < 0)
         {
            throw new Exception("Forbidden value (" + this.objGenericId + ") on element of ExchangeBidHouseGenericItemAddedMessage.objGenericId.");
         }
    }

}