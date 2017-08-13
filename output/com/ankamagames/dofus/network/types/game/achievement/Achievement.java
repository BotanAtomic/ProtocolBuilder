package package com.ankamagames.dofus.network.types.game.achievement;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;

public class Achievement extends Object implements INetworkType {

    private int protocolId = 363;
    private int id = 0;
    private Vector.<AchievementObjective> finishedObjective = ;
    private Vector.<AchievementStartedObjective> startedObjectives = ;
    private FuncTree _finishedObjectivetree = ;
    private FuncTree _startedObjectivestree = ;
    private int _loc2_ = 0;
    private int _loc3_ = 0;
    private AchievementStartedObjective _loc7_ = null;
    private int _loc2_ = param1.readUnsignedShort();
    private int _loc3_ = 0;
    private int _loc4_ = param1.readUnsignedShort();
    private int _loc5_ = 0;
    private int _loc3_ = 0;
    private int _loc3_ = 0;


    public int getTypeId() {
         return 363;
    }

    public Achievement initAchievement(int param1,Vector.<AchievementObjective>  param2,Vector.<AchievementStartedObjective>  param3) {
         this.id = param1;
         this.finishedObjective = param2;
         this.startedObjectives = param3;
         return this;
    }

    public void reset() {
         this.id = 0;
         this.finishedObjective = new Vector.<AchievementObjective>();
         this.startedObjectives = new Vector.<AchievementStartedObjective>();
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_Achievement(param1);
    }

    public void serializeAs_Achievement(ICustomDataOutput param1) {
         if(this.id < 0)
            throw new Exception("Forbidden value (" + this.id + ") on element id.");
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_Achievement(param1);
    }

    public void deserializeAs_Achievement(ICustomDataInput param1) {
         AchievementObjective _loc6_ = null;
         AchievementStartedObjective _loc7_ = null;
         this._idFunc(param1);
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
            _loc6_ = new AchievementObjective();
            _loc6_.deserialize(param1);
            this.finishedObjective.push(_loc6_);
            _loc3_++;
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_Achievement(param1);
    }

    public void deserializeAsyncAs_Achievement(FuncTree param1) {
         param1.addChild(this._idFunc);
         this._finishedObjectivetree = param1.addChild(this._finishedObjectivetreeFunc);
         this._startedObjectivestree = param1.addChild(this._startedObjectivestreeFunc);
    }

    private void _idFunc(ICustomDataInput param1) {
         this.id = param1.readVarUhShort();
         if(this.id < 0)
            throw new Exception("Forbidden value (" + this.id + ") on element of Achievement.id.");
    }

    private void _finishedObjectivetreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
            this._finishedObjectivetree.addChild(this._finishedObjectiveFunc);
            _loc3_++;
    }

    private void _finishedObjectiveFunc(ICustomDataInput param1) {
         AchievementObjective _loc2_ = new AchievementObjective();
         _loc2_.deserialize(param1);
         this.finishedObjective.push(_loc2_);
    }

    private void _startedObjectivestreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
            this._startedObjectivestree.addChild(this._startedObjectivesFunc);
            _loc3_++;
    }

    private void _startedObjectivesFunc(ICustomDataInput param1) {
         AchievementStartedObjective _loc2_ = new AchievementStartedObjective();
         _loc2_.deserialize(param1);
         this.startedObjectives.push(_loc2_);
    }

}