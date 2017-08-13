package com.ankamagames.dofus.network.messages.game.inventory.exchanges;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.data.items.BidExchangerObjectInfo;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class ExchangeTypesItemsExchangerDescriptionForUserMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 5752;
    private boolean _isInitialized = false;
    private Vector<BidExchangerObjectInfo> itemTypeDescriptions;
    private FuncTree _itemTypeDescriptionstree;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 5752;
    }

    public ExchangeTypesItemsExchangerDescriptionForUserMessage initExchangeTypesItemsExchangerDescriptionForUserMessage(Vector<BidExchangerObjectInfo> param1) {
         this.itemTypeDescriptions = param1;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.itemTypeDescriptions = new Vector.<BidExchangerObjectInfo>();
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
         this.serializeAs_ExchangeTypesItemsExchangerDescriptionForUserMessage(param1);
    }

    public void serializeAs_ExchangeTypesItemsExchangerDescriptionForUserMessage(ICustomDataOutput param1) {
         param1.writeShort(this.itemTypeDescriptions.length);
         int _loc2_ = 0;
         while(_loc2_ < this.itemTypeDescriptions.length)
         {
            (this.itemTypeDescriptions[_loc2_] as BidExchangerObjectInfo).serializeAs_BidExchangerObjectInfo(param1);
            _loc2_++;
         }
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_ExchangeTypesItemsExchangerDescriptionForUserMessage(param1);
    }

    public void deserializeAs_ExchangeTypesItemsExchangerDescriptionForUserMessage(ICustomDataInput param1) {
         BidExchangerObjectInfo _loc4_ = null;
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            _loc4_ = new BidExchangerObjectInfo();
            _loc4_.deserialize(param1);
            this.itemTypeDescriptions.push(_loc4_);
            _loc3_++;
         }
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_ExchangeTypesItemsExchangerDescriptionForUserMessage(param1);
    }

    public void deserializeAsyncAs_ExchangeTypesItemsExchangerDescriptionForUserMessage(FuncTree param1) {
         this._itemTypeDescriptionstree = param1.addChild(this._itemTypeDescriptionstreeFunc);
    }

    private void _itemTypeDescriptionstreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            this._itemTypeDescriptionstree.addChild(this._itemTypeDescriptionsFunc);
            _loc3_++;
         }
    }

    private void _itemTypeDescriptionsFunc(ICustomDataInput param1) {
         BidExchangerObjectInfo _loc2_ = new BidExchangerObjectInfo();
         _loc2_.deserialize(param1);
         this.itemTypeDescriptions.push(_loc2_);
    }

}