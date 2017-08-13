package package com.ankamagames.dofus.network.messages.game.inventory.exchanges;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.data.items.ObjectItemToSellInNpcShop;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;

public class ExchangeStartOkNpcShopMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 5761;
    private boolean _isInitialized = false;
    private Number npcSellerId = 0;
    private int tokenId = 0;
    private Vector.<ObjectItemToSellInNpcShop> objectsInfos = ;
    private FuncTree _objectsInfostree = ;
    private int _loc2_ = 0;
    private int _loc2_ = param1.readUnsignedShort();
    private int _loc3_ = 0;
    private int _loc3_ = 0;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 5761;
    }

    public ExchangeStartOkNpcShopMessage initExchangeStartOkNpcShopMessage(Number param1,int  param2,Vector.<ObjectItemToSellInNpcShop>  param3) {
         this.npcSellerId = param1;
         this.tokenId = param2;
         this.objectsInfos = param3;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.npcSellerId = 0;
         this.tokenId = 0;
         this.objectsInfos = new Vector.<ObjectItemToSellInNpcShop>();
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
         this.serializeAs_ExchangeStartOkNpcShopMessage(param1);
    }

    public void serializeAs_ExchangeStartOkNpcShopMessage(ICustomDataOutput param1) {
         if(this.npcSellerId < -9.007199254740992E15 || this.npcSellerId > 9.007199254740992E15)
            throw new Exception("Forbidden value (" + this.npcSellerId + ") on element npcSellerId.");
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_ExchangeStartOkNpcShopMessage(param1);
    }

    public void deserializeAs_ExchangeStartOkNpcShopMessage(ICustomDataInput param1) {
         ObjectItemToSellInNpcShop _loc4_ = null;
         this._npcSellerIdFunc(param1);
         this._tokenIdFunc(param1);
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
            _loc4_ = new ObjectItemToSellInNpcShop();
            _loc4_.deserialize(param1);
            this.objectsInfos.push(_loc4_);
            _loc3_++;
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_ExchangeStartOkNpcShopMessage(param1);
    }

    public void deserializeAsyncAs_ExchangeStartOkNpcShopMessage(FuncTree param1) {
         param1.addChild(this._npcSellerIdFunc);
         param1.addChild(this._tokenIdFunc);
         this._objectsInfostree = param1.addChild(this._objectsInfostreeFunc);
    }

    private void _npcSellerIdFunc(ICustomDataInput param1) {
         this.npcSellerId = param1.readDouble();
         if(this.npcSellerId < -9.007199254740992E15 || this.npcSellerId > 9.007199254740992E15)
            throw new Exception("Forbidden value (" + this.npcSellerId + ") on element of ExchangeStartOkNpcShopMessage.npcSellerId.");
    }

    private void _tokenIdFunc(ICustomDataInput param1) {
         this.tokenId = param1.readVarUhShort();
         if(this.tokenId < 0)
            throw new Exception("Forbidden value (" + this.tokenId + ") on element of ExchangeStartOkNpcShopMessage.tokenId.");
    }

    private void _objectsInfostreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
            this._objectsInfostree.addChild(this._objectsInfosFunc);
            _loc3_++;
    }

    private void _objectsInfosFunc(ICustomDataInput param1) {
         ObjectItemToSellInNpcShop _loc2_ = new ObjectItemToSellInNpcShop();
         _loc2_.deserialize(param1);
         this.objectsInfos.push(_loc2_);
    }

}