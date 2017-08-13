package package com.ankamagames.dofus.network.types.game.interactive.skill;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;

public class SkillActionDescriptionCollect extends SkillActionDescriptionTimed implements INetworkType {

    private int protocolId = 99;
    private int min = 0;
    private int max = 0;


    public int getTypeId() {
         return 99;
    }

    public SkillActionDescriptionCollect initSkillActionDescriptionCollect(int param1,int  param2,int  param3,int  param4) {
         super.initSkillActionDescriptionTimed(param1,param2);
         this.min = param3;
         this.max = param4;
         return this;
    }

    public void reset() {
         super.reset();
         this.min = 0;
         this.max = 0;
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_SkillActionDescriptionCollect(param1);
    }

    public void serializeAs_SkillActionDescriptionCollect(ICustomDataOutput param1) {
         super.serializeAs_SkillActionDescriptionTimed(param1);
         if(this.min < 0)
            throw new Exception("Forbidden value (" + this.min + ") on element min.");
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_SkillActionDescriptionCollect(param1);
    }

    public void deserializeAs_SkillActionDescriptionCollect(ICustomDataInput param1) {
         super.deserialize(param1);
         this._minFunc(param1);
         this._maxFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_SkillActionDescriptionCollect(param1);
    }

    public void deserializeAsyncAs_SkillActionDescriptionCollect(FuncTree param1) {
         super.deserializeAsync(param1);
         param1.addChild(this._minFunc);
         param1.addChild(this._maxFunc);
    }

    private void _minFunc(ICustomDataInput param1) {
         this.min = param1.readVarUhShort();
         if(this.min < 0)
            throw new Exception("Forbidden value (" + this.min + ") on element of SkillActionDescriptionCollect.min.");
    }

    private void _maxFunc(ICustomDataInput param1) {
         this.max = param1.readVarUhShort();
         if(this.max < 0)
            throw new Exception("Forbidden value (" + this.max + ") on element of SkillActionDescriptionCollect.max.");
    }

}