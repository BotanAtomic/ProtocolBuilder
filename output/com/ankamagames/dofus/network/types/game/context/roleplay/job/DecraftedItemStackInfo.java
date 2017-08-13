package package com.ankamagames.dofus.network.types.game.context.roleplay.job;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;

public class DecraftedItemStackInfo extends Object implements INetworkType {

    private int protocolId = 481;
    private int objectUID = 0;
    private Number bonusMin = 0;
    private Number bonusMax = 0;
    private Vector.<uint> runesId = ;
    private Vector.<uint> runesQty = ;
    private FuncTree _runesIdtree = ;
    private FuncTree _runesQtytree = ;
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
         return 481;
    }

    public DecraftedItemStackInfo initDecraftedItemStackInfo(int param1,Number  param2,Number  param3,Vector.<uint>  param4,Vector.<uint>  param5) {
         this.objectUID = param1;
         this.bonusMin = param2;
         this.bonusMax = param3;
         this.runesId = param4;
         this.runesQty = param5;
         return this;
    }

    public void reset() {
         this.objectUID = 0;
         this.bonusMin = 0;
         this.bonusMax = 0;
         this.runesId = new Vector.<uint>();
         this.runesQty = new Vector.<uint>();
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_DecraftedItemStackInfo(param1);
    }

    public void serializeAs_DecraftedItemStackInfo(ICustomDataOutput param1) {
         if(this.objectUID < 0)
            throw new Exception("Forbidden value (" + this.objectUID + ") on element objectUID.");
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_DecraftedItemStackInfo(param1);
    }

    public void deserializeAs_DecraftedItemStackInfo(ICustomDataInput param1) {
         int _loc6_ = 0;
         int _loc7_ = 0;
         this._objectUIDFunc(param1);
         this._bonusMinFunc(param1);
         this._bonusMaxFunc(param1);
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
            _loc6_ = param1.readVarUhShort();
            if(_loc6_ < 0)
               throw new Exception("Forbidden value (" + _loc6_ + ") on elements of runesId.");
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_DecraftedItemStackInfo(param1);
    }

    public void deserializeAsyncAs_DecraftedItemStackInfo(FuncTree param1) {
         param1.addChild(this._objectUIDFunc);
         param1.addChild(this._bonusMinFunc);
         param1.addChild(this._bonusMaxFunc);
         this._runesIdtree = param1.addChild(this._runesIdtreeFunc);
         this._runesQtytree = param1.addChild(this._runesQtytreeFunc);
    }

    private void _objectUIDFunc(ICustomDataInput param1) {
         this.objectUID = param1.readVarUhInt();
         if(this.objectUID < 0)
            throw new Exception("Forbidden value (" + this.objectUID + ") on element of DecraftedItemStackInfo.objectUID.");
    }

    private void _bonusMinFunc(ICustomDataInput param1) {
         this.bonusMin = param1.readFloat();
    }

    private void _bonusMaxFunc(ICustomDataInput param1) {
         this.bonusMax = param1.readFloat();
    }

    private void _runesIdtreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
            this._runesIdtree.addChild(this._runesIdFunc);
            _loc3_++;
    }

    private void _runesIdFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readVarUhShort();
         if(_loc2_ < 0)
            throw new Exception("Forbidden value (" + _loc2_ + ") on elements of runesId.");
    }

    private void _runesQtytreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
            this._runesQtytree.addChild(this._runesQtyFunc);
            _loc3_++;
    }

    private void _runesQtyFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readVarUhInt();
         if(_loc2_ < 0)
            throw new Exception("Forbidden value (" + _loc2_ + ") on elements of runesQty.");
    }

}