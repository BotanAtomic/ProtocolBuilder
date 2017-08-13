package com.ankamagames.dofus.network.types.game.context.fight;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class FightResultFighterListEntry extends FightResultListEntry implements INetworkType {

    private int protocolId = 189;
    private Number id = 0;
    private boolean alive = false;


    public void serialize(ICustomDataOutput param1) {
         param1.writeVarShort(this.outcome);
         if(this.wave < 0)
         {
            throw new Exception("Forbidden value (" + this.wave + ") on element wave.");
         }
         param1.writeByte(this.wave);
         this.rewards.serializeAs_FightLoot(param1);
         if(this.id < -9.007199254740992E15 || this.id > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.id + ") on element id.");
         }
         param1.writeDouble(this.id);
         param1.writeBoolean(this.alive);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_FightResultListEntry(param1);
         this.id = param1.readDouble();
         if(this.id < -9.007199254740992E15 || this.id > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.id + ") on element of FightResultFighterListEntry.id.");
         }
         this.alive = param1.readBoolean();
    }

}