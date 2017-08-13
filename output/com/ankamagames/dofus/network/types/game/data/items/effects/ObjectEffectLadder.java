package com.ankamagames.dofus.network.types.game.data.items.effects;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class ObjectEffectLadder extends ObjectEffectCreature implements INetworkType {

    private int protocolId = 81;
    private int monsterCount = 0;


    public void serialize(ICustomDataOutput param1) {
         super.serializeAs_ObjectEffectCreature(param1);
         if(this.monsterCount < 0)
         {
            throw new Exception("Forbidden value (" + this.monsterCount + ") on element monsterCount.");
         }
         param1.writeVarInt(this.monsterCount);
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
         this.monsterCount = param1.readVarUhInt();
         if(this.monsterCount < 0)
         {
            throw new Exception("Forbidden value (" + this.monsterCount + ") on element of ObjectEffectLadder.monsterCount.");
         }
    }

}