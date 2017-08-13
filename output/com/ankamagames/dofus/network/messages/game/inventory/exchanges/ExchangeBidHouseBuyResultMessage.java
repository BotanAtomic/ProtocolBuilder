package package com.ankamagames.dofus.network.messages.game.inventory.exchanges;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;

public class ExchangeBidHouseBuyResultMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6272;
    private boolean _isInitialized = false;
    private int uid = 0;
    private boolean bought = false;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 6272;
    }

    public ExchangeBidHouseBuyResultMessage initExchangeBidHouseBuyResultMessage(int param1,boolean  param2) {
         this.uid = param1;
         this.bought = param2;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.uid = 0;
         this.bought = false;
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
         this.serializeAs_ExchangeBidHouseBuyResultMessage(param1);
    }

    public void serializeAs_ExchangeBidHouseBuyResultMessage(ICustomDataOutput param1) {
         if(this.uid < 0)
            throw new Exception("Forbidden value (" + this.uid + ") on element uid.");
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_ExchangeBidHouseBuyResultMessage(param1);
    }

    public void deserializeAs_ExchangeBidHouseBuyResultMessage(ICustomDataInput param1) {
         this._uidFunc(param1);
         this._boughtFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_ExchangeBidHouseBuyResultMessage(param1);
    }

    public void deserializeAsyncAs_ExchangeBidHouseBuyResultMessage(FuncTree param1) {
         param1.addChild(this._uidFunc);
         param1.addChild(this._boughtFunc);
    }

    private void _uidFunc(ICustomDataInput param1) {
         this.uid = param1.readVarUhInt();
         if(this.uid < 0)
            throw new Exception("Forbidden value (" + this.uid + ") on element of ExchangeBidHouseBuyResultMessage.uid.");
    }

    private void _boughtFunc(ICustomDataInput param1) {
         this.bought = param1.readBoolean();
    }

}