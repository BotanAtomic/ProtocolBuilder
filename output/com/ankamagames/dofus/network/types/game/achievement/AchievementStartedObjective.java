package package com.ankamagames.dofus.network.types.game.achievement;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;

public class AchievementStartedObjective extends AchievementObjective implements INetworkType {

    private int protocolId = 402;
    private int value = 0;


    public int getTypeId() {
         return 402;
    }

    public AchievementStartedObjective initAchievementStartedObjective(int param1,int  param2,int  param3) {
         super.initAchievementObjective(param1,param2);
         this.value = param3;
         return this;
    }

    public void reset() {
         super.reset();
         this.value = 0;
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_AchievementStartedObjective(param1);
    }

    public void serializeAs_AchievementStartedObjective(ICustomDataOutput param1) {
         super.serializeAs_AchievementObjective(param1);
         if(this.value < 0)
            throw new Exception("Forbidden value (" + this.value + ") on element value.");
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_AchievementStartedObjective(param1);
    }

    public void deserializeAs_AchievementStartedObjective(ICustomDataInput param1) {
         super.deserialize(param1);
         this._valueFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_AchievementStartedObjective(param1);
    }

    public void deserializeAsyncAs_AchievementStartedObjective(FuncTree param1) {
         super.deserializeAsync(param1);
         param1.addChild(this._valueFunc);
    }

    private void _valueFunc(ICustomDataInput param1) {
         this.value = param1.readVarUhShort();
         if(this.value < 0)
            throw new Exception("Forbidden value (" + this.value + ") on element of AchievementStartedObjective.value.");
    }

}