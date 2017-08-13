package com.ankamagames.dofus.network.types.game.context.fight;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class FightResultListEntry extends Object implements INetworkType {

    private int protocolId = 16;
    private int outcome = 0;
    private int wave = 0;
    private FightLoot rewards;
    private FuncTree _rewardstree;


    public void serialize(ICustomDataOutput param1) {
         param1.writeVarShort(this.outcome);
         if(this.wave < 0)
         {
            throw new Exception("Forbidden value (" + this.wave + ") on element wave.");
         }
         param1.writeByte(this.wave);
         this.rewards.serializeAs_FightLoot(param1);
    }

    public void deserialize(ICustomDataInput param1) {
         this.outcome = param1.readVarUhShort();
         if(this.outcome < 0)
         {
            throw new Exception("Forbidden value (" + this.outcome + ") on element of FightResultListEntry.outcome.");
         }
         this.wave = param1.readByte();
         if(this.wave < 0)
         {
            throw new Exception("Forbidden value (" + this.wave + ") on element of FightResultListEntry.wave.");
         }
         this.rewards = new FightLoot();
         this.rewards.deserialize(param1);
    }

}