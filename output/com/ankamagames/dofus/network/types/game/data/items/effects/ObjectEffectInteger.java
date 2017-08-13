package com.ankamagames.dofus.network.types.game.data.items.effects;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;

public class ObjectEffectInteger extends ObjectEffect implements INetworkType {

    private int protocolId = 70;
    private int value = 0;


    public int getTypeId() {
         return 70;
    }

    public ObjectEffectInteger initObjectEffectInteger(int param1,int  param2) {
         super.initObjectEffect(param1);
         this.value = param2;
         return this;
    }

    public void reset() {
         super.reset();
         this.value = 0;
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_ObjectEffectInteger(param1);
    }

    public void serializeAs_ObjectEffectInteger(ICustomDataOutput param1) {
         super.serializeAs_ObjectEffect(param1);
         if(this.value < 0)
         {
            throw new Exception("Forbidden value (" + this.value + ") on element value.");
         }
         param1.writeVarInt(this.value);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_ObjectEffectInteger(param1);
    }

    public void deserializeAs_ObjectEffectInteger(ICustomDataInput param1) {
         super.deserialize(param1);
         this._valueFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_ObjectEffectInteger(param1);
    }

    public void deserializeAsyncAs_ObjectEffectInteger(FuncTree param1) {
         super.deserializeAsync(param1);
         param1.addChild(this._valueFunc);
    }

    private void _valueFunc(ICustomDataInput param1) {
         this.value = param1.readVarUhInt();
         if(this.value < 0)
         {
            throw new Exception("Forbidden value (" + this.value + ") on element of ObjectEffectInteger.value.");
         }
    }

}