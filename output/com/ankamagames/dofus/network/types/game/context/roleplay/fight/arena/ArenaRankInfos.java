package com.ankamagames.dofus.network.types.game.context.roleplay.fight.arena;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class ArenaRankInfos extends Object implements INetworkType {

    private int protocolId = 499;
    private int rank = 0;
    private int bestRank = 0;
    private int victoryCount = 0;
    private int fightcount = 0;


    public void serialize(ICustomDataOutput param1) {
         if(this.rank < 0 || this.rank > 20000)
         {
            throw new Exception("Forbidden value (" + this.rank + ") on element rank.");
         }
         param1.writeVarShort(this.rank);
         if(this.bestRank < 0 || this.bestRank > 20000)
         {
            throw new Exception("Forbidden value (" + this.bestRank + ") on element bestRank.");
         }
         param1.writeVarShort(this.bestRank);
         if(this.victoryCount < 0)
         {
            throw new Exception("Forbidden value (" + this.victoryCount + ") on element victoryCount.");
         }
         param1.writeVarShort(this.victoryCount);
         if(this.fightcount < 0)
         {
            throw new Exception("Forbidden value (" + this.fightcount + ") on element fightcount.");
         }
         param1.writeVarShort(this.fightcount);
    }

    public void deserialize(ICustomDataInput param1) {
         this.rank = param1.readVarUhShort();
         if(this.rank < 0 || this.rank > 20000)
         {
            throw new Exception("Forbidden value (" + this.rank + ") on element of ArenaRankInfos.rank.");
         }
         this.bestRank = param1.readVarUhShort();
         if(this.bestRank < 0 || this.bestRank > 20000)
         {
            throw new Exception("Forbidden value (" + this.bestRank + ") on element of ArenaRankInfos.bestRank.");
         }
         this.victoryCount = param1.readVarUhShort();
         if(this.victoryCount < 0)
         {
            throw new Exception("Forbidden value (" + this.victoryCount + ") on element of ArenaRankInfos.victoryCount.");
         }
         this.fightcount = param1.readVarUhShort();
         if(this.fightcount < 0)
         {
            throw new Exception("Forbidden value (" + this.fightcount + ") on element of ArenaRankInfos.fightcount.");
         }
    }

}