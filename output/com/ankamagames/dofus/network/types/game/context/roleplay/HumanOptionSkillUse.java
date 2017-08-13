package com.ankamagames.dofus.network.types.game.context.roleplay;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class HumanOptionSkillUse extends HumanOption implements INetworkType {

    private int protocolId = 495;
    private int elementId = 0;
    private int skillId = 0;
    private Number skillEndTime = 0;


    public void serialize(ICustomDataOutput param1) {
         if(this.elementId < 0)
         {
            throw new Exception("Forbidden value (" + this.elementId + ") on element elementId.");
         }
         param1.writeVarInt(this.elementId);
         if(this.skillId < 0)
         {
            throw new Exception("Forbidden value (" + this.skillId + ") on element skillId.");
         }
         param1.writeVarShort(this.skillId);
         if(this.skillEndTime < -9.007199254740992E15 || this.skillEndTime > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.skillEndTime + ") on element skillEndTime.");
         }
         param1.writeDouble(this.skillEndTime);
         if(this.elementId < 0)
         {
            throw new Exception("Forbidden value (" + this.elementId + ") on element elementId.");
         }
         param1.writeVarInt(this.elementId);
         if(this.skillId < 0)
         {
            throw new Exception("Forbidden value (" + this.skillId + ") on element skillId.");
         }
         param1.writeVarShort(this.skillId);
         if(this.skillEndTime < -9.007199254740992E15 || this.skillEndTime > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.skillEndTime + ") on element skillEndTime.");
         }
         param1.writeDouble(this.skillEndTime);
         super.serializeAs_HumanOption(param1);
         if(this.elementId < 0)
         {
            throw new Exception("Forbidden value (" + this.elementId + ") on element elementId.");
         }
         param1.writeVarInt(this.elementId);
         if(this.skillId < 0)
         {
            throw new Exception("Forbidden value (" + this.skillId + ") on element skillId.");
         }
         param1.writeVarShort(this.skillId);
         if(this.skillEndTime < -9.007199254740992E15 || this.skillEndTime > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.skillEndTime + ") on element skillEndTime.");
         }
         param1.writeDouble(this.skillEndTime);
    }

    public void deserialize(ICustomDataInput param1) {
         this.elementId = param1.readVarUhInt();
         if(this.elementId < 0)
         {
            throw new Exception("Forbidden value (" + this.elementId + ") on element of HumanOptionSkillUse.elementId.");
         }
         this.skillId = param1.readVarUhShort();
         if(this.skillId < 0)
         {
            throw new Exception("Forbidden value (" + this.skillId + ") on element of HumanOptionSkillUse.skillId.");
         }
         this.skillEndTime = param1.readDouble();
         if(this.skillEndTime < -9.007199254740992E15 || this.skillEndTime > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.skillEndTime + ") on element of HumanOptionSkillUse.skillEndTime.");
         }
    }

}