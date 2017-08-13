package com.ankamagames.dofus.network.messages.game.inventory.exchanges;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;

public class ExchangeCraftPaymentModifiedMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6578;
    private boolean _isInitialized = false;
    private Number goldSum = 0;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 6578;
    }

    public ExchangeCraftPaymentModifiedMessage initExchangeCraftPaymentModifiedMessage(Number param1) {
         this.goldSum = param1;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.goldSum = 0;
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
         this.serializeAs_ExchangeCraftPaymentModifiedMessage(param1);
    }

    public void serializeAs_ExchangeCraftPaymentModifiedMessage(ICustomDataOutput param1) {
         if(this.goldSum < 0 || this.goldSum > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.goldSum + ") on element goldSum.");
         }
         param1.writeVarLong(this.goldSum);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_ExchangeCraftPaymentModifiedMessage(param1);
    }

    public void deserializeAs_ExchangeCraftPaymentModifiedMessage(ICustomDataInput param1) {
         this._goldSumFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_ExchangeCraftPaymentModifiedMessage(param1);
    }

    public void deserializeAsyncAs_ExchangeCraftPaymentModifiedMessage(FuncTree param1) {
         param1.addChild(this._goldSumFunc);
    }

    private void _goldSumFunc(ICustomDataInput param1) {
         this.goldSum = param1.readVarUhLong();
         if(this.goldSum < 0 || this.goldSum > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.goldSum + ") on element of ExchangeCraftPaymentModifiedMessage.goldSum.");
         }
    }

}