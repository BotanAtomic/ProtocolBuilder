package package com.ankamagames.dofus.network.types.game.actions.fight;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class FightTemporaryBoostEffect extends AbstractFightDispellableEffect implements INetworkType {

    private int protocolId = 209;
    private int delta = 0;


    public int getTypeId() {
         return 209;
    }

    public FightTemporaryBoostEffect initFightTemporaryBoostEffect(int param1,Number  param2,int  param3,int  param4,int  param5,int  param6,int  param7,int  param8) {
         super.initAbstractFightDispellableEffect(param1,param2,param3,param4,param5,param6,param7);
         this.delta = param8;
         return this;
    }

    public void reset() {
         super.reset();
         this.delta = 0;
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_FightTemporaryBoostEffect(param1);
    }

    public void serializeAs_FightTemporaryBoostEffect(ICustomDataOutput param1) {
         super.serializeAs_AbstractFightDispellableEffect(param1);
         param1.writeShort(this.delta);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_FightTemporaryBoostEffect(param1);
    }

    public void deserializeAs_FightTemporaryBoostEffect(ICustomDataInput param1) {
         super.deserialize(param1);
         this._deltaFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_FightTemporaryBoostEffect(param1);
    }

    public void deserializeAsyncAs_FightTemporaryBoostEffect(FuncTree param1) {
         super.deserializeAsync(param1);
         param1.addChild(this._deltaFunc);
    }

    private void _deltaFunc(ICustomDataInput param1) {
         this.delta = param1.readShort();
    }

}