package com.ankamagames.dofus.network.types.game.context.fight;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class FightResultMutantListEntry extends FightResultFighterListEntry implements INetworkType {

    private int protocolId = 216;
    private int level = 0;


    public void serialize(ICustomDataOutput param1) {
         super.serializeAs_FightResultListEntry(param1);
         if(this.id < -9.007199254740992E15 || this.id > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.id + ") on element id.");
         }
         param1.writeDouble(this.id);
         param1.writeBoolean(this.alive);
         if(this.level < 0)
         {
            throw new Exception("Forbidden value (" + this.level + ") on element level.");
         }
         param1.writeVarShort(this.level);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_FightResultListEntry(param1);
         this.id = param1.readDouble();
         if(this.id < -9.007199254740992E15 || this.id > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.id + ") on element of FightResultFighterListEntry.id.");
         }
         this.alive = param1.readBoolean();
         this.level = param1.readVarUhShort();
         if(this.level < 0)
         {
            throw new Exception("Forbidden value (" + this.level + ") on element of FightResultMutantListEntry.level.");
         }
    }

}