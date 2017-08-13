package com.ankamagames.dofus.network.types.game.data.items.effects;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;

public class ObjectEffectMount extends ObjectEffect implements INetworkType {

    private int protocolId = 179;
    private int mountId = 0;
    private Number date = 0;
    private int modelId = 0;


    public int getTypeId() {
         return 179;
    }

    public ObjectEffectMount initObjectEffectMount(int param1,int  param2,Number  param3,int  param4) {
         super.initObjectEffect(param1);
         this.mountId = param2;
         this.date = param3;
         this.modelId = param4;
         return this;
    }

    public void reset() {
         super.reset();
         this.mountId = 0;
         this.date = 0;
         this.modelId = 0;
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_ObjectEffectMount(param1);
    }

    public void serializeAs_ObjectEffectMount(ICustomDataOutput param1) {
         super.serializeAs_ObjectEffect(param1);
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
         this.deserializeAs_ObjectEffectMount(param1);
    }

    public void deserializeAs_ObjectEffectMount(ICustomDataInput param1) {
         super.deserialize(param1);
         this._mountIdFunc(param1);
         this._dateFunc(param1);
         this._modelIdFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_ObjectEffectMount(param1);
    }

    public void deserializeAsyncAs_ObjectEffectMount(FuncTree param1) {
         super.deserializeAsync(param1);
         param1.addChild(this._mountIdFunc);
         param1.addChild(this._dateFunc);
         param1.addChild(this._modelIdFunc);
    }

    private void _mountIdFunc(ICustomDataInput param1) {
         this.mountId = param1.readInt();
         if(this.mountId < 0)
         {
            throw new Exception("Forbidden value (" + this.mountId + ") on element of ObjectEffectMount.mountId.");
         }
    }

    private void _dateFunc(ICustomDataInput param1) {
         this.date = param1.readDouble();
         if(this.date < -9.007199254740992E15 || this.date > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.date + ") on element of ObjectEffectMount.date.");
         }
    }

    private void _modelIdFunc(ICustomDataInput param1) {
         this.modelId = param1.readVarUhShort();
         if(this.modelId < 0)
         {
            throw new Exception("Forbidden value (" + this.modelId + ") on element of ObjectEffectMount.modelId.");
         }
    }

}