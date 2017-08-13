package com.ankamagames.dofus.network.types.game.achievement;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class AchievementObjective extends Object implements INetworkType {

    private int protocolId = 404;
    private int id = 0;
    private int maxValue = 0;


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
    }

}