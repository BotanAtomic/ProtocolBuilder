package com.ankamagames.dofus.network.types.game.interactive;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class InteractiveElementWithAgeBonus extends InteractiveElement implements INetworkType {

    private int protocolId = 398;
    private int ageBonus = 0;


    public void serialize(ICustomDataOutput param1) {
         this.interactiveElement.serializeAs_InteractiveElement(param1);
         if(this.ageBonus < -1 || this.ageBonus > 1000)
         {
            throw new Exception("Forbidden value (" + this.ageBonus + ") on element ageBonus.");
         }
         param1.writeShort(this.ageBonus);
    }

    public void deserialize(ICustomDataInput param1) {
         this.interactiveElement = new InteractiveElement();
         this.interactiveElement.deserialize(param1);
         this.ageBonus = param1.readShort();
         if(this.ageBonus < -1 || this.ageBonus > 1000)
         {
            throw new Exception("Forbidden value (" + this.ageBonus + ") on element of InteractiveElementWithAgeBonus.ageBonus.");
         }
    }

}