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
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;

public class ObjectEffectDate extends ObjectEffect implements INetworkType {

    private int protocolId = 72;
    private int year = 0;
    private int month = 0;
    private int day = 0;
    private int hour = 0;
    private int minute = 0;


    public int getTypeId() {
         return 72;
    }

    public ObjectEffectDate initObjectEffectDate(int param1,int  param2,int  param3,int  param4,int  param5,int  param6) {
         super.initObjectEffect(param1);
         this.year = param2;
         this.month = param3;
         this.day = param4;
         this.hour = param5;
         this.minute = param6;
         return this;
    }

    public void reset() {
         super.reset();
         this.year = 0;
         this.month = 0;
         this.day = 0;
         this.hour = 0;
         this.minute = 0;
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_ObjectEffectDate(param1);
    }

    public void serializeAs_ObjectEffectDate(ICustomDataOutput param1) {
         super.serializeAs_ObjectEffect(param1);
         if(this.year < 0)
         {
            throw new Exception("Forbidden value (" + this.year + ") on element year.");
         }
         param1.writeVarShort(this.year);
         if(this.month < 0)
         {
            throw new Exception("Forbidden value (" + this.month + ") on element month.");
         }
         param1.writeByte(this.month);
         if(this.day < 0)
         {
            throw new Exception("Forbidden value (" + this.day + ") on element day.");
         }
         param1.writeByte(this.day);
         if(this.hour < 0)
         {
            throw new Exception("Forbidden value (" + this.hour + ") on element hour.");
         }
         param1.writeByte(this.hour);
         if(this.minute < 0)
         {
            throw new Exception("Forbidden value (" + this.minute + ") on element minute.");
         }
         param1.writeByte(this.minute);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_ObjectEffectDate(param1);
    }

    public void deserializeAs_ObjectEffectDate(ICustomDataInput param1) {
         super.deserialize(param1);
         this._yearFunc(param1);
         this._monthFunc(param1);
         this._dayFunc(param1);
         this._hourFunc(param1);
         this._minuteFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_ObjectEffectDate(param1);
    }

    public void deserializeAsyncAs_ObjectEffectDate(FuncTree param1) {
         super.deserializeAsync(param1);
         param1.addChild(this._yearFunc);
         param1.addChild(this._monthFunc);
         param1.addChild(this._dayFunc);
         param1.addChild(this._hourFunc);
         param1.addChild(this._minuteFunc);
    }

    private void _yearFunc(ICustomDataInput param1) {
         this.year = param1.readVarUhShort();
         if(this.year < 0)
         {
            throw new Exception("Forbidden value (" + this.year + ") on element of ObjectEffectDate.year.");
         }
    }

    private void _monthFunc(ICustomDataInput param1) {
         this.month = param1.readByte();
         if(this.month < 0)
         {
            throw new Exception("Forbidden value (" + this.month + ") on element of ObjectEffectDate.month.");
         }
    }

    private void _dayFunc(ICustomDataInput param1) {
         this.day = param1.readByte();
         if(this.day < 0)
         {
            throw new Exception("Forbidden value (" + this.day + ") on element of ObjectEffectDate.day.");
         }
    }

    private void _hourFunc(ICustomDataInput param1) {
         this.hour = param1.readByte();
         if(this.hour < 0)
         {
            throw new Exception("Forbidden value (" + this.hour + ") on element of ObjectEffectDate.hour.");
         }
    }

    private void _minuteFunc(ICustomDataInput param1) {
         this.minute = param1.readByte();
         if(this.minute < 0)
         {
            throw new Exception("Forbidden value (" + this.minute + ") on element of ObjectEffectDate.minute.");
         }
    }

}