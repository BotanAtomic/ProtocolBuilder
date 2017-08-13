package com.ankamagames.dofus.network.types.game.data.items.effects;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;

public class ObjectEffectCreature extends ObjectEffect implements INetworkType {

    private int protocolId = 71;
    private int monsterFamilyId = 0;


    public int getTypeId() {
         return 71;
    }

    public ObjectEffectCreature initObjectEffectCreature(int param1,int  param2) {
         super.initObjectEffect(param1);
         this.monsterFamilyId = param2;
         return this;
    }

    public void reset() {
         super.reset();
         this.monsterFamilyId = 0;
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_ObjectEffectCreature(param1);
    }

    public void serializeAs_ObjectEffectCreature(ICustomDataOutput param1) {
         super.serializeAs_ObjectEffect(param1);
         if(this.monsterFamilyId < 0)
         {
            throw new Exception("Forbidden value (" + this.monsterFamilyId + ") on element monsterFamilyId.");
         }
         param1.writeVarShort(this.monsterFamilyId);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_ObjectEffectCreature(param1);
    }

    public void deserializeAs_ObjectEffectCreature(ICustomDataInput param1) {
         super.deserialize(param1);
         this._monsterFamilyIdFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_ObjectEffectCreature(param1);
    }

    public void deserializeAsyncAs_ObjectEffectCreature(FuncTree param1) {
         super.deserializeAsync(param1);
         param1.addChild(this._monsterFamilyIdFunc);
    }

    private void _monsterFamilyIdFunc(ICustomDataInput param1) {
         this.monsterFamilyId = param1.readVarUhShort();
         if(this.monsterFamilyId < 0)
         {
            throw new Exception("Forbidden value (" + this.monsterFamilyId + ") on element of ObjectEffectCreature.monsterFamilyId.");
         }
    }

}