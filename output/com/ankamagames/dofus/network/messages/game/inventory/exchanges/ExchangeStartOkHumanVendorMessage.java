package package com.ankamagames.dofus.network.messages.game.inventory.exchanges;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.data.items.ObjectItemToSellInHumanVendorShop;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;

public class ExchangeStartOkHumanVendorMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 5767;
    private boolean _isInitialized = false;
    private Number sellerId = 0;
    private Vector.<ObjectItemToSellInHumanVendorShop> objectsInfos = ;
    private FuncTree _objectsInfostree = ;
    private int _loc2_ = 0;
    private int _loc2_ = param1.readUnsignedShort();
    private int _loc3_ = 0;
    private int _loc3_ = 0;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 5767;
    }

    public ExchangeStartOkHumanVendorMessage initExchangeStartOkHumanVendorMessage(Number param1,Vector.<ObjectItemToSellInHumanVendorShop>  param2) {
         this.sellerId = param1;
         this.objectsInfos = param2;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.sellerId = 0;
         this.objectsInfos = new Vector.<ObjectItemToSellInHumanVendorShop>();
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
         this.serializeAs_ExchangeStartOkHumanVendorMessage(param1);
    }

    public void serializeAs_ExchangeStartOkHumanVendorMessage(ICustomDataOutput param1) {
         if(this.sellerId < -9.007199254740992E15 || this.sellerId > 9.007199254740992E15)
            throw new Exception("Forbidden value (" + this.sellerId + ") on element sellerId.");
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_ExchangeStartOkHumanVendorMessage(param1);
    }

    public void deserializeAs_ExchangeStartOkHumanVendorMessage(ICustomDataInput param1) {
         ObjectItemToSellInHumanVendorShop _loc4_ = null;
         this._sellerIdFunc(param1);
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
            _loc4_ = new ObjectItemToSellInHumanVendorShop();
            _loc4_.deserialize(param1);
            this.objectsInfos.push(_loc4_);
            _loc3_++;
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_ExchangeStartOkHumanVendorMessage(param1);
    }

    public void deserializeAsyncAs_ExchangeStartOkHumanVendorMessage(FuncTree param1) {
         param1.addChild(this._sellerIdFunc);
         this._objectsInfostree = param1.addChild(this._objectsInfostreeFunc);
    }

    private void _sellerIdFunc(ICustomDataInput param1) {
         this.sellerId = param1.readDouble();
         if(this.sellerId < -9.007199254740992E15 || this.sellerId > 9.007199254740992E15)
            throw new Exception("Forbidden value (" + this.sellerId + ") on element of ExchangeStartOkHumanVendorMessage.sellerId.");
    }

    private void _objectsInfostreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
            this._objectsInfostree.addChild(this._objectsInfosFunc);
            _loc3_++;
    }

    private void _objectsInfosFunc(ICustomDataInput param1) {
         ObjectItemToSellInHumanVendorShop _loc2_ = new ObjectItemToSellInHumanVendorShop();
         _loc2_.deserialize(param1);
         this.objectsInfos.push(_loc2_);
    }

}