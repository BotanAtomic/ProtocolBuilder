package com.ankamagames.dofus.network.types.game.data.items.effects;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class ObjectEffectString extends ObjectEffect implements INetworkType {

    private int protocolId = 74;
    private String value = "";


    public void serialize(ICustomDataOutput param1) {
         param1.writeUTF(this.value);
         param1.writeUTF(this.value);
         super.serializeAs_ObjectEffect(param1);
         param1.writeUTF(this.value);
    }

    public void deserialize(ICustomDataInput param1) {
         this.actionId = param1.readVarUhShort();
         if(this.actionId < 0)
         {
            throw new Exception("Forbidden value (" + this.actionId + ") on element of ObjectEffect.actionId.");
         }
         this.value = param1.readUTF();
    }

}