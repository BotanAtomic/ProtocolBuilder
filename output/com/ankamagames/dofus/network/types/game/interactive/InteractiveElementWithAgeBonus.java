package com.ankamagames.dofus.network.types.game.interactive;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;

public class InteractiveElementWithAgeBonus extends InteractiveElement implements INetworkType {

    private int protocolId = 398;
    private int ageBonus = 0;


    public int getTypeId() {
         return 398;
    }

    public InteractiveElementWithAgeBonus initInteractiveElementWithAgeBonus(int param1,int  param2,Vector<InteractiveElementSkill>  param3,Vector<InteractiveElementSkill>  param4,boolean  param5,int  param6) {
         super.initInteractiveElement(param1,param2,param3,param4,param5);
         this.ageBonus = param6;
         return this;
    }

    public void reset() {
         super.reset();
         this.ageBonus = 0;
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_InteractiveElementWithAgeBonus(param1);
    }

    public void serializeAs_InteractiveElementWithAgeBonus(ICustomDataOutput param1) {
         super.serializeAs_InteractiveElement(param1);
         if(this.ageBonus < -1 || this.ageBonus > 1000)
         {
            throw new Exception("Forbidden value (" + this.ageBonus + ") on element ageBonus.");
         }
         param1.writeShort(this.ageBonus);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_InteractiveElementWithAgeBonus(param1);
    }

    public void deserializeAs_InteractiveElementWithAgeBonus(ICustomDataInput param1) {
         super.deserialize(param1);
         this._ageBonusFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_InteractiveElementWithAgeBonus(param1);
    }

    public void deserializeAsyncAs_InteractiveElementWithAgeBonus(FuncTree param1) {
         super.deserializeAsync(param1);
         param1.addChild(this._ageBonusFunc);
    }

    private void _ageBonusFunc(ICustomDataInput param1) {
         this.ageBonus = param1.readShort();
         if(this.ageBonus < -1 || this.ageBonus > 1000)
         {
            throw new Exception("Forbidden value (" + this.ageBonus + ") on element of InteractiveElementWithAgeBonus.ageBonus.");
         }
    }

}