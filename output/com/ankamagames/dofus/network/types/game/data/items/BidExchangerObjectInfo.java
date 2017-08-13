package package com.ankamagames.dofus.network.types.game.data.items;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.dofus.network.types.game.data.items.effects.ObjectEffect;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.dofus.network.ProtocolTypeManager;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;

public class BidExchangerObjectInfo extends Object implements INetworkType {

    private int protocolId = 122;
    private int objectUID = 0;
    private Vector.<ObjectEffect> effects = ;
    private Vector.<Number> prices = ;
    private FuncTree _effectstree = ;
    private FuncTree _pricestree = ;
    private int _loc2_ = 0;
    private int _loc3_ = 0;
    private ObjectEffect _loc7_ = null;
    private * _loc8_ = NaN;
    private int _loc2_ = param1.readUnsignedShort();
    private int _loc3_ = 0;
    private int _loc4_ = param1.readUnsignedShort();
    private int _loc5_ = 0;
    private int _loc3_ = 0;
    private ObjectEffect _loc3_ = ProtocolTypeManager.getInstance(ObjectEffect,_loc2_);
    private int _loc3_ = 0;


    public int getTypeId() {
         return 122;
    }

    public BidExchangerObjectInfo initBidExchangerObjectInfo(int param1,Vector.<ObjectEffect>  param2,Vector.<Number>  param3) {
         this.objectUID = param1;
         this.effects = param2;
         this.prices = param3;
         return this;
    }

    public void reset() {
         this.objectUID = 0;
         this.effects = new Vector.<ObjectEffect>();
         this.prices = new Vector.<Number>();
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_BidExchangerObjectInfo(param1);
    }

    public void serializeAs_BidExchangerObjectInfo(ICustomDataOutput param1) {
         if(this.objectUID < 0)
            throw new Exception("Forbidden value (" + this.objectUID + ") on element objectUID.");
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_BidExchangerObjectInfo(param1);
    }

    public void deserializeAs_BidExchangerObjectInfo(ICustomDataInput param1) {
         int _loc6_ = 0;
         ObjectEffect _loc7_ = null;
         * _loc8_ = NaN;
         this._objectUIDFunc(param1);
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
            _loc6_ = param1.readUnsignedShort();
            _loc7_ = ProtocolTypeManager.getInstance(ObjectEffect,_loc6_);
            _loc7_.deserialize(param1);
            this.effects.push(_loc7_);
            _loc3_++;
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_BidExchangerObjectInfo(param1);
    }

    public void deserializeAsyncAs_BidExchangerObjectInfo(FuncTree param1) {
         param1.addChild(this._objectUIDFunc);
         this._effectstree = param1.addChild(this._effectstreeFunc);
         this._pricestree = param1.addChild(this._pricestreeFunc);
    }

    private void _objectUIDFunc(ICustomDataInput param1) {
         this.objectUID = param1.readVarUhInt();
         if(this.objectUID < 0)
            throw new Exception("Forbidden value (" + this.objectUID + ") on element of BidExchangerObjectInfo.objectUID.");
    }

    private void _effectstreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
            this._effectstree.addChild(this._effectsFunc);
            _loc3_++;
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
            this._pricestree.addChild(this._pricesFunc);
            _loc3_++;
    }

    private void _pricesFunc(ICustomDataInput param1) {
         Number _loc2_ = param1.readVarUhLong();
         if(_loc2_ < 0 || _loc2_ > 9.007199254740992E15)
            throw new Exception("Forbidden value (" + _loc2_ + ") on elements of prices.");
    }

}