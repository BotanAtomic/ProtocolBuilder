package package com.ankamagames.dofus.network.messages.game.inventory.exchanges;

import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.data.items.ObjectItem;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class ExchangeObjectsAddedMessage extends ExchangeObjectMessage implements INetworkMessage {

    private int protocolId = 6535;
    private boolean _isInitialized = false;
    private Vector.<ObjectItem> object = ;
    private FuncTree _objecttree = ;
    private int _loc2_ = 0;
    private int _loc2_ = param1.readUnsignedShort();
    private int _loc3_ = 0;
    private int _loc3_ = 0;


    public boolean isInitialized() {
         return super.isInitialized && this._isInitialized;
    }

    public int getMessageId() {
         return 6535;
    }

    public ExchangeObjectsAddedMessage initExchangeObjectsAddedMessage(boolean param1,Vector.<ObjectItem>  param2) {
         super.initExchangeObjectMessage(param1);
         this.object = param2;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         super.reset();
         this.object = new Vector.<ObjectItem>();
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
         this.serializeAs_ExchangeObjectsAddedMessage(param1);
    }

    public void serializeAs_ExchangeObjectsAddedMessage(ICustomDataOutput param1) {
         super.serializeAs_ExchangeObjectMessage(param1);
         param1.writeShort(this.object.length);
         int _loc2_ = 0;
         while(_loc2_ < this.object.length)
            (this.object[_loc2_] as ObjectItem).serializeAs_ObjectItem(param1);
            _loc2_++;
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_ExchangeObjectsAddedMessage(param1);
    }

    public void deserializeAs_ExchangeObjectsAddedMessage(ICustomDataInput param1) {
         ObjectItem _loc4_ = null;
         super.deserialize(param1);
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
            _loc4_ = new ObjectItem();
            _loc4_.deserialize(param1);
            this.object.push(_loc4_);
            _loc3_++;
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_ExchangeObjectsAddedMessage(param1);
    }

    public void deserializeAsyncAs_ExchangeObjectsAddedMessage(FuncTree param1) {
         super.deserializeAsync(param1);
         this._objecttree = param1.addChild(this._objecttreeFunc);
    }

    private void _objecttreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
            this._objecttree.addChild(this._objectFunc);
            _loc3_++;
    }

    private void _objectFunc(ICustomDataInput param1) {
         ObjectItem _loc2_ = new ObjectItem();
         _loc2_.deserialize(param1);
         this.object.push(_loc2_);
    }

}