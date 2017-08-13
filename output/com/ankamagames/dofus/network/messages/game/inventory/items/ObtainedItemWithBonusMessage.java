package com.ankamagames.dofus.network.messages.game.inventory.items;

import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class ObtainedItemWithBonusMessage extends ObtainedItemMessage implements INetworkMessage {

    private int protocolId = 6520;
    private boolean _isInitialized = false;
    private int bonusQuantity = 0;


    public void serialize(ICustomDataOutput param1) {
         super.serializeAs_ObtainedItemMessage(param1);
         if(this.bonusQuantity < 0)
         {
            throw new Exception("Forbidden value (" + this.bonusQuantity + ") on element bonusQuantity.");
         }
         param1.writeVarInt(this.bonusQuantity);
    }

    public void deserialize(ICustomDataInput param1) {
         this.genericId = param1.readVarUhShort();
         if(this.genericId < 0)
         {
            throw new Exception("Forbidden value (" + this.genericId + ") on element of ObtainedItemMessage.genericId.");
         }
         this.baseQuantity = param1.readVarUhInt();
         if(this.baseQuantity < 0)
         {
            throw new Exception("Forbidden value (" + this.baseQuantity + ") on element of ObtainedItemMessage.baseQuantity.");
         }
         this.bonusQuantity = param1.readVarUhInt();
         if(this.bonusQuantity < 0)
         {
            throw new Exception("Forbidden value (" + this.bonusQuantity + ") on element of ObtainedItemWithBonusMessage.bonusQuantity.");
         }
    }

}