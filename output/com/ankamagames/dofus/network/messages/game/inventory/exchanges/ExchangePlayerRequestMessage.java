package com.ankamagames.dofus.network.messages.game.inventory.exchanges;

import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class ExchangePlayerRequestMessage extends ExchangeRequestMessage implements INetworkMessage {

    private int protocolId = 5773;
    private boolean _isInitialized = false;
    private Number target = 0;


    public void serialize(ICustomDataOutput param1) {
         param1.writeByte(this.exchangeType);
         if(this.target < 0 || this.target > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.target + ") on element target.");
         }
         param1.writeVarLong(this.target);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_ExchangeRequestMessage(param1);
         this.target = param1.readVarUhLong();
         if(this.target < 0 || this.target > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.target + ") on element of ExchangePlayerRequestMessage.target.");
         }
    }

}