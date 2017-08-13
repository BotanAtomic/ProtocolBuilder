package package com.ankamagames.dofus.network.messages.game.inventory.exchanges;

import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.data.items.ObjectItem;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class ExchangeObjectAddedMessage extends ExchangeObjectMessage implements INetworkMessage {

    private int protocolId = 5516;
    private boolean _isInitialized = false;
    private ObjectItem object = ;
    private FuncTree _objecttree = ;


    public boolean isInitialized() {
         return super.isInitialized && this._isInitialized;
    }

    public int getMessageId() {
         return 5516;
    }

    public ExchangeObjectAddedMessage initExchangeObjectAddedMessage(boolean param1,ObjectItem  param2) {
         super.initExchangeObjectMessage(param1);
         this.object = param2;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         super.reset();
         this.object = new ObjectItem();
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
         this.serializeAs_ExchangeObjectAddedMessage(param1);
    }

    public void serializeAs_ExchangeObjectAddedMessage(ICustomDataOutput param1) {
         super.serializeAs_ExchangeObjectMessage(param1);
         this.object.serializeAs_ObjectItem(param1);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_ExchangeObjectAddedMessage(param1);
    }

    public void deserializeAs_ExchangeObjectAddedMessage(ICustomDataInput param1) {
         super.deserialize(param1);
         this.object = new ObjectItem();
         this.object.deserialize(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_ExchangeObjectAddedMessage(param1);
    }

    public void deserializeAsyncAs_ExchangeObjectAddedMessage(FuncTree param1) {
         super.deserializeAsync(param1);
         this._objecttree = param1.addChild(this._objecttreeFunc);
    }

    private void _objecttreeFunc(ICustomDataInput param1) {
         this.object = new ObjectItem();
         this.object.deserializeAsync(this._objecttree);
    }

}