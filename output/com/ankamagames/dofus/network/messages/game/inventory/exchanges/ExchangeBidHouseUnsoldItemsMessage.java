package com.ankamagames.dofus.network.messages.game.inventory.exchanges;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.data.items.ObjectItemGenericQuantity;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class ExchangeBidHouseUnsoldItemsMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6612;
    private boolean _isInitialized = false;
    private Vector<ObjectItemGenericQuantity> items;
    private FuncTree _itemstree;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 6612;
    }

    public ExchangeBidHouseUnsoldItemsMessage initExchangeBidHouseUnsoldItemsMessage(Vector<ObjectItemGenericQuantity> param1) {
         this.items = param1;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.items = new Vector.<ObjectItemGenericQuantity>();
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
         this.serializeAs_ExchangeBidHouseUnsoldItemsMessage(param1);
    }

    public void serializeAs_ExchangeBidHouseUnsoldItemsMessage(ICustomDataOutput param1) {
         param1.writeShort(this.items.length);
         int _loc2_ = 0;
         while(_loc2_ < this.items.length)
         {
            (this.items[_loc2_] as ObjectItemGenericQuantity).serializeAs_ObjectItemGenericQuantity(param1);
            _loc2_++;
         }
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_ExchangeBidHouseUnsoldItemsMessage(param1);
    }

    public void deserializeAs_ExchangeBidHouseUnsoldItemsMessage(ICustomDataInput param1) {
         ObjectItemGenericQuantity _loc4_ = null;
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            _loc4_ = new ObjectItemGenericQuantity();
            _loc4_.deserialize(param1);
            this.items.push(_loc4_);
            _loc3_++;
         }
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_ExchangeBidHouseUnsoldItemsMessage(param1);
    }

    public void deserializeAsyncAs_ExchangeBidHouseUnsoldItemsMessage(FuncTree param1) {
         this._itemstree = param1.addChild(this._itemstreeFunc);
    }

    private void _itemstreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            this._itemstree.addChild(this._itemsFunc);
            _loc3_++;
         }
    }

    private void _itemsFunc(ICustomDataInput param1) {
         ObjectItemGenericQuantity _loc2_ = new ObjectItemGenericQuantity();
         _loc2_.deserialize(param1);
         this.items.push(_loc2_);
    }

}