package package com.ankamagames.dofus.network.messages.game.inventory.exchanges;

import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.data.items.ObjectItemNotInContainer;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class ExchangeCraftResultWithObjectDescMessage extends ExchangeCraftResultMessage implements INetworkMessage {

    private int protocolId = 5999;
    private boolean _isInitialized = false;
    private ObjectItemNotInContainer objectInfo = ;
    private FuncTree _objectInfotree = ;


    public boolean isInitialized() {
         return super.isInitialized && this._isInitialized;
    }

    public int getMessageId() {
         return 5999;
    }

    public ExchangeCraftResultWithObjectDescMessage initExchangeCraftResultWithObjectDescMessage(int param1,ObjectItemNotInContainer  param2) {
         super.initExchangeCraftResultMessage(param1);
         this.objectInfo = param2;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         super.reset();
         this.objectInfo = new ObjectItemNotInContainer();
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
         this.serializeAs_ExchangeCraftResultWithObjectDescMessage(param1);
    }

    public void serializeAs_ExchangeCraftResultWithObjectDescMessage(ICustomDataOutput param1) {
         super.serializeAs_ExchangeCraftResultMessage(param1);
         this.objectInfo.serializeAs_ObjectItemNotInContainer(param1);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_ExchangeCraftResultWithObjectDescMessage(param1);
    }

    public void deserializeAs_ExchangeCraftResultWithObjectDescMessage(ICustomDataInput param1) {
         super.deserialize(param1);
         this.objectInfo = new ObjectItemNotInContainer();
         this.objectInfo.deserialize(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_ExchangeCraftResultWithObjectDescMessage(param1);
    }

    public void deserializeAsyncAs_ExchangeCraftResultWithObjectDescMessage(FuncTree param1) {
         super.deserializeAsync(param1);
         this._objectInfotree = param1.addChild(this._objectInfotreeFunc);
    }

    private void _objectInfotreeFunc(ICustomDataInput param1) {
         this.objectInfo = new ObjectItemNotInContainer();
         this.objectInfo.deserializeAsync(this._objectInfotree);
    }

}