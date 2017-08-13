package com.ankamagames.dofus.network.types.game.data.items.effects;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class ObjectEffectMount extends ObjectEffect implements INetworkType {

    private int protocolId = 179;
    private int mountId = 0;
    private Number date = 0;
    private int modelId = 0;


    public void serialize(ICustomDataOutput param1) {
         if(this.actionId < 0)
         {
            throw new Exception("Forbidden value (" + this.actionId + ") on element actionId.");
         }
         param1.writeVarShort(this.actionId);
         if(this.mountId < 0)
         {
            throw new Exception("Forbidden value (" + this.mountId + ") on element mountId.");
         }
         param1.writeInt(this.mountId);
         if(this.date < -9.007199254740992E15 || this.date > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.date + ") on element date.");
         }
         param1.writeDouble(this.date);
         if(this.modelId < 0)
         {
            throw new Exception("Forbidden value (" + this.modelId + ") on element modelId.");
         }
         param1.writeVarShort(this.modelId);
    }

    public void deserialize(ICustomDataInput param1) {
         this.actionId = param1.readVarUhShort();
         if(this.actionId < 0)
         {
            throw new Exception("Forbidden value (" + this.actionId + ") on element of ObjectEffect.actionId.");
         }
         this.mountId = param1.readInt();
         if(this.mountId < 0)
         {
            throw new Exception("Forbidden value (" + this.mountId + ") on element of ObjectEffectMount.mountId.");
         }
         this.date = param1.readDouble();
         if(this.date < -9.007199254740992E15 || this.date > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.date + ") on element of ObjectEffectMount.date.");
         }
         this.modelId = param1.readVarUhShort();
         if(this.modelId < 0)
         {
            throw new Exception("Forbidden value (" + this.modelId + ") on element of ObjectEffectMount.modelId.");
         }
    }

}