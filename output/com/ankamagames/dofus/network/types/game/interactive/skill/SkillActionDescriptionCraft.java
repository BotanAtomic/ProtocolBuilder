package com.ankamagames.dofus.network.types.game.interactive.skill;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class SkillActionDescriptionCraft extends SkillActionDescription implements INetworkType {

    private int protocolId = 100;
    private int probability = 0;


    public void serialize(ICustomDataOutput param1) {
         if(this.probability < 0)
         {
            throw new Exception("Forbidden value (" + this.probability + ") on element probability.");
         }
         param1.writeByte(this.probability);
         if(this.probability < 0)
         {
            throw new Exception("Forbidden value (" + this.probability + ") on element probability.");
         }
         param1.writeByte(this.probability);
         super.serializeAs_SkillActionDescription(param1);
         if(this.probability < 0)
         {
            throw new Exception("Forbidden value (" + this.probability + ") on element probability.");
         }
         param1.writeByte(this.probability);
    }

    public void deserialize(ICustomDataInput param1) {
         this.skillId = param1.readVarUhShort();
         if(this.skillId < 0)
         {
            throw new Exception("Forbidden value (" + this.skillId + ") on element of SkillActionDescription.skillId.");
         }
         this.probability = param1.readByte();
         if(this.probability < 0)
         {
            throw new Exception("Forbidden value (" + this.probability + ") on element of SkillActionDescriptionCraft.probability.");
         }
    }

}