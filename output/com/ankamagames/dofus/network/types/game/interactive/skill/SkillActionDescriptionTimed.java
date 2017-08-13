package com.ankamagames.dofus.network.types.game.interactive.skill;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class SkillActionDescriptionTimed extends SkillActionDescription implements INetworkType {

    private int protocolId = 103;
    private int time = 0;


    public void serialize(ICustomDataOutput param1) {
         if(this.time < 0 || this.time > 255)
         {
            throw new Exception("Forbidden value (" + this.time + ") on element time.");
         }
         param1.writeByte(this.time);
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
    }

    public void deserialize(ICustomDataInput param1) {
         this.skillId = param1.readVarUhShort();
         if(this.skillId < 0)
         {
            throw new Exception("Forbidden value (" + this.skillId + ") on element of SkillActionDescription.skillId.");
         }
         this.time = param1.readUnsignedByte();
         if(this.time < 0 || this.time > 255)
         {
            throw new Exception("Forbidden value (" + this.time + ") on element of SkillActionDescriptionTimed.time.");
         }
    }

}