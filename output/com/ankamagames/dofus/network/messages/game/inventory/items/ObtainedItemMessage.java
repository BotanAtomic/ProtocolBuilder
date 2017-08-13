package com.ankamagames.dofus.network.messages.game.inventory.items;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class ObtainedItemMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6519;
    private boolean _isInitialized = false;
    private int genericId = 0;
    private int baseQuantity = 0;


    public void serialize(ICustomDataOutput param1) {
         if(this.genericId < 0)
         {
            throw new Exception("Forbidden value (" + this.genericId + ") on element genericId.");
         }
         param1.writeVarShort(this.genericId);
         if(this.baseQuantity < 0)
         {
            throw new Exception("Forbidden value (" + this.baseQuantity + ") on element baseQuantity.");
         }
         param1.writeVarInt(this.baseQuantity);
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
    }

}