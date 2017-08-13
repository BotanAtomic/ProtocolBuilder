package com.ankamagames.dofus.network.messages.game.inventory.exchanges;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.data.items.effects.ObjectEffect;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import com.ankamagames.dofus.network.ProtocolTypeManager;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;

public class ExchangeBidHouseInListAddedMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 5949;
    private boolean _isInitialized = false;
    private int itemUID = 0;
    private int objGenericId = 0;
    private Vector<ObjectEffect> effects;
    private Vector<Number> prices;
    private FuncTree _effectstree;
    private FuncTree _pricestree;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 5949;
    }

    public ExchangeBidHouseInListAddedMessage initExchangeBidHouseInListAddedMessage(int param1,int  param2,Vector<ObjectEffect>  param3,Vector<Number>  param4) {
         this.itemUID = param1;
         this.objGenericId = param2;
         this.effects = param3;
         this.prices = param4;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.itemUID = 0;
         this.objGenericId = 0;
         this.effects = new Vector.<ObjectEffect>();
         this.prices = new Vector.<Number>();
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
         this.serializeAs_ExchangeBidHouseInListAddedMessage(param1);
    }

    public void serializeAs_ExchangeBidHouseInListAddedMessage(ICustomDataOutput param1) {
         param1.writeInt(this.itemUID);
         param1.writeInt(this.objGenericId);
         param1.writeShort(this.effects.length);
         int _loc2_ = 0;
         while(_loc2_ < this.effects.length)
         {
            param1.writeShort((this.effects[_loc2_] as ObjectEffect).getTypeId());
            (this.effects[_loc2_] as ObjectEffect).serialize(param1);
            _loc2_++;
         }
         param1.writeShort(this.prices.length);
         int _loc3_ = 0;
         while(_loc3_ < this.prices.length)
         {
            if(this.prices[_loc3_] < 0 || this.prices[_loc3_] > 9.007199254740992E15)
            {
               throw new Exception("Forbidden value (" + this.prices[_loc3_] + ") on element 4 (starting at 1) of prices.");
            }
            param1.writeVarLong(this.prices[_loc3_]);
            _loc3_++;
         }
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_ExchangeBidHouseInListAddedMessage(param1);
    }

    public void deserializeAs_ExchangeBidHouseInListAddedMessage(ICustomDataInput param1) {
         int _loc6_ = 0;
         ObjectEffect _loc7_ = null;
         * _loc8_ = NaN;
         this._itemUIDFunc(param1);
         this._objGenericIdFunc(param1);
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            _loc6_ = param1.readUnsignedShort();
            _loc7_ = ProtocolTypeManager.getInstance(ObjectEffect,_loc6_);
            _loc7_.deserialize(param1);
            this.effects.push(_loc7_);
            _loc3_++;
         }
         int _loc4_ = param1.readUnsignedShort();
         int _loc5_ = 0;
         while(_loc5_ < _loc4_)
         {
            _loc8_ = param1.readVarUhLong();
            if(_loc8_ < 0 || _loc8_ > 9.007199254740992E15)
            {
               throw new Exception("Forbidden value (" + _loc8_ + ") on elements of prices.");
            }
            this.prices.push(_loc8_);
            _loc5_++;
         }
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_ExchangeBidHouseInListAddedMessage(param1);
    }

    public void deserializeAsyncAs_ExchangeBidHouseInListAddedMessage(FuncTree param1) {
         param1.addChild(this._itemUIDFunc);
         param1.addChild(this._objGenericIdFunc);
         this._effectstree = param1.addChild(this._effectstreeFunc);
         this._pricestree = param1.addChild(this._pricestreeFunc);
    }

    private void _itemUIDFunc(ICustomDataInput param1) {
         this.itemUID = param1.readInt();
    }

    private void _objGenericIdFunc(ICustomDataInput param1) {
         this.objGenericId = param1.readInt();
    }

    private void _effectstreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            this._effectstree.addChild(this._effectsFunc);
            _loc3_++;
         }
    }

    private void _effectsFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         ObjectEffect _loc3_ = ProtocolTypeManager.getInstance(ObjectEffect,_loc2_);
         _loc3_.deserialize(param1);
         this.effects.push(_loc3_);
    }

    private void _pricestreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            this._pricestree.addChild(this._pricesFunc);
            _loc3_++;
         }
    }

    private void _pricesFunc(ICustomDataInput param1) {
         Number _loc2_ = param1.readVarUhLong();
         if(_loc2_ < 0 || _loc2_ > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + _loc2_ + ") on elements of prices.");
         }
         this.prices.push(_loc2_);
    }

}