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

public class ObjectEffectDuration extends ObjectEffect implements INetworkType {

    private int protocolId = 75;
    private int days = 0;
    private int hours = 0;
    private int minutes = 0;


    public int getTypeId() {
         return 75;
    }

    public ObjectEffectDuration initObjectEffectDuration(int param1,int  param2,int  param3,int  param4) {
         super.initObjectEffect(param1);
         this.days = param2;
         this.hours = param3;
         this.minutes = param4;
         return this;
    }

    public void reset() {
         super.reset();
         this.days = 0;
         this.hours = 0;
         this.minutes = 0;
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_ObjectEffectDuration(param1);
    }

    public void serializeAs_ObjectEffectDuration(ICustomDataOutput param1) {
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
         this.deserializeAs_ObjectEffectDuration(param1);
    }

    public void deserializeAs_ObjectEffectDuration(ICustomDataInput param1) {
         super.deserialize(param1);
         this._daysFunc(param1);
         this._hoursFunc(param1);
         this._minutesFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_ObjectEffectDuration(param1);
    }

    public void deserializeAsyncAs_ObjectEffectDuration(FuncTree param1) {
         super.deserializeAsync(param1);
         param1.addChild(this._daysFunc);
         param1.addChild(this._hoursFunc);
         param1.addChild(this._minutesFunc);
    }

    private void _daysFunc(ICustomDataInput param1) {
         this.days = param1.readVarUhShort();
         if(this.days < 0)
         {
            throw new Exception("Forbidden value (" + this.days + ") on element of ObjectEffectDuration.days.");
         }
    }

    private void _hoursFunc(ICustomDataInput param1) {
         this.hours = param1.readByte();
         if(this.hours < 0)
         {
            throw new Exception("Forbidden value (" + this.hours + ") on element of ObjectEffectDuration.hours.");
         }
    }

    private void _minutesFunc(ICustomDataInput param1) {
         this.minutes = param1.readByte();
         if(this.minutes < 0)
         {
            throw new Exception("Forbidden value (" + this.minutes + ") on element of ObjectEffectDuration.minutes.");
         }
    }

}