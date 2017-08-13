package package com.ankamagames.dofus.network.types.game.context.fight;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;

public class FightResultListEntry extends Object implements INetworkType {

    private int protocolId = 16;
    private int outcome = 0;
    private int wave = 0;
    private FightLoot rewards = ;
    private FuncTree _rewardstree = ;


    public int getTypeId() {
         return 16;
    }

    public FightResultListEntry initFightResultListEntry(int param1,int  param2,FightLoot  param3) {
         this.outcome = param1;
         this.wave = param2;
         this.rewards = param3;
         return this;
    }

    public void reset() {
         this.outcome = 0;
         this.wave = 0;
         this.rewards = new FightLoot();
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_FightResultListEntry(param1);
    }

    public void serializeAs_FightResultListEntry(ICustomDataOutput param1) {
         param1.writeVarShort(this.outcome);
         if(this.wave < 0)
            throw new Exception("Forbidden value (" + this.wave + ") on element wave.");
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_FightResultListEntry(param1);
    }

    public void deserializeAs_FightResultListEntry(ICustomDataInput param1) {
         this._outcomeFunc(param1);
         this._waveFunc(param1);
         this.rewards = new FightLoot();
         this.rewards.deserialize(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_FightResultListEntry(param1);
    }

    public void deserializeAsyncAs_FightResultListEntry(FuncTree param1) {
         param1.addChild(this._outcomeFunc);
         param1.addChild(this._waveFunc);
         this._rewardstree = param1.addChild(this._rewardstreeFunc);
    }

    private void _outcomeFunc(ICustomDataInput param1) {
         this.outcome = param1.readVarUhShort();
         if(this.outcome < 0)
            throw new Exception("Forbidden value (" + this.outcome + ") on element of FightResultListEntry.outcome.");
    }

    private void _waveFunc(ICustomDataInput param1) {
         this.wave = param1.readByte();
         if(this.wave < 0)
            throw new Exception("Forbidden value (" + this.wave + ") on element of FightResultListEntry.wave.");
    }

    private void _rewardstreeFunc(ICustomDataInput param1) {
         this.rewards = new FightLoot();
         this.rewards.deserializeAsync(this._rewardstree);
    }

}