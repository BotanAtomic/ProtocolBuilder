package com.ankamagames.dofus.network.messages.game.inventory.exchanges;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class ExchangeBidHouseSearchMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 5806;
    private boolean _isInitialized = false;
    private int type = 0;
    private int genId = 0;


    public void serialize(ICustomDataOutput param1) {
         if(this.type < 0)
         {
            throw new Exception("Forbidden value (" + this.type + ") on element type.");
         }
         param1.writeVarInt(this.type);
         if(this.genId < 0)
         {
            throw new Exception("Forbidden value (" + this.genId + ") on element genId.");
         }
         param1.writeVarShort(this.genId);
    }

    public void deserialize(ICustomDataInput param1) {
         this.type = param1.readVarUhInt();
         if(this.type < 0)
         {
            throw new Exception("Forbidden value (" + this.type + ") on element of ExchangeBidHouseSearchMessage.type.");
         }
         this.genId = param1.readVarUhShort();
         if(this.genId < 0)
         {
            throw new Exception("Forbidden value (" + this.genId + ") on element of ExchangeBidHouseSearchMessage.genId.");
         }
    }

}