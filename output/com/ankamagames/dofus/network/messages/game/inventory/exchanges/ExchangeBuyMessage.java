package com.ankamagames.dofus.network.messages.game.inventory.exchanges;

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

public class ExchangeBuyMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 5774;
    private boolean _isInitialized = false;
    private int objectToBuyId = 0;
    private int quantity = 0;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 5774;
    }

    public ExchangeBuyMessage initExchangeBuyMessage(int param1,int  param2) {
         this.objectToBuyId = param1;
         this.quantity = param2;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.objectToBuyId = 0;
         this.quantity = 0;
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
         this.serializeAs_ExchangeBuyMessage(param1);
    }

    public void serializeAs_ExchangeBuyMessage(ICustomDataOutput param1) {
         if(this.objectToBuyId < 0)
         {
            throw new Exception("Forbidden value (" + this.objectToBuyId + ") on element objectToBuyId.");
         }
         param1.writeVarInt(this.objectToBuyId);
         if(this.quantity < 0)
         {
            throw new Exception("Forbidden value (" + this.quantity + ") on element quantity.");
         }
         param1.writeVarInt(this.quantity);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_ExchangeBuyMessage(param1);
    }

    public void deserializeAs_ExchangeBuyMessage(ICustomDataInput param1) {
         this._objectToBuyIdFunc(param1);
         this._quantityFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_ExchangeBuyMessage(param1);
    }

    public void deserializeAsyncAs_ExchangeBuyMessage(FuncTree param1) {
         param1.addChild(this._objectToBuyIdFunc);
         param1.addChild(this._quantityFunc);
    }

    private void _objectToBuyIdFunc(ICustomDataInput param1) {
         this.objectToBuyId = param1.readVarUhInt();
         if(this.objectToBuyId < 0)
         {
            throw new Exception("Forbidden value (" + this.objectToBuyId + ") on element of ExchangeBuyMessage.objectToBuyId.");
         }
    }

    private void _quantityFunc(ICustomDataInput param1) {
         this.quantity = param1.readVarUhInt();
         if(this.quantity < 0)
         {
            throw new Exception("Forbidden value (" + this.quantity + ") on element of ExchangeBuyMessage.quantity.");
         }
    }

}