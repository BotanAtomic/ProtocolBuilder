package com.ankamagames.dofus.network.messages.game.inventory.items;

import com.ankamagames.dofus.network.messages.game.inventory.exchanges.ExchangeObjectMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.data.items.ObjectItem;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class ExchangeObjectsModifiedMessage extends ExchangeObjectMessage implements INetworkMessage {

    private int protocolId = 6533;
    private boolean _isInitialized = false;
    private Vector<ObjectItem> object;
    private FuncTree _objecttree;


    public boolean isInitialized() {
         return super.isInitialized && this._isInitialized;
    }

    public int getMessageId() {
         return 6533;
    }

    public ExchangeObjectsModifiedMessage initExchangeObjectsModifiedMessage(boolean param1,Vector<ObjectItem>  param2) {
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
         this.serializeAs_ExchangeObjectsModifiedMessage(param1);
    }

    public void serializeAs_ExchangeObjectsModifiedMessage(ICustomDataOutput param1) {
         super.serializeAs_ExchangeObjectMessage(param1);
         param1.writeShort(this.object.length);
         int _loc2_ = 0;
         while(_loc2_ < this.object.length)
         {
            (this.object[_loc2_] as ObjectItem).serializeAs_ObjectItem(param1);
            _loc2_++;
         }
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_ExchangeObjectsModifiedMessage(param1);
    }

    public void deserializeAs_ExchangeObjectsModifiedMessage(ICustomDataInput param1) {
         ObjectItem _loc4_ = null;
         super.deserialize(param1);
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            _loc4_ = new ObjectItem();
            _loc4_.deserialize(param1);
            this.object.push(_loc4_);
            _loc3_++;
         }
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_ExchangeObjectsModifiedMessage(param1);
    }

    public void deserializeAsyncAs_ExchangeObjectsModifiedMessage(FuncTree param1) {
         super.deserializeAsync(param1);
         this._objecttree = param1.addChild(this._objecttreeFunc);
    }

    private void _objecttreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            this._objecttree.addChild(this._objectFunc);
            _loc3_++;
         }
    }

    private void _objectFunc(ICustomDataInput param1) {
         ObjectItem _loc2_ = new ObjectItem();
         _loc2_.deserialize(param1);
         this.object.push(_loc2_);
    }

}