package com.ankamagames.dofus.network.types.game.actions.fight;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;

public class FightTemporarySpellBoostEffect extends FightTemporaryBoostEffect implements INetworkType {

    private int protocolId = 207;
    private int boostedSpellId = 0;


    public int getTypeId() {
         return 207;
    }

    public FightTemporarySpellBoostEffect initFightTemporarySpellBoostEffect(int param1,Number  param2,int  param3,int  param4,int  param5,int  param6,int  param7,int  param8,int  param9) {
         super.initFightTemporaryBoostEffect(param1,param2,param3,param4,param5,param6,param7,param8);
         this.boostedSpellId = param9;
         return this;
    }

    public void reset() {
         super.reset();
         this.boostedSpellId = 0;
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_FightTemporarySpellBoostEffect(param1);
    }

    public void serializeAs_FightTemporarySpellBoostEffect(ICustomDataOutput param1) {
         super.serializeAs_FightTemporaryBoostEffect(param1);
         if(this.boostedSpellId < 0)
         {
            throw new Exception("Forbidden value (" + this.boostedSpellId + ") on element boostedSpellId.");
         }
         param1.writeVarShort(this.boostedSpellId);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_FightTemporarySpellBoostEffect(param1);
    }

    public void deserializeAs_FightTemporarySpellBoostEffect(ICustomDataInput param1) {
         super.deserialize(param1);
         this._boostedSpellIdFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_FightTemporarySpellBoostEffect(param1);
    }

    public void deserializeAsyncAs_FightTemporarySpellBoostEffect(FuncTree param1) {
         super.deserializeAsync(param1);
         param1.addChild(this._boostedSpellIdFunc);
    }

    private void _boostedSpellIdFunc(ICustomDataInput param1) {
         this.boostedSpellId = param1.readVarUhShort();
         if(this.boostedSpellId < 0)
         {
            throw new Exception("Forbidden value (" + this.boostedSpellId + ") on element of FightTemporarySpellBoostEffect.boostedSpellId.");
         }
    }

}