package com.ankamagames.dofus.network.types.game.context.roleplay.fight.arena;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;

public class ArenaRankInfos extends Object implements INetworkType {

    private int protocolId = 499;
    private int rank = 0;
    private int bestRank = 0;
    private int victoryCount = 0;
    private int fightcount = 0;


    public int getTypeId() {
         return 499;
    }

    public ArenaRankInfos initArenaRankInfos(int param1,int  param2,int  param3,int  param4) {
         this.rank = param1;
         this.bestRank = param2;
         this.victoryCount = param3;
         this.fightcount = param4;
         return this;
    }

    public void reset() {
         this.rank = 0;
         this.bestRank = 0;
         this.victoryCount = 0;
         this.fightcount = 0;
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_ArenaRankInfos(param1);
    }

    public void serializeAs_ArenaRankInfos(ICustomDataOutput param1) {
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
         this.deserializeAs_ArenaRankInfos(param1);
    }

    public void deserializeAs_ArenaRankInfos(ICustomDataInput param1) {
         this._rankFunc(param1);
         this._bestRankFunc(param1);
         this._victoryCountFunc(param1);
         this._fightcountFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_ArenaRankInfos(param1);
    }

    public void deserializeAsyncAs_ArenaRankInfos(FuncTree param1) {
         param1.addChild(this._rankFunc);
         param1.addChild(this._bestRankFunc);
         param1.addChild(this._victoryCountFunc);
         param1.addChild(this._fightcountFunc);
    }

    private void _rankFunc(ICustomDataInput param1) {
         this.rank = param1.readVarUhShort();
         if(this.rank < 0 || this.rank > 20000)
         {
            throw new Exception("Forbidden value (" + this.rank + ") on element of ArenaRankInfos.rank.");
         }
    }

    private void _bestRankFunc(ICustomDataInput param1) {
         this.bestRank = param1.readVarUhShort();
         if(this.bestRank < 0 || this.bestRank > 20000)
         {
            throw new Exception("Forbidden value (" + this.bestRank + ") on element of ArenaRankInfos.bestRank.");
         }
    }

    private void _victoryCountFunc(ICustomDataInput param1) {
         this.victoryCount = param1.readVarUhShort();
         if(this.victoryCount < 0)
         {
            throw new Exception("Forbidden value (" + this.victoryCount + ") on element of ArenaRankInfos.victoryCount.");
         }
    }

    private void _fightcountFunc(ICustomDataInput param1) {
         this.fightcount = param1.readVarUhShort();
         if(this.fightcount < 0)
         {
            throw new Exception("Forbidden value (" + this.fightcount + ") on element of ArenaRankInfos.fightcount.");
         }
    }

}