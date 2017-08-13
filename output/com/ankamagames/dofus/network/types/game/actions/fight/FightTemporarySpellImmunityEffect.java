package package com.ankamagames.dofus.network.types.game.actions.fight;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class FightTemporarySpellImmunityEffect extends AbstractFightDispellableEffect implements INetworkType {

    private int protocolId = 366;
    private int immuneSpellId = 0;


    public int getTypeId() {
         return 366;
    }

    public FightTemporarySpellImmunityEffect initFightTemporarySpellImmunityEffect(int param1,Number  param2,int  param3,int  param4,int  param5,int  param6,int  param7,int  param8) {
         super.initAbstractFightDispellableEffect(param1,param2,param3,param4,param5,param6,param7);
         this.immuneSpellId = param8;
         return this;
    }

    public void reset() {
         super.reset();
         this.immuneSpellId = 0;
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_FightTemporarySpellImmunityEffect(param1);
    }

    public void serializeAs_FightTemporarySpellImmunityEffect(ICustomDataOutput param1) {
         super.serializeAs_AbstractFightDispellableEffect(param1);
         param1.writeInt(this.immuneSpellId);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_FightTemporarySpellImmunityEffect(param1);
    }

    public void deserializeAs_FightTemporarySpellImmunityEffect(ICustomDataInput param1) {
         super.deserialize(param1);
         this._immuneSpellIdFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_FightTemporarySpellImmunityEffect(param1);
    }

    public void deserializeAsyncAs_FightTemporarySpellImmunityEffect(FuncTree param1) {
         super.deserializeAsync(param1);
         param1.addChild(this._immuneSpellIdFunc);
    }

    private void _immuneSpellIdFunc(ICustomDataInput param1) {
         this.immuneSpellId = param1.readInt();
    }

}