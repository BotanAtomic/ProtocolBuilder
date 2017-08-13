package com.ankamagames.dofus.network.types.game.interactive.skill;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;

public class SkillActionDescription extends Object implements INetworkType {

    private int protocolId = 102;
    private int skillId = 0;


    public int getTypeId() {
         return 102;
    }

    public SkillActionDescription initSkillActionDescription(int param1) {
         this.skillId = param1;
         return this;
    }

    public void reset() {
         this.skillId = 0;
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_SkillActionDescription(param1);
    }

    public void serializeAs_SkillActionDescription(ICustomDataOutput param1) {
         if(this.skillId < 0)
         {
            throw new Exception("Forbidden value (" + this.skillId + ") on element skillId.");
         }
         param1.writeVarShort(this.skillId);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_SkillActionDescription(param1);
    }

    public void deserializeAs_SkillActionDescription(ICustomDataInput param1) {
         this._skillIdFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_SkillActionDescription(param1);
    }

    public void deserializeAsyncAs_SkillActionDescription(FuncTree param1) {
         param1.addChild(this._skillIdFunc);
    }

    private void _skillIdFunc(ICustomDataInput param1) {
         this.skillId = param1.readVarUhShort();
         if(this.skillId < 0)
         {
            throw new Exception("Forbidden value (" + this.skillId + ") on element of SkillActionDescription.skillId.");
         }
    }

}