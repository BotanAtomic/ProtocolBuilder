package com.ankamagames.dofus.network.messages.game.inventory.exchanges;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class ExchangeBidHousePriceMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 5805;
    private boolean _isInitialized = false;
    private int genId = 0;


    public void serialize(ICustomDataOutput param1) {
         if(this.genId < 0)
         {
            throw new Exception("Forbidden value (" + this.genId + ") on element genId.");
         }
         param1.writeVarShort(this.genId);
    }

    public void deserialize(ICustomDataInput param1) {
         this.genId = param1.readVarUhShort();
         if(this.genId < 0)
         {
            throw new Exception("Forbidden value (" + this.genId + ") on element of ExchangeBidHousePriceMessage.genId.");
         }
    }

}