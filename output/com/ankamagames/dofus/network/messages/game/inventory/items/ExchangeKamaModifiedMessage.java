package com.ankamagames.dofus.network.messages.game.inventory.items;

import com.ankamagames.dofus.network.messages.game.inventory.exchanges.ExchangeObjectMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class ExchangeKamaModifiedMessage extends ExchangeObjectMessage implements INetworkMessage {

    private int protocolId = 5521;
    private boolean _isInitialized = false;
    private Number quantity = 0;


    public void serialize(ICustomDataOutput param1) {
         super.serializeAs_ExchangeObjectMessage(param1);
         if(this.quantity < 0 || this.quantity > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.quantity + ") on element quantity.");
         }
         param1.writeVarLong(this.quantity);
    }

    public void deserialize(ICustomDataInput param1) {
         this.remote = param1.readBoolean();
         this.quantity = param1.readVarUhLong();
         if(this.quantity < 0 || this.quantity > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.quantity + ") on element of ExchangeKamaModifiedMessage.quantity.");
         }
    }

}