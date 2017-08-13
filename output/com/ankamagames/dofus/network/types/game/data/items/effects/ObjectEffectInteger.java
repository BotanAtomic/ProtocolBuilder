package com.ankamagames.dofus.network.types.game.data.items.effects;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class ObjectEffectInteger extends ObjectEffect implements INetworkType {

    private int protocolId = 70;
    private int value = 0;


    public void serialize(ICustomDataOutput param1) {
         if(this.actionId < 0)
         {
            throw new Exception("Forbidden value (" + this.actionId + ") on element actionId.");
         }
         param1.writeVarShort(this.actionId);
         if(this.value < 0)
         {
            throw new Exception("Forbidden value (" + this.value + ") on element value.");
         }
         param1.writeVarInt(this.value);
    }

    public void deserialize(ICustomDataInput param1) {
         this.actionId = param1.readVarUhShort();
         if(this.actionId < 0)
         {
            throw new Exception("Forbidden value (" + this.actionId + ") on element of ObjectEffect.actionId.");
         }
         this.value = param1.readVarUhInt();
         if(this.value < 0)
         {
            throw new Exception("Forbidden value (" + this.value + ") on element of ObjectEffectInteger.value.");
         }
    }

}