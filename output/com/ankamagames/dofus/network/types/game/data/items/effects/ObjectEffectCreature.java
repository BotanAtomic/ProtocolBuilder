package com.ankamagames.dofus.network.types.game.data.items.effects;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class ObjectEffectCreature extends ObjectEffect implements INetworkType {

    private int protocolId = 71;
    private int monsterFamilyId = 0;


    public void serialize(ICustomDataOutput param1) {
         if(this.actionId < 0)
         {
            throw new Exception("Forbidden value (" + this.actionId + ") on element actionId.");
         }
         param1.writeVarShort(this.actionId);
         if(this.monsterFamilyId < 0)
         {
            throw new Exception("Forbidden value (" + this.monsterFamilyId + ") on element monsterFamilyId.");
         }
         param1.writeVarShort(this.monsterFamilyId);
    }

    public void deserialize(ICustomDataInput param1) {
         this.actionId = param1.readVarUhShort();
         if(this.actionId < 0)
         {
            throw new Exception("Forbidden value (" + this.actionId + ") on element of ObjectEffect.actionId.");
         }
         this.monsterFamilyId = param1.readVarUhShort();
         if(this.monsterFamilyId < 0)
         {
            throw new Exception("Forbidden value (" + this.monsterFamilyId + ") on element of ObjectEffectCreature.monsterFamilyId.");
         }
    }

}