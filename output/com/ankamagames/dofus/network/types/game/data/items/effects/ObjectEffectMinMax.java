package com.ankamagames.dofus.network.types.game.data.items.effects;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class ObjectEffectMinMax extends ObjectEffect implements INetworkType {

    private int protocolId = 82;
    private int min = 0;
    private int max = 0;


    public void serialize(ICustomDataOutput param1) {
         if(this.actionId < 0)
         {
            throw new Exception("Forbidden value (" + this.actionId + ") on element actionId.");
         }
         param1.writeVarShort(this.actionId);
         if(this.min < 0)
         {
            throw new Exception("Forbidden value (" + this.min + ") on element min.");
         }
         param1.writeVarInt(this.min);
         if(this.max < 0)
         {
            throw new Exception("Forbidden value (" + this.max + ") on element max.");
         }
         param1.writeVarInt(this.max);
    }

    public void deserialize(ICustomDataInput param1) {
         this.actionId = param1.readVarUhShort();
         if(this.actionId < 0)
         {
            throw new Exception("Forbidden value (" + this.actionId + ") on element of ObjectEffect.actionId.");
         }
         this.min = param1.readVarUhInt();
         if(this.min < 0)
         {
            throw new Exception("Forbidden value (" + this.min + ") on element of ObjectEffectMinMax.min.");
         }
         this.max = param1.readVarUhInt();
         if(this.max < 0)
         {
            throw new Exception("Forbidden value (" + this.max + ") on element of ObjectEffectMinMax.max.");
         }
    }

}