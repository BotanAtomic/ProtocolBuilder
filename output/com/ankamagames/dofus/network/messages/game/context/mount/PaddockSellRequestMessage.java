package com.ankamagames.dofus.network.messages.game.context.mount;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;

public class PaddockSellRequestMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 5953;
    private boolean _isInitialized = false;
    private Number price = 0;
    private boolean forSale = false;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 5953;
    }

    public PaddockSellRequestMessage initPaddockSellRequestMessage(Number param1,boolean  param2) {
         this.price = param1;
         this.forSale = param2;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.price = 0;
         this.forSale = false;
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
         this.serializeAs_PaddockSellRequestMessage(param1);
    }

    public void serializeAs_PaddockSellRequestMessage(ICustomDataOutput param1) {
         if(this.price < 0 || this.price > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.price + ") on element price.");
         }
         param1.writeVarLong(this.price);
         param1.writeBoolean(this.forSale);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_PaddockSellRequestMessage(param1);
    }

    public void deserializeAs_PaddockSellRequestMessage(ICustomDataInput param1) {
         this._priceFunc(param1);
         this._forSaleFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_PaddockSellRequestMessage(param1);
    }

    public void deserializeAsyncAs_PaddockSellRequestMessage(FuncTree param1) {
         param1.addChild(this._priceFunc);
         param1.addChild(this._forSaleFunc);
    }

    private void _priceFunc(ICustomDataInput param1) {
         this.price = param1.readVarUhLong();
         if(this.price < 0 || this.price > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.price + ") on element of PaddockSellRequestMessage.price.");
         }
    }

    private void _forSaleFunc(ICustomDataInput param1) {
         this.forSale = param1.readBoolean();
    }

}