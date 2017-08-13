package com.ankamagames.dofus.network.types.game.achievement;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class AchievementStartedObjective extends AchievementObjective implements INetworkType {

    private int protocolId = 402;
    private int value = 0;


    public void serialize(ICustomDataOutput param1) {
         if(this.id < 0)
         {
            throw new Exception("Forbidden value (" + this.id + ") on element id.");
         }
         param1.writeVarInt(this.id);
         if(this.maxValue < 0)
         {
            throw new Exception("Forbidden value (" + this.maxValue + ") on element maxValue.");
         }
         param1.writeVarShort(this.maxValue);
         if(this.value < 0)
         {
            throw new Exception("Forbidden value (" + this.value + ") on element value.");
         }
         param1.writeVarShort(this.value);
    }

    public void deserialize(ICustomDataInput param1) {
         this.id = param1.readVarUhInt();
         if(this.id < 0)
         {
            throw new Exception("Forbidden value (" + this.id + ") on element of AchievementObjective.id.");
         }
         this.maxValue = param1.readVarUhShort();
         if(this.maxValue < 0)
         {
            throw new Exception("Forbidden value (" + this.maxValue + ") on element of AchievementObjective.maxValue.");
         }
         this.value = param1.readVarUhShort();
         if(this.value < 0)
         {
            throw new Exception("Forbidden value (" + this.value + ") on element of AchievementStartedObjective.value.");
         }
    }

}