package com.ankamagames.dofus.network.types.game.actions.fight;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class FightTriggeredEffect extends AbstractFightDispellableEffect implements INetworkType {

    private int protocolId = 210;
    private int param1 = 0;
    private int param2 = 0;
    private int param3 = 0;
    private int delay = 0;


    public int getTypeId() {
         return 210;
    }

    public FightTriggeredEffect initFightTriggeredEffect(int param1,Number  param2,int  param3,int  param4,int  param5,int  param6,int  param7,int  param8,int  param9,int  param10,int  param11) {
         super.initAbstractFightDispellableEffect(param1,param2,param3,param4,param5,param6,param7);
         this.param1 = param8;
         this.param2 = param9;
         this.param3 = param10;
         this.delay = param11;
         return this;
    }

    public void reset() {
         super.reset();
         this.param1 = 0;
         this.param2 = 0;
         this.param3 = 0;
         this.delay = 0;
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_FightTriggeredEffect(param1);
    }

    public void serializeAs_FightTriggeredEffect(ICustomDataOutput param1) {
         super.serializeAs_AbstractFightDispellableEffect(param1);
         param1.writeInt(this.param1);
         param1.writeInt(this.param2);
         param1.writeInt(this.param3);
         param1.writeShort(this.delay);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_FightTriggeredEffect(param1);
    }

    public void deserializeAs_FightTriggeredEffect(ICustomDataInput param1) {
         super.deserialize(param1);
         this._param1Func(param1);
         this._param2Func(param1);
         this._param3Func(param1);
         this._delayFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_FightTriggeredEffect(param1);
    }

    public void deserializeAsyncAs_FightTriggeredEffect(FuncTree param1) {
         super.deserializeAsync(param1);
         param1.addChild(this._param1Func);
         param1.addChild(this._param2Func);
         param1.addChild(this._param3Func);
         param1.addChild(this._delayFunc);
    }

    private void _param1Func(ICustomDataInput param1) {
         this.param1 = param1.readInt();
    }

    private void _param2Func(ICustomDataInput param1) {
         this.param2 = param1.readInt();
    }

    private void _param3Func(ICustomDataInput param1) {
         this.param3 = param1.readInt();
    }

    private void _delayFunc(ICustomDataInput param1) {
         this.delay = param1.readShort();
    }

}