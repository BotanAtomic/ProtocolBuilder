package package com.ankamagames.dofus.network.types.game.data.items.effects;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;

public class ObjectEffectMinMax extends ObjectEffect implements INetworkType {

    private int protocolId = 82;
    private int min = 0;
    private int max = 0;


    public int getTypeId() {
         return 82;
    }

    public ObjectEffectMinMax initObjectEffectMinMax(int param1,int  param2,int  param3) {
         super.initObjectEffect(param1);
         this.min = param2;
         this.max = param3;
         return this;
    }

    public void reset() {
         super.reset();
         this.min = 0;
         this.max = 0;
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_ObjectEffectMinMax(param1);
    }

    public void serializeAs_ObjectEffectMinMax(ICustomDataOutput param1) {
         super.serializeAs_ObjectEffect(param1);
         if(this.min < 0)
            throw new Exception("Forbidden value (" + this.min + ") on element min.");
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_ObjectEffectMinMax(param1);
    }

    public void deserializeAs_ObjectEffectMinMax(ICustomDataInput param1) {
         super.deserialize(param1);
         this._minFunc(param1);
         this._maxFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_ObjectEffectMinMax(param1);
    }

    public void deserializeAsyncAs_ObjectEffectMinMax(FuncTree param1) {
         super.deserializeAsync(param1);
         param1.addChild(this._minFunc);
         param1.addChild(this._maxFunc);
    }

    private void _minFunc(ICustomDataInput param1) {
         this.min = param1.readVarUhInt();
         if(this.min < 0)
            throw new Exception("Forbidden value (" + this.min + ") on element of ObjectEffectMinMax.min.");
    }

    private void _maxFunc(ICustomDataInput param1) {
         this.max = param1.readVarUhInt();
         if(this.max < 0)
            throw new Exception("Forbidden value (" + this.max + ") on element of ObjectEffectMinMax.max.");
    }

}