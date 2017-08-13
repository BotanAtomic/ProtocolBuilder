package package com.ankamagames.dofus.network.types.game.context.fight;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;

public class FightResultMutantListEntry extends FightResultFighterListEntry implements INetworkType {

    private int protocolId = 216;
    private int level = 0;


    public int getTypeId() {
         return 216;
    }

    public FightResultMutantListEntry initFightResultMutantListEntry(int param1,int  param2,FightLoot  param3,Number  param4,boolean  param5,int  param6) {
         super.initFightResultFighterListEntry(param1,param2,param3,param4,param5);
         this.level = param6;
         return this;
    }

    public void reset() {
         super.reset();
         this.level = 0;
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_FightResultMutantListEntry(param1);
    }

    public void serializeAs_FightResultMutantListEntry(ICustomDataOutput param1) {
         super.serializeAs_FightResultFighterListEntry(param1);
         if(this.level < 0)
            throw new Exception("Forbidden value (" + this.level + ") on element level.");
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_FightResultMutantListEntry(param1);
    }

    public void deserializeAs_FightResultMutantListEntry(ICustomDataInput param1) {
         super.deserialize(param1);
         this._levelFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_FightResultMutantListEntry(param1);
    }

    public void deserializeAsyncAs_FightResultMutantListEntry(FuncTree param1) {
         super.deserializeAsync(param1);
         param1.addChild(this._levelFunc);
    }

    private void _levelFunc(ICustomDataInput param1) {
         this.level = param1.readVarUhShort();
         if(this.level < 0)
            throw new Exception("Forbidden value (" + this.level + ") on element of FightResultMutantListEntry.level.");
    }

}