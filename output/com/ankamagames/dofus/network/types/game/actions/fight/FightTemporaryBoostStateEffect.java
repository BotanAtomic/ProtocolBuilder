package com.ankamagames.dofus.network.types.game.actions.fight;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class FightTemporaryBoostStateEffect extends FightTemporaryBoostEffect implements INetworkType {

    private int protocolId = 214;
    private int stateId = 0;


    public int getTypeId() {
         return 214;
    }

    public FightTemporaryBoostStateEffect initFightTemporaryBoostStateEffect(int param1,Number  param2,int  param3,int  param4,int  param5,int  param6,int  param7,int  param8,int  param9) {
         super.initFightTemporaryBoostEffect(param1,param2,param3,param4,param5,param6,param7,param8);
         this.stateId = param9;
         return this;
    }

    public void reset() {
         super.reset();
         this.stateId = 0;
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_FightTemporaryBoostStateEffect(param1);
    }

    public void serializeAs_FightTemporaryBoostStateEffect(ICustomDataOutput param1) {
         super.serializeAs_FightTemporaryBoostEffect(param1);
         param1.writeShort(this.stateId);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_FightTemporaryBoostStateEffect(param1);
    }

    public void deserializeAs_FightTemporaryBoostStateEffect(ICustomDataInput param1) {
         super.deserialize(param1);
         this._stateIdFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_FightTemporaryBoostStateEffect(param1);
    }

    public void deserializeAsyncAs_FightTemporaryBoostStateEffect(FuncTree param1) {
         super.deserializeAsync(param1);
         param1.addChild(this._stateIdFunc);
    }

    private void _stateIdFunc(ICustomDataInput param1) {
         this.stateId = param1.readShort();
    }

}