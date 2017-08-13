package package com.ankamagames.dofus.network.messages.game.inventory.exchanges;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;

public class ExchangeStartOkNpcTradeMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 5785;
    private boolean _isInitialized = false;
    private Number npcId = 0;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 5785;
    }

    public ExchangeStartOkNpcTradeMessage initExchangeStartOkNpcTradeMessage(Number param1) {
         this.npcId = param1;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.npcId = 0;
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
         this.serializeAs_ExchangeStartOkNpcTradeMessage(param1);
    }

    public void serializeAs_ExchangeStartOkNpcTradeMessage(ICustomDataOutput param1) {
         if(this.npcId < -9.007199254740992E15 || this.npcId > 9.007199254740992E15)
            throw new Exception("Forbidden value (" + this.npcId + ") on element npcId.");
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_ExchangeStartOkNpcTradeMessage(param1);
    }

    public void deserializeAs_ExchangeStartOkNpcTradeMessage(ICustomDataInput param1) {
         this._npcIdFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_ExchangeStartOkNpcTradeMessage(param1);
    }

    public void deserializeAsyncAs_ExchangeStartOkNpcTradeMessage(FuncTree param1) {
         param1.addChild(this._npcIdFunc);
    }

    private void _npcIdFunc(ICustomDataInput param1) {
         this.npcId = param1.readDouble();
         if(this.npcId < -9.007199254740992E15 || this.npcId > 9.007199254740992E15)
            throw new Exception("Forbidden value (" + this.npcId + ") on element of ExchangeStartOkNpcTradeMessage.npcId.");
    }

}