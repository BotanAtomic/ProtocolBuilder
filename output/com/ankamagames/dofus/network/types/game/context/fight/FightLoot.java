package package com.ankamagames.dofus.network.types.game.context.fight;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;

public class FightLoot extends Object implements INetworkType {

    private int protocolId = 41;
    private Vector.<uint> objects = ;
    private Number kamas = 0;
    private FuncTree _objectstree = ;
    private int _loc2_ = 0;
    private int _loc2_ = param1.readUnsignedShort();
    private int _loc3_ = 0;
    private int _loc3_ = 0;


    public int getTypeId() {
         return 41;
    }

    public FightLoot initFightLoot(Vector.<uint> param1,Number  param2) {
         this.objects = param1;
         this.kamas = param2;
         return this;
    }

    public void reset() {
         this.objects = new Vector.<uint>();
         this.kamas = 0;
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_FightLoot(param1);
    }

    public void serializeAs_FightLoot(ICustomDataOutput param1) {
         param1.writeShort(this.objects.length);
         int _loc2_ = 0;
         while(_loc2_ < this.objects.length)
            if(this.objects[_loc2_] < 0)
               throw new Exception("Forbidden value (" + this.objects[_loc2_] + ") on element 1 (starting at 1) of objects.");
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_FightLoot(param1);
    }

    public void deserializeAs_FightLoot(ICustomDataInput param1) {
         int _loc4_ = 0;
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
            _loc4_ = param1.readVarUhShort();
            if(_loc4_ < 0)
               throw new Exception("Forbidden value (" + _loc4_ + ") on elements of objects.");
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_FightLoot(param1);
    }

    public void deserializeAsyncAs_FightLoot(FuncTree param1) {
         this._objectstree = param1.addChild(this._objectstreeFunc);
         param1.addChild(this._kamasFunc);
    }

    private void _objectstreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
            this._objectstree.addChild(this._objectsFunc);
            _loc3_++;
    }

    private void _objectsFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readVarUhShort();
         if(_loc2_ < 0)
            throw new Exception("Forbidden value (" + _loc2_ + ") on elements of objects.");
    }

    private void _kamasFunc(ICustomDataInput param1) {
         this.kamas = param1.readVarUhLong();
         if(this.kamas < 0 || this.kamas > 9.007199254740992E15)
            throw new Exception("Forbidden value (" + this.kamas + ") on element of FightLoot.kamas.");
    }

}