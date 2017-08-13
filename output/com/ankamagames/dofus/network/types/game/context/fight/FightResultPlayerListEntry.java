package com.ankamagames.dofus.network.types.game.context.fight;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.dofus.network.ProtocolTypeManager;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;

public class FightResultPlayerListEntry extends FightResultFighterListEntry implements INetworkType {

    private int protocolId = 24;
    private int level = 0;
    private Vector<FightResultAdditionalData> additional;
    private FuncTree _additionaltree;


    public int getTypeId() {
         return 24;
    }

    public FightResultPlayerListEntry initFightResultPlayerListEntry(int param1,int  param2,FightLoot  param3,Number  param4,boolean  param5,int  param6,Vector<FightResultAdditionalData>  param7) {
         super.initFightResultFighterListEntry(param1,param2,param3,param4,param5);
         this.level = param6;
         this.additional = param7;
         return this;
    }

    public void reset() {
         super.reset();
         this.level = 0;
         this.additional = new Vector.<FightResultAdditionalData>();
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_FightResultPlayerListEntry(param1);
    }

    public void serializeAs_FightResultPlayerListEntry(ICustomDataOutput param1) {
         super.serializeAs_FightResultFighterListEntry(param1);
         if(this.level < 1 || this.level > 206)
         {
            throw new Exception("Forbidden value (" + this.level + ") on element level.");
         }
         param1.writeByte(this.level);
         param1.writeShort(this.additional.length);
         int _loc2_ = 0;
         while(_loc2_ < this.additional.length)
         {
            param1.writeShort((this.additional[_loc2_] as FightResultAdditionalData).getTypeId());
            (this.additional[_loc2_] as FightResultAdditionalData).serialize(param1);
            _loc2_++;
         }
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_FightResultPlayerListEntry(param1);
    }

    public void deserializeAs_FightResultPlayerListEntry(ICustomDataInput param1) {
         int _loc4_ = 0;
         FightResultAdditionalData _loc5_ = null;
         super.deserialize(param1);
         this._levelFunc(param1);
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            _loc4_ = param1.readUnsignedShort();
            _loc5_ = ProtocolTypeManager.getInstance(FightResultAdditionalData,_loc4_);
            _loc5_.deserialize(param1);
            this.additional.push(_loc5_);
            _loc3_++;
         }
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_FightResultPlayerListEntry(param1);
    }

    public void deserializeAsyncAs_FightResultPlayerListEntry(FuncTree param1) {
         super.deserializeAsync(param1);
         param1.addChild(this._levelFunc);
         this._additionaltree = param1.addChild(this._additionaltreeFunc);
    }

    private void _levelFunc(ICustomDataInput param1) {
         this.level = param1.readUnsignedByte();
         if(this.level < 1 || this.level > 206)
         {
            throw new Exception("Forbidden value (" + this.level + ") on element of FightResultPlayerListEntry.level.");
         }
    }

    private void _additionaltreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            this._additionaltree.addChild(this._additionalFunc);
            _loc3_++;
         }
    }

    private void _additionalFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         FightResultAdditionalData _loc3_ = ProtocolTypeManager.getInstance(FightResultAdditionalData,_loc2_);
         _loc3_.deserialize(param1);
         this.additional.push(_loc3_);
    }

}