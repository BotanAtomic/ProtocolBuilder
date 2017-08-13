package com.ankamagames.dofus.network.messages.game.inventory.exchanges;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class ExchangeBidPriceMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 5755;
    private boolean _isInitialized = false;
    private int genericId = 0;
    private Number averagePrice = 0;


    public void serialize(ICustomDataOutput param1) {
         if(this.genericId < 0)
         {
            throw new Exception("Forbidden value (" + this.genericId + ") on element genericId.");
         }
         param1.writeVarShort(this.genericId);
         if(this.averagePrice < -9.007199254740992E15 || this.averagePrice > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.averagePrice + ") on element averagePrice.");
         }
         param1.writeVarLong(this.averagePrice);
    }

    public void deserialize(ICustomDataInput param1) {
         this.genericId = param1.readVarUhShort();
         if(this.genericId < 0)
         {
            throw new Exception("Forbidden value (" + this.genericId + ") on element of ExchangeBidPriceMessage.genericId.");
         }
         this.averagePrice = param1.readVarLong();
         if(this.averagePrice < -9.007199254740992E15 || this.averagePrice > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.averagePrice + ") on element of ExchangeBidPriceMessage.averagePrice.");
         }
    }

}