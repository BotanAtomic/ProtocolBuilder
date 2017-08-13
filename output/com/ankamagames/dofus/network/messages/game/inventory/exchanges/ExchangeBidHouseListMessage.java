package com.ankamagames.dofus.network.messages.game.inventory.exchanges;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class ExchangeBidHouseListMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 5807;
    private boolean _isInitialized = false;
    private int id = 0;


    public void serialize(ICustomDataOutput param1) {
         if(this.id < 0)
         {
            throw new Exception("Forbidden value (" + this.id + ") on element id.");
         }
         param1.writeVarShort(this.id);
    }

    public void deserialize(ICustomDataInput param1) {
         this.id = param1.readVarUhShort();
         if(this.id < 0)
         {
            throw new Exception("Forbidden value (" + this.id + ") on element of ExchangeBidHouseListMessage.id.");
         }
    }

}