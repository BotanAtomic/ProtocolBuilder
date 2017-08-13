package package com.ankamagames.dofus.network.types.game.data.items;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;

public class SellerBuyerDescriptor extends Object implements INetworkType {

    private int protocolId = 121;
    private Vector.<uint> quantities = ;
    private Vector.<uint> types = ;
    private Number taxPercentage = 0;
    private Number taxModificationPercentage = 0;
    private int maxItemLevel = 0;
    private int maxItemPerAccount = 0;
    private int npcContextualId = 0;
    private int unsoldDelay = 0;
    private FuncTree _quantitiestree = ;
    private FuncTree _typestree = ;
    private int _loc2_ = 0;
    private int _loc3_ = 0;
    private int _loc7_ = 0;
    private int _loc2_ = param1.readUnsignedShort();
    private int _loc3_ = 0;
    private int _loc4_ = param1.readUnsignedShort();
    private int _loc5_ = 0;
    private int _loc3_ = 0;
    private int _loc3_ = 0;


    public int getTypeId() {
         return 121;
    }

    public SellerBuyerDescriptor initSellerBuyerDescriptor(Vector.<uint> param1,Vector.<uint>  param2,Number  param3,Number  param4,int  param5,int  param6,int  param7,int  param8) {
         this.quantities = param1;
         this.types = param2;
         this.taxPercentage = param3;
         this.taxModificationPercentage = param4;
         this.maxItemLevel = param5;
         this.maxItemPerAccount = param6;
         this.npcContextualId = param7;
         this.unsoldDelay = param8;
         return this;
    }

    public void reset() {
         this.quantities = new Vector.<uint>();
         this.types = new Vector.<uint>();
         this.taxPercentage = 0;
         this.taxModificationPercentage = 0;
         this.maxItemLevel = 0;
         this.maxItemPerAccount = 0;
         this.npcContextualId = 0;
         this.unsoldDelay = 0;
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_SellerBuyerDescriptor(param1);
    }

    public void serializeAs_SellerBuyerDescriptor(ICustomDataOutput param1) {
         param1.writeShort(this.quantities.length);
         int _loc2_ = 0;
         while(_loc2_ < this.quantities.length)
            if(this.quantities[_loc2_] < 0)
               throw new Exception("Forbidden value (" + this.quantities[_loc2_] + ") on element 1 (starting at 1) of quantities.");
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_SellerBuyerDescriptor(param1);
    }

    public void deserializeAs_SellerBuyerDescriptor(ICustomDataInput param1) {
         int _loc6_ = 0;
         int _loc7_ = 0;
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
            _loc6_ = param1.readVarUhInt();
            if(_loc6_ < 0)
               throw new Exception("Forbidden value (" + _loc6_ + ") on elements of quantities.");
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_SellerBuyerDescriptor(param1);
    }

    public void deserializeAsyncAs_SellerBuyerDescriptor(FuncTree param1) {
         this._quantitiestree = param1.addChild(this._quantitiestreeFunc);
         this._typestree = param1.addChild(this._typestreeFunc);
         param1.addChild(this._taxPercentageFunc);
         param1.addChild(this._taxModificationPercentageFunc);
         param1.addChild(this._maxItemLevelFunc);
         param1.addChild(this._maxItemPerAccountFunc);
         param1.addChild(this._npcContextualIdFunc);
         param1.addChild(this._unsoldDelayFunc);
    }

    private void _quantitiestreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
            this._quantitiestree.addChild(this._quantitiesFunc);
            _loc3_++;
    }

    private void _quantitiesFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readVarUhInt();
         if(_loc2_ < 0)
            throw new Exception("Forbidden value (" + _loc2_ + ") on elements of quantities.");
    }

    private void _typestreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
            this._typestree.addChild(this._typesFunc);
            _loc3_++;
    }

    private void _typesFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readVarUhInt();
         if(_loc2_ < 0)
            throw new Exception("Forbidden value (" + _loc2_ + ") on elements of types.");
    }

    private void _taxPercentageFunc(ICustomDataInput param1) {
         this.taxPercentage = param1.readFloat();
    }

    private void _taxModificationPercentageFunc(ICustomDataInput param1) {
         this.taxModificationPercentage = param1.readFloat();
    }

    private void _maxItemLevelFunc(ICustomDataInput param1) {
         this.maxItemLevel = param1.readUnsignedByte();
         if(this.maxItemLevel < 0 || this.maxItemLevel > 255)
            throw new Exception("Forbidden value (" + this.maxItemLevel + ") on element of SellerBuyerDescriptor.maxItemLevel.");
    }

    private void _maxItemPerAccountFunc(ICustomDataInput param1) {
         this.maxItemPerAccount = param1.readVarUhInt();
         if(this.maxItemPerAccount < 0)
            throw new Exception("Forbidden value (" + this.maxItemPerAccount + ") on element of SellerBuyerDescriptor.maxItemPerAccount.");
    }

    private void _npcContextualIdFunc(ICustomDataInput param1) {
         this.npcContextualId = param1.readInt();
    }

    private void _unsoldDelayFunc(ICustomDataInput param1) {
         this.unsoldDelay = param1.readVarUhShort();
         if(this.unsoldDelay < 0)
            throw new Exception("Forbidden value (" + this.unsoldDelay + ") on element of SellerBuyerDescriptor.unsoldDelay.");
    }

}