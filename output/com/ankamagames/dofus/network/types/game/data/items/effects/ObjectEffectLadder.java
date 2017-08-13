package package com.ankamagames.dofus.network.types.game.data.items.effects;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;

public class ObjectEffectLadder extends ObjectEffectCreature implements INetworkType {

    private int protocolId = 81;
    private int monsterCount = 0;


    public int getTypeId() {
         return 81;
    }

    public ObjectEffectLadder initObjectEffectLadder(int param1,int  param2,int  param3) {
         super.initObjectEffectCreature(param1,param2);
         this.monsterCount = param3;
         return this;
    }

    public void reset() {
         super.reset();
         this.monsterCount = 0;
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_ObjectEffectLadder(param1);
    }

    public void serializeAs_ObjectEffectLadder(ICustomDataOutput param1) {
         super.serializeAs_ObjectEffectCreature(param1);
         if(this.monsterCount < 0)
            throw new Exception("Forbidden value (" + this.monsterCount + ") on element monsterCount.");
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_ObjectEffectLadder(param1);
    }

    public void deserializeAs_ObjectEffectLadder(ICustomDataInput param1) {
         super.deserialize(param1);
         this._monsterCountFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_ObjectEffectLadder(param1);
    }

    public void deserializeAsyncAs_ObjectEffectLadder(FuncTree param1) {
         super.deserializeAsync(param1);
         param1.addChild(this._monsterCountFunc);
    }

    private void _monsterCountFunc(ICustomDataInput param1) {
         this.monsterCount = param1.readVarUhInt();
         if(this.monsterCount < 0)
            throw new Exception("Forbidden value (" + this.monsterCount + ") on element of ObjectEffectLadder.monsterCount.");
    }

}