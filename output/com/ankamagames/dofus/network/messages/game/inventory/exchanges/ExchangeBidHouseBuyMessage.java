package package com.ankamagames.dofus.network.messages.game.inventory.exchanges;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;

public class ExchangeBidHouseBuyMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 5804;
    private boolean _isInitialized = false;
    private int uid = 0;
    private int qty = 0;
    private Number price = 0;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 5804;
    }

    public ExchangeBidHouseBuyMessage initExchangeBidHouseBuyMessage(int param1,int  param2,Number  param3) {
         this.uid = param1;
         this.qty = param2;
         this.price = param3;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.uid = 0;
         this.qty = 0;
         this.price = 0;
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
         this.serializeAs_ExchangeBidHouseBuyMessage(param1);
    }

    public void serializeAs_ExchangeBidHouseBuyMessage(ICustomDataOutput param1) {
         if(this.uid < 0)
            throw new Exception("Forbidden value (" + this.uid + ") on element uid.");
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_ExchangeBidHouseBuyMessage(param1);
    }

    public void deserializeAs_ExchangeBidHouseBuyMessage(ICustomDataInput param1) {
         this._uidFunc(param1);
         this._qtyFunc(param1);
         this._priceFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_ExchangeBidHouseBuyMessage(param1);
    }

    public void deserializeAsyncAs_ExchangeBidHouseBuyMessage(FuncTree param1) {
         param1.addChild(this._uidFunc);
         param1.addChild(this._qtyFunc);
         param1.addChild(this._priceFunc);
    }

    private void _uidFunc(ICustomDataInput param1) {
         this.uid = param1.readVarUhInt();
         if(this.uid < 0)
            throw new Exception("Forbidden value (" + this.uid + ") on element of ExchangeBidHouseBuyMessage.uid.");
    }

    private void _qtyFunc(ICustomDataInput param1) {
         this.qty = param1.readVarUhInt();
         if(this.qty < 0)
            throw new Exception("Forbidden value (" + this.qty + ") on element of ExchangeBidHouseBuyMessage.qty.");
    }

    private void _priceFunc(ICustomDataInput param1) {
         this.price = param1.readVarUhLong();
         if(this.price < 0 || this.price > 9.007199254740992E15)
            throw new Exception("Forbidden value (" + this.price + ") on element of ExchangeBidHouseBuyMessage.price.");
    }

}