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
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;

public class ObjectItemToSellInHumanVendorShop extends Item implements INetworkType {

    private int protocolId = 359;
    private int objectGID = 0;
    private Vector.<ObjectEffect> effects = ;
    private int objectUID = 0;
    private int quantity = 0;
    private Number objectPrice = 0;
    private Number publicPrice = 0;
    private FuncTree _effectstree = ;
    private int _loc2_ = 0;
    private ObjectEffect _loc5_ = null;
    private int _loc2_ = param1.readUnsignedShort();
    private int _loc3_ = 0;
    private int _loc3_ = 0;
    private ObjectEffect _loc3_ = ProtocolTypeManager.getInstance(ObjectEffect,_loc2_);


    public int getTypeId() {
         return 359;
    }

    public ObjectItemToSellInHumanVendorShop initObjectItemToSellInHumanVendorShop(int param1,Vector.<ObjectEffect>  param2,int  param3,int  param4,Number  param5,Number  param6) {
         this.objectGID = param1;
         this.effects = param2;
         this.objectUID = param3;
         this.quantity = param4;
         this.objectPrice = param5;
         this.publicPrice = param6;
         return this;
    }

    public void reset() {
         this.objectGID = 0;
         this.effects = new Vector.<ObjectEffect>();
         this.objectUID = 0;
         this.quantity = 0;
         this.objectPrice = 0;
         this.publicPrice = 0;
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_ObjectItemToSellInHumanVendorShop(param1);
    }

    public void serializeAs_ObjectItemToSellInHumanVendorShop(ICustomDataOutput param1) {
         super.serializeAs_Item(param1);
         if(this.objectGID < 0)
            throw new Exception("Forbidden value (" + this.objectGID + ") on element objectGID.");
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_ObjectItemToSellInHumanVendorShop(param1);
    }

    public void deserializeAs_ObjectItemToSellInHumanVendorShop(ICustomDataInput param1) {
         int _loc4_ = 0;
         ObjectEffect _loc5_ = null;
         super.deserialize(param1);
         this._objectGIDFunc(param1);
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
            _loc4_ = param1.readUnsignedShort();
            _loc5_ = ProtocolTypeManager.getInstance(ObjectEffect,_loc4_);
            _loc5_.deserialize(param1);
            this.effects.push(_loc5_);
            _loc3_++;
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_ObjectItemToSellInHumanVendorShop(param1);
    }

    public void deserializeAsyncAs_ObjectItemToSellInHumanVendorShop(FuncTree param1) {
         super.deserializeAsync(param1);
         param1.addChild(this._objectGIDFunc);
         this._effectstree = param1.addChild(this._effectstreeFunc);
         param1.addChild(this._objectUIDFunc);
         param1.addChild(this._quantityFunc);
         param1.addChild(this._objectPriceFunc);
         param1.addChild(this._publicPriceFunc);
    }

    private void _objectGIDFunc(ICustomDataInput param1) {
         this.objectGID = param1.readVarUhShort();
         if(this.objectGID < 0)
            throw new Exception("Forbidden value (" + this.objectGID + ") on element of ObjectItemToSellInHumanVendorShop.objectGID.");
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

    private void _objectUIDFunc(ICustomDataInput param1) {
         this.objectUID = param1.readVarUhInt();
         if(this.objectUID < 0)
            throw new Exception("Forbidden value (" + this.objectUID + ") on element of ObjectItemToSellInHumanVendorShop.objectUID.");
    }

    private void _quantityFunc(ICustomDataInput param1) {
         this.quantity = param1.readVarUhInt();
         if(this.quantity < 0)
            throw new Exception("Forbidden value (" + this.quantity + ") on element of ObjectItemToSellInHumanVendorShop.quantity.");
    }

    private void _objectPriceFunc(ICustomDataInput param1) {
         this.objectPrice = param1.readVarUhLong();
         if(this.objectPrice < 0 || this.objectPrice > 9.007199254740992E15)
            throw new Exception("Forbidden value (" + this.objectPrice + ") on element of ObjectItemToSellInHumanVendorShop.objectPrice.");
    }

    public void _publicPriceFunc(ICustomDataInput param1) {
         this.publicPrice = param1.readVarUhLong();
         if(this.publicPrice < 0 || this.publicPrice > 9.007199254740992E15)
            throw new Exception("Forbidden value (" + this.publicPrice + ") on element of ObjectItemToSellInHumanVendorShop.publicPrice.");
    }

}