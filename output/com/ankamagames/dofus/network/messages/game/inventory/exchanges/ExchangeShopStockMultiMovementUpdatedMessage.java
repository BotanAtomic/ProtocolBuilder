package com.ankamagames.dofus.network.messages.game.inventory.exchanges;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.data.items.ObjectItemToSell;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class ExchangeShopStockMultiMovementUpdatedMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6038;
    private boolean _isInitialized = false;
    private Vector<ObjectItemToSell> objectInfoList;
    private FuncTree _objectInfoListtree;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 6038;
    }

    public ExchangeShopStockMultiMovementUpdatedMessage initExchangeShopStockMultiMovementUpdatedMessage(Vector<ObjectItemToSell> param1) {
         this.objectInfoList = param1;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.objectInfoList = new Vector.<ObjectItemToSell>();
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
         this.serializeAs_ExchangeShopStockMultiMovementUpdatedMessage(param1);
    }

    public void serializeAs_ExchangeShopStockMultiMovementUpdatedMessage(ICustomDataOutput param1) {
         param1.writeShort(this.objectInfoList.length);
         int _loc2_ = 0;
         while(_loc2_ < this.objectInfoList.length)
         {
            (this.objectInfoList[_loc2_] as ObjectItemToSell).serializeAs_ObjectItemToSell(param1);
            _loc2_++;
         }
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_ExchangeShopStockMultiMovementUpdatedMessage(param1);
    }

    public void deserializeAs_ExchangeShopStockMultiMovementUpdatedMessage(ICustomDataInput param1) {
         ObjectItemToSell _loc4_ = null;
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            _loc4_ = new ObjectItemToSell();
            _loc4_.deserialize(param1);
            this.objectInfoList.push(_loc4_);
            _loc3_++;
         }
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_ExchangeShopStockMultiMovementUpdatedMessage(param1);
    }

    public void deserializeAsyncAs_ExchangeShopStockMultiMovementUpdatedMessage(FuncTree param1) {
         this._objectInfoListtree = param1.addChild(this._objectInfoListtreeFunc);
    }

    private void _objectInfoListtreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            this._objectInfoListtree.addChild(this._objectInfoListFunc);
            _loc3_++;
         }
    }

    private void _objectInfoListFunc(ICustomDataInput param1) {
         ObjectItemToSell _loc2_ = new ObjectItemToSell();
         _loc2_.deserialize(param1);
         this.objectInfoList.push(_loc2_);
    }

}