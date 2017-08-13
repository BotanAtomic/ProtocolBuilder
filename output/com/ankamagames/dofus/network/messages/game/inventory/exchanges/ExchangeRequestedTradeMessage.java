package com.ankamagames.dofus.network.messages.game.inventory.exchanges;

import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class ExchangeRequestedTradeMessage extends ExchangeRequestedMessage implements INetworkMessage {

    private int protocolId = 5523;
    private boolean _isInitialized = false;
    private Number source = 0;
    private Number target = 0;


    public void serialize(ICustomDataOutput param1) {
         super.serializeAs_ExchangeRequestedMessage(param1);
         if(this.source < 0 || this.source > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.source + ") on element source.");
         }
         param1.writeVarLong(this.source);
         if(this.target < 0 || this.target > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.target + ") on element target.");
         }
         param1.writeVarLong(this.target);
    }

    public void deserialize(ICustomDataInput param1) {
         this.exchangeType = param1.readByte();
         this.source = param1.readVarUhLong();
         if(this.source < 0 || this.source > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.source + ") on element of ExchangeRequestedTradeMessage.source.");
         }
         this.target = param1.readVarUhLong();
         if(this.target < 0 || this.target > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.target + ") on element of ExchangeRequestedTradeMessage.target.");
         }
    }

}