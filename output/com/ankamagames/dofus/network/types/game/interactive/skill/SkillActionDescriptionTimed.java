package package com.ankamagames.dofus.network.types.game.interactive.skill;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;

public class SkillActionDescriptionTimed extends SkillActionDescription implements INetworkType {

    private int protocolId = 103;
    private int time = 0;


    public int getTypeId() {
         return 103;
    }

    public SkillActionDescriptionTimed initSkillActionDescriptionTimed(int param1,int  param2) {
         super.initSkillActionDescription(param1);
         this.time = param2;
         return this;
    }

    public void reset() {
         super.reset();
         this.time = 0;
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_SkillActionDescriptionTimed(param1);
    }

    public void serializeAs_SkillActionDescriptionTimed(ICustomDataOutput param1) {
         super.serializeAs_SkillActionDescription(param1);
         if(this.time < 0 || this.time > 255)
            throw new Exception("Forbidden value (" + this.time + ") on element time.");
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_SkillActionDescriptionTimed(param1);
    }

    public void deserializeAs_SkillActionDescriptionTimed(ICustomDataInput param1) {
         super.deserialize(param1);
         this._timeFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_SkillActionDescriptionTimed(param1);
    }

    public void deserializeAsyncAs_SkillActionDescriptionTimed(FuncTree param1) {
         super.deserializeAsync(param1);
         param1.addChild(this._timeFunc);
    }

    private void _timeFunc(ICustomDataInput param1) {
         this.time = param1.readUnsignedByte();
         if(this.time < 0 || this.time > 255)
            throw new Exception("Forbidden value (" + this.time + ") on element of SkillActionDescriptionTimed.time.");
    }

}