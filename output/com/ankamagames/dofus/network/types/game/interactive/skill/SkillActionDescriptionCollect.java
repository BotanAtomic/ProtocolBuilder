package com.ankamagames.dofus.network.types.game.interactive.skill;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class SkillActionDescriptionCollect extends SkillActionDescriptionTimed implements INetworkType {

    private int protocolId = 99;
    private int min = 0;
    private int max = 0;


    public void serialize(ICustomDataOutput param1) {
         if(this.time < 0 || this.time > 255)
         {
            throw new Exception("Forbidden value (" + this.time + ") on element time.");
         }
         param1.writeByte(this.time);
         super.serializeAs_SkillActionDescription(param1);
         if(this.time < 0 || this.time > 255)
         {
            throw new Exception("Forbidden value (" + this.time + ") on element time.");
         }
         param1.writeByte(this.time);
         if(this.min < 0)
         {
            throw new Exception("Forbidden value (" + this.min + ") on element min.");
         }
         param1.writeVarShort(this.min);
         if(this.max < 0)
         {
            throw new Exception("Forbidden value (" + this.max + ") on element max.");
         }
         param1.writeVarShort(this.max);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_SkillActionDescriptionTimed(param1);
         this.min = param1.readVarUhShort();
         if(this.min < 0)
         {
            throw new Exception("Forbidden value (" + this.min + ") on element of SkillActionDescriptionCollect.min.");
         }
         this.max = param1.readVarUhShort();
         if(this.max < 0)
         {
            throw new Exception("Forbidden value (" + this.max + ") on element of SkillActionDescriptionCollect.max.");
         }
    }

}