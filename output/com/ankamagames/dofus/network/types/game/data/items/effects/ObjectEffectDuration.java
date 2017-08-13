package com.ankamagames.dofus.network.types.game.data.items.effects;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class ObjectEffectDuration extends ObjectEffect implements INetworkType {

    private int protocolId = 75;
    private int days = 0;
    private int hours = 0;
    private int minutes = 0;


    public void serialize(ICustomDataOutput param1) {
         if(this.days < 0)
         {
            throw new Exception("Forbidden value (" + this.days + ") on element days.");
         }
         param1.writeVarShort(this.days);
         if(this.hours < 0)
         {
            throw new Exception("Forbidden value (" + this.hours + ") on element hours.");
         }
         param1.writeByte(this.hours);
         if(this.minutes < 0)
         {
            throw new Exception("Forbidden value (" + this.minutes + ") on element minutes.");
         }
         param1.writeByte(this.minutes);
         if(this.days < 0)
         {
            throw new Exception("Forbidden value (" + this.days + ") on element days.");
         }
         param1.writeVarShort(this.days);
         if(this.hours < 0)
         {
            throw new Exception("Forbidden value (" + this.hours + ") on element hours.");
         }
         param1.writeByte(this.hours);
         if(this.minutes < 0)
         {
            throw new Exception("Forbidden value (" + this.minutes + ") on element minutes.");
         }
         param1.writeByte(this.minutes);
         super.serializeAs_ObjectEffect(param1);
         if(this.days < 0)
         {
            throw new Exception("Forbidden value (" + this.days + ") on element days.");
         }
         param1.writeVarShort(this.days);
         if(this.hours < 0)
         {
            throw new Exception("Forbidden value (" + this.hours + ") on element hours.");
         }
         param1.writeByte(this.hours);
         if(this.minutes < 0)
         {
            throw new Exception("Forbidden value (" + this.minutes + ") on element minutes.");
         }
         param1.writeByte(this.minutes);
    }

    public void deserialize(ICustomDataInput param1) {
         this.actionId = param1.readVarUhShort();
         if(this.actionId < 0)
         {
            throw new Exception("Forbidden value (" + this.actionId + ") on element of ObjectEffect.actionId.");
         }
         this.days = param1.readVarUhShort();
         if(this.days < 0)
         {
            throw new Exception("Forbidden value (" + this.days + ") on element of ObjectEffectDuration.days.");
         }
         this.hours = param1.readByte();
         if(this.hours < 0)
         {
            throw new Exception("Forbidden value (" + this.hours + ") on element of ObjectEffectDuration.hours.");
         }
         this.minutes = param1.readByte();
         if(this.minutes < 0)
         {
            throw new Exception("Forbidden value (" + this.minutes + ") on element of ObjectEffectDuration.minutes.");
         }
    }

}