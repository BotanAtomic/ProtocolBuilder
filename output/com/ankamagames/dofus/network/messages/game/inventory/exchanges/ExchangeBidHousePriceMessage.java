package com.ankamagames.dofus.network.messages.game.inventory.exchanges;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;

public class ExchangeBidHousePriceMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 5805;
    private boolean _isInitialized = false;
    private int genId = 0;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 5805;
    }

    public ExchangeBidHousePriceMessage initExchangeBidHousePriceMessage(int param1) {
         this.genId = param1;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.genId = 0;
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
         this.serializeAs_ExchangeBidHousePriceMessage(param1);
    }

    public void serializeAs_ExchangeBidHousePriceMessage(ICustomDataOutput param1) {
         if(this.genId < 0)
         {
            throw new Exception("Forbidden value (" + this.genId + ") on element genId.");
         }
         param1.writeVarShort(this.genId);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_ExchangeBidHousePriceMessage(param1);
    }

    public void deserializeAs_ExchangeBidHousePriceMessage(ICustomDataInput param1) {
         this._genIdFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_ExchangeBidHousePriceMessage(param1);
    }

    public void deserializeAsyncAs_ExchangeBidHousePriceMessage(FuncTree param1) {
         param1.addChild(this._genIdFunc);
    }

    private void _genIdFunc(ICustomDataInput param1) {
         this.genId = param1.readVarUhShort();
         if(this.genId < 0)
         {
            throw new Exception("Forbidden value (" + this.genId + ") on element of ExchangeBidHousePriceMessage.genId.");
         }
    }

}