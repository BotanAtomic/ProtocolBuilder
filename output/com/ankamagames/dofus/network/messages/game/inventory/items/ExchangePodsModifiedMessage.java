package com.ankamagames.dofus.network.messages.game.inventory.items;

import com.ankamagames.dofus.network.messages.game.inventory.exchanges.ExchangeObjectMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class ExchangePodsModifiedMessage extends ExchangeObjectMessage implements INetworkMessage {

    private int protocolId = 6670;
    private boolean _isInitialized = false;
    private int currentWeight = 0;
    private int maxWeight = 0;


    public void serialize(ICustomDataOutput param1) {
         param1.writeBoolean(this.remote);
         if(this.currentWeight < 0)
         {
            throw new Exception("Forbidden value (" + this.currentWeight + ") on element currentWeight.");
         }
         param1.writeVarInt(this.currentWeight);
         if(this.maxWeight < 0)
         {
            throw new Exception("Forbidden value (" + this.maxWeight + ") on element maxWeight.");
         }
         param1.writeVarInt(this.maxWeight);
    }

    public void deserialize(ICustomDataInput param1) {
         this.remote = param1.readBoolean();
         this.currentWeight = param1.readVarUhInt();
         if(this.currentWeight < 0)
         {
            throw new Exception("Forbidden value (" + this.currentWeight + ") on element of ExchangePodsModifiedMessage.currentWeight.");
         }
         this.maxWeight = param1.readVarUhInt();
         if(this.maxWeight < 0)
         {
            throw new Exception("Forbidden value (" + this.maxWeight + ") on element of ExchangePodsModifiedMessage.maxWeight.");
         }
    }

}