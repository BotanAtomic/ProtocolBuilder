package package com.ankamagames.dofus.network.types.game.context.roleplay;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;

public class HumanOptionSkillUse extends HumanOption implements INetworkType {

    private int protocolId = 495;
    private int elementId = 0;
    private int skillId = 0;
    private Number skillEndTime = 0;


    public int getTypeId() {
         return 495;
    }

    public HumanOptionSkillUse initHumanOptionSkillUse(int param1,int  param2,Number  param3) {
         this.elementId = param1;
         this.skillId = param2;
         this.skillEndTime = param3;
         return this;
    }

    public void reset() {
         this.elementId = 0;
         this.skillId = 0;
         this.skillEndTime = 0;
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_HumanOptionSkillUse(param1);
    }

    public void serializeAs_HumanOptionSkillUse(ICustomDataOutput param1) {
         super.serializeAs_HumanOption(param1);
         if(this.elementId < 0)
            throw new Exception("Forbidden value (" + this.elementId + ") on element elementId.");
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_HumanOptionSkillUse(param1);
    }

    public void deserializeAs_HumanOptionSkillUse(ICustomDataInput param1) {
         super.deserialize(param1);
         this._elementIdFunc(param1);
         this._skillIdFunc(param1);
         this._skillEndTimeFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_HumanOptionSkillUse(param1);
    }

    public void deserializeAsyncAs_HumanOptionSkillUse(FuncTree param1) {
         super.deserializeAsync(param1);
         param1.addChild(this._elementIdFunc);
         param1.addChild(this._skillIdFunc);
         param1.addChild(this._skillEndTimeFunc);
    }

    private void _elementIdFunc(ICustomDataInput param1) {
         this.elementId = param1.readVarUhInt();
         if(this.elementId < 0)
            throw new Exception("Forbidden value (" + this.elementId + ") on element of HumanOptionSkillUse.elementId.");
    }

    private void _skillIdFunc(ICustomDataInput param1) {
         this.skillId = param1.readVarUhShort();
         if(this.skillId < 0)
            throw new Exception("Forbidden value (" + this.skillId + ") on element of HumanOptionSkillUse.skillId.");
    }

    private void _skillEndTimeFunc(ICustomDataInput param1) {
         this.skillEndTime = param1.readDouble();
         if(this.skillEndTime < -9.007199254740992E15 || this.skillEndTime > 9.007199254740992E15)
            throw new Exception("Forbidden value (" + this.skillEndTime + ") on element of HumanOptionSkillUse.skillEndTime.");
    }

}