package com.ankamagames.dofus.network.messages.game.inventory.exchanges;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.data.items.ObjectItemToSell;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class ExchangeShopStockMovementUpdatedMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 5909;
    private boolean _isInitialized = false;
    private ObjectItemToSell objectInfo;
    private FuncTree _objectInfotree;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 5909;
    }

    public ExchangeShopStockMovementUpdatedMessage initExchangeShopStockMovementUpdatedMessage(ObjectItemToSell param1) {
         this.objectInfo = param1;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.objectInfo = new ObjectItemToSell();
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
         this.serializeAs_ExchangeShopStockMovementUpdatedMessage(param1);
    }

    public void serializeAs_ExchangeShopStockMovementUpdatedMessage(ICustomDataOutput param1) {
         this.objectInfo.serializeAs_ObjectItemToSell(param1);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_ExchangeShopStockMovementUpdatedMessage(param1);
    }

    public void deserializeAs_ExchangeShopStockMovementUpdatedMessage(ICustomDataInput param1) {
         this.objectInfo = new ObjectItemToSell();
         this.objectInfo.deserialize(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_ExchangeShopStockMovementUpdatedMessage(param1);
    }

    public void deserializeAsyncAs_ExchangeShopStockMovementUpdatedMessage(FuncTree param1) {
         this._objectInfotree = param1.addChild(this._objectInfotreeFunc);
    }

    private void _objectInfotreeFunc(ICustomDataInput param1) {
         this.objectInfo = new ObjectItemToSell();
         this.objectInfo.deserializeAsync(this._objectInfotree);
    }

}