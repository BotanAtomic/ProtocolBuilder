package com.ankamagames.dofus.network.messages.game.inventory.items;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class InventoryWeightMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 3009;
    private boolean _isInitialized = false;
    private int weight = 0;
    private int weightMax = 0;


    public void serialize(ICustomDataOutput param1) {
         if(this.weight < 0)
         {
            throw new Exception("Forbidden value (" + this.weight + ") on element weight.");
         }
         param1.writeVarInt(this.weight);
         if(this.weightMax < 0)
         {
            throw new Exception("Forbidden value (" + this.weightMax + ") on element weightMax.");
         }
         param1.writeVarInt(this.weightMax);
    }

    public void deserialize(ICustomDataInput param1) {
         this.weight = param1.readVarUhInt();
         if(this.weight < 0)
         {
            throw new Exception("Forbidden value (" + this.weight + ") on element of InventoryWeightMessage.weight.");
         }
         this.weightMax = param1.readVarUhInt();
         if(this.weightMax < 0)
         {
            throw new Exception("Forbidden value (" + this.weightMax + ") on element of InventoryWeightMessage.weightMax.");
         }
    }

}