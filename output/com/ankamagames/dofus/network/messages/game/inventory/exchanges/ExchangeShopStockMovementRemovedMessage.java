package package com.ankamagames.dofus.network.messages.game.inventory.exchanges;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;

public class ExchangeShopStockMovementRemovedMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 5907;
    private boolean _isInitialized = false;
    private int objectId = 0;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 5907;
    }

    public ExchangeShopStockMovementRemovedMessage initExchangeShopStockMovementRemovedMessage(int param1) {
         this.objectId = param1;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.objectId = 0;
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
         this.serializeAs_ExchangeShopStockMovementRemovedMessage(param1);
    }

    public void serializeAs_ExchangeShopStockMovementRemovedMessage(ICustomDataOutput param1) {
         if(this.objectId < 0)
            throw new Exception("Forbidden value (" + this.objectId + ") on element objectId.");
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_ExchangeShopStockMovementRemovedMessage(param1);
    }

    public void deserializeAs_ExchangeShopStockMovementRemovedMessage(ICustomDataInput param1) {
         this._objectIdFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_ExchangeShopStockMovementRemovedMessage(param1);
    }

    public void deserializeAsyncAs_ExchangeShopStockMovementRemovedMessage(FuncTree param1) {
         param1.addChild(this._objectIdFunc);
    }

    private void _objectIdFunc(ICustomDataInput param1) {
         this.objectId = param1.readVarUhInt();
         if(this.objectId < 0)
            throw new Exception("Forbidden value (" + this.objectId + ") on element of ExchangeShopStockMovementRemovedMessage.objectId.");
    }

}