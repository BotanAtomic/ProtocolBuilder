package com.ankamagames.dofus.network.types.game.achievement;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class AchievementRewardable extends Object implements INetworkType {

    private int protocolId = 412;
    private int id = 0;
    private int finishedlevel = 0;


    public void serialize(ICustomDataOutput param1) {
         if(this.id < 0)
         {
            throw new Exception("Forbidden value (" + this.id + ") on element id.");
         }
         param1.writeVarShort(this.id);
         if(this.finishedlevel < 0 || this.finishedlevel > 206)
         {
            throw new Exception("Forbidden value (" + this.finishedlevel + ") on element finishedlevel.");
         }
         param1.writeByte(this.finishedlevel);
    }

    public void deserialize(ICustomDataInput param1) {
         this.id = param1.readVarUhShort();
         if(this.id < 0)
         {
            throw new Exception("Forbidden value (" + this.id + ") on element of AchievementRewardable.id.");
         }
         this.finishedlevel = param1.readUnsignedByte();
         if(this.finishedlevel < 0 || this.finishedlevel > 206)
         {
            throw new Exception("Forbidden value (" + this.finishedlevel + ") on element of AchievementRewardable.finishedlevel.");
         }
    }

}