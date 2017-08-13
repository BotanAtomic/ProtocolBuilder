package com.ankamagames.dofus.network.types.game.achievement;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;

public class AchievementObjective extends Object implements INetworkType {

    private int protocolId = 404;
    private int id = 0;
    private int maxValue = 0;


    public int getTypeId() {
         return 404;
    }

    public AchievementObjective initAchievementObjective(int param1,int  param2) {
         this.id = param1;
         this.maxValue = param2;
         return this;
    }

    public void reset() {
         this.id = 0;
         this.maxValue = 0;
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_AchievementObjective(param1);
    }

    public void serializeAs_AchievementObjective(ICustomDataOutput param1) {
         if(this.id < 0)
         {
            throw new Exception("Forbidden value (" + this.id + ") on element id.");
         }
         param1.writeVarInt(this.id);
         if(this.maxValue < 0)
         {
            throw new Exception("Forbidden value (" + this.maxValue + ") on element maxValue.");
         }
         param1.writeVarShort(this.maxValue);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_AchievementObjective(param1);
    }

    public void deserializeAs_AchievementObjective(ICustomDataInput param1) {
         this._idFunc(param1);
         this._maxValueFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_AchievementObjective(param1);
    }

    public void deserializeAsyncAs_AchievementObjective(FuncTree param1) {
         param1.addChild(this._idFunc);
         param1.addChild(this._maxValueFunc);
    }

    private void _idFunc(ICustomDataInput param1) {
         this.id = param1.readVarUhInt();
         if(this.id < 0)
         {
            throw new Exception("Forbidden value (" + this.id + ") on element of AchievementObjective.id.");
         }
    }

    private void _maxValueFunc(ICustomDataInput param1) {
         this.maxValue = param1.readVarUhShort();
         if(this.maxValue < 0)
         {
            throw new Exception("Forbidden value (" + this.maxValue + ") on element of AchievementObjective.maxValue.");
         }
    }

}