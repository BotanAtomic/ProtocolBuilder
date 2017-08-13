package com.ankamagames.dofus.network.types.game.data.items.effects;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class ObjectEffectString extends ObjectEffect implements INetworkType {

    private int protocolId = 74;
    private String value = "";


    public int getTypeId() {
         return 74;
    }

    public ObjectEffectString initObjectEffectString(int param1,String  param2) {
         super.initObjectEffect(param1);
         this.value = param2;
         return this;
    }

    public void reset() {
         super.reset();
         this.value = "";
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_ObjectEffectString(param1);
    }

    public void serializeAs_ObjectEffectString(ICustomDataOutput param1) {
         super.serializeAs_ObjectEffect(param1);
         param1.writeUTF(this.value);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_ObjectEffectString(param1);
    }

    public void deserializeAs_ObjectEffectString(ICustomDataInput param1) {
         super.deserialize(param1);
         this._valueFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_ObjectEffectString(param1);
    }

    public void deserializeAsyncAs_ObjectEffectString(FuncTree param1) {
         super.deserializeAsync(param1);
         param1.addChild(this._valueFunc);
    }

    private void _valueFunc(ICustomDataInput param1) {
         this.value = param1.readUTF();
    }

}