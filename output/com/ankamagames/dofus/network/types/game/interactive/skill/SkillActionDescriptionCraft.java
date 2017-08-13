package package com.ankamagames.dofus.network.types.game.interactive.skill;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;

public class SkillActionDescriptionCraft extends SkillActionDescription implements INetworkType {

    private int protocolId = 100;
    private int probability = 0;


    public int getTypeId() {
         return 100;
    }

    public SkillActionDescriptionCraft initSkillActionDescriptionCraft(int param1,int  param2) {
         super.initSkillActionDescription(param1);
         this.probability = param2;
         return this;
    }

    public void reset() {
         super.reset();
         this.probability = 0;
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_SkillActionDescriptionCraft(param1);
    }

    public void serializeAs_SkillActionDescriptionCraft(ICustomDataOutput param1) {
         super.serializeAs_SkillActionDescription(param1);
         if(this.probability < 0)
            throw new Exception("Forbidden value (" + this.probability + ") on element probability.");
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_SkillActionDescriptionCraft(param1);
    }

    public void deserializeAs_SkillActionDescriptionCraft(ICustomDataInput param1) {
         super.deserialize(param1);
         this._probabilityFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_SkillActionDescriptionCraft(param1);
    }

    public void deserializeAsyncAs_SkillActionDescriptionCraft(FuncTree param1) {
         super.deserializeAsync(param1);
         param1.addChild(this._probabilityFunc);
    }

    private void _probabilityFunc(ICustomDataInput param1) {
         this.probability = param1.readByte();
         if(this.probability < 0)
            throw new Exception("Forbidden value (" + this.probability + ") on element of SkillActionDescriptionCraft.probability.");
    }

}