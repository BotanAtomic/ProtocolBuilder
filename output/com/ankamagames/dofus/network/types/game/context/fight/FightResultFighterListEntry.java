package com.ankamagames.dofus.network.types.game.context.fight;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;

public class FightResultFighterListEntry extends FightResultListEntry implements INetworkType {

    private int protocolId = 189;
    private Number id = 0;
    private boolean alive = false;


    public int getTypeId() {
         return 189;
    }

    public FightResultFighterListEntry initFightResultFighterListEntry(int param1,int  param2,FightLoot  param3,Number  param4,boolean  param5) {
         super.initFightResultListEntry(param1,param2,param3);
         this.id = param4;
         this.alive = param5;
         return this;
    }

    public void reset() {
         super.reset();
         this.id = 0;
         this.alive = false;
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_FightResultFighterListEntry(param1);
    }

    public void serializeAs_FightResultFighterListEntry(ICustomDataOutput param1) {
         super.serializeAs_FightResultListEntry(param1);
         if(this.id < -9.007199254740992E15 || this.id > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.id + ") on element id.");
         }
         param1.writeDouble(this.id);
         param1.writeBoolean(this.alive);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_FightResultFighterListEntry(param1);
    }

    public void deserializeAs_FightResultFighterListEntry(ICustomDataInput param1) {
         super.deserialize(param1);
         this._idFunc(param1);
         this._aliveFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_FightResultFighterListEntry(param1);
    }

    public void deserializeAsyncAs_FightResultFighterListEntry(FuncTree param1) {
         super.deserializeAsync(param1);
         param1.addChild(this._idFunc);
         param1.addChild(this._aliveFunc);
    }

    private void _idFunc(ICustomDataInput param1) {
         this.id = param1.readDouble();
         if(this.id < -9.007199254740992E15 || this.id > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.id + ") on element of FightResultFighterListEntry.id.");
         }
    }

    private void _aliveFunc(ICustomDataInput param1) {
         this.alive = param1.readBoolean();
    }

}