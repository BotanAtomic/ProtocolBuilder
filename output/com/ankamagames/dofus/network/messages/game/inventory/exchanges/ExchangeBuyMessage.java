package com.ankamagames.dofus.network.messages.game.inventory.exchanges;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class ExchangeBuyMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 5774;
    private boolean _isInitialized = false;
    private int objectToBuyId = 0;
    private int quantity = 0;


    public void serialize(ICustomDataOutput param1) {
         if(this.objectToBuyId < 0)
         {
            throw new Exception("Forbidden value (" + this.objectToBuyId + ") on element objectToBuyId.");
         }
         param1.writeVarInt(this.objectToBuyId);
         if(this.quantity < 0)
         {
            throw new Exception("Forbidden value (" + this.quantity + ") on element quantity.");
         }
         param1.writeVarInt(this.quantity);
    }

    public void deserialize(ICustomDataInput param1) {
         this.objectToBuyId = param1.readVarUhInt();
         if(this.objectToBuyId < 0)
         {
            throw new Exception("Forbidden value (" + this.objectToBuyId + ") on element of ExchangeBuyMessage.objectToBuyId.");
         }
         this.quantity = param1.readVarUhInt();
         if(this.quantity < 0)
         {
            throw new Exception("Forbidden value (" + this.quantity + ") on element of ExchangeBuyMessage.quantity.");
         }
    }

}