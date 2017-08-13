package com.ankamagames.dofus.network.messages.game.inventory.exchanges;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.data.items.ObjectItemGenericQuantityPrice;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class ExchangeOfflineSoldItemsMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6613;
    private boolean _isInitialized = false;
    private Vector<ObjectItemGenericQuantityPrice> bidHouseItems;
    private Vector<ObjectItemGenericQuantityPrice> merchantItems;
    private FuncTree _bidHouseItemstree;
    private FuncTree _merchantItemstree;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 6613;
    }

    public ExchangeOfflineSoldItemsMessage initExchangeOfflineSoldItemsMessage(Vector<ObjectItemGenericQuantityPrice> param1,Vector<ObjectItemGenericQuantityPrice>  param2) {
         this.bidHouseItems = param1;
         this.merchantItems = param2;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.bidHouseItems = new Vector.<ObjectItemGenericQuantityPrice>();
         this.merchantItems = new Vector.<ObjectItemGenericQuantityPrice>();
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
         this.serializeAs_ExchangeOfflineSoldItemsMessage(param1);
    }

    public void serializeAs_ExchangeOfflineSoldItemsMessage(ICustomDataOutput param1) {
         param1.writeShort(this.bidHouseItems.length);
         int _loc2_ = 0;
         while(_loc2_ < this.bidHouseItems.length)
         {
            (this.bidHouseItems[_loc2_] as ObjectItemGenericQuantityPrice).serializeAs_ObjectItemGenericQuantityPrice(param1);
            _loc2_++;
         }
         param1.writeShort(this.merchantItems.length);
         int _loc3_ = 0;
         while(_loc3_ < this.merchantItems.length)
         {
            (this.merchantItems[_loc3_] as ObjectItemGenericQuantityPrice).serializeAs_ObjectItemGenericQuantityPrice(param1);
            _loc3_++;
         }
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_ExchangeOfflineSoldItemsMessage(param1);
    }

    public void deserializeAs_ExchangeOfflineSoldItemsMessage(ICustomDataInput param1) {
         ObjectItemGenericQuantityPrice _loc6_ = null;
         ObjectItemGenericQuantityPrice _loc7_ = null;
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            _loc6_ = new ObjectItemGenericQuantityPrice();
            _loc6_.deserialize(param1);
            this.bidHouseItems.push(_loc6_);
            _loc3_++;
         }
         int _loc4_ = param1.readUnsignedShort();
         int _loc5_ = 0;
         while(_loc5_ < _loc4_)
         {
            _loc7_ = new ObjectItemGenericQuantityPrice();
            _loc7_.deserialize(param1);
            this.merchantItems.push(_loc7_);
            _loc5_++;
         }
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_ExchangeOfflineSoldItemsMessage(param1);
    }

    public void deserializeAsyncAs_ExchangeOfflineSoldItemsMessage(FuncTree param1) {
         this._bidHouseItemstree = param1.addChild(this._bidHouseItemstreeFunc);
         this._merchantItemstree = param1.addChild(this._merchantItemstreeFunc);
    }

    private void _bidHouseItemstreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            this._bidHouseItemstree.addChild(this._bidHouseItemsFunc);
            _loc3_++;
         }
    }

    private void _bidHouseItemsFunc(ICustomDataInput param1) {
         ObjectItemGenericQuantityPrice _loc2_ = new ObjectItemGenericQuantityPrice();
         _loc2_.deserialize(param1);
         this.bidHouseItems.push(_loc2_);
    }

    private void _merchantItemstreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            this._merchantItemstree.addChild(this._merchantItemsFunc);
            _loc3_++;
         }
    }

    private void _merchantItemsFunc(ICustomDataInput param1) {
         ObjectItemGenericQuantityPrice _loc2_ = new ObjectItemGenericQuantityPrice();
         _loc2_.deserialize(param1);
         this.merchantItems.push(_loc2_);
    }

}