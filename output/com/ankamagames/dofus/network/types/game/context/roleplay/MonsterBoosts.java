package package com.ankamagames.dofus.network.types.game.context.roleplay;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;

public class MonsterBoosts extends Object implements INetworkType {

    private int protocolId = 497;
    private int id = 0;
    private int xpBoost = 0;
    private int dropBoost = 0;


    public int getTypeId() {
         return 497;
    }

    public MonsterBoosts initMonsterBoosts(int param1,int  param2,int  param3) {
         this.id = param1;
         this.xpBoost = param2;
         this.dropBoost = param3;
         return this;
    }

    public void reset() {
         this.id = 0;
         this.xpBoost = 0;
         this.dropBoost = 0;
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_MonsterBoosts(param1);
    }

    public void serializeAs_MonsterBoosts(ICustomDataOutput param1) {
         if(this.id < 0)
            throw new Exception("Forbidden value (" + this.id + ") on element id.");
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_MonsterBoosts(param1);
    }

    public void deserializeAs_MonsterBoosts(ICustomDataInput param1) {
         this._idFunc(param1);
         this._xpBoostFunc(param1);
         this._dropBoostFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_MonsterBoosts(param1);
    }

    public void deserializeAsyncAs_MonsterBoosts(FuncTree param1) {
         param1.addChild(this._idFunc);
         param1.addChild(this._xpBoostFunc);
         param1.addChild(this._dropBoostFunc);
    }

    private void _idFunc(ICustomDataInput param1) {
         this.id = param1.readVarUhInt();
         if(this.id < 0)
            throw new Exception("Forbidden value (" + this.id + ") on element of MonsterBoosts.id.");
    }

    private void _xpBoostFunc(ICustomDataInput param1) {
         this.xpBoost = param1.readVarUhShort();
         if(this.xpBoost < 0)
            throw new Exception("Forbidden value (" + this.xpBoost + ") on element of MonsterBoosts.xpBoost.");
    }

    private void _dropBoostFunc(ICustomDataInput param1) {
         this.dropBoost = param1.readVarUhShort();
         if(this.dropBoost < 0)
            throw new Exception("Forbidden value (" + this.dropBoost + ") on element of MonsterBoosts.dropBoost.");
    }

}