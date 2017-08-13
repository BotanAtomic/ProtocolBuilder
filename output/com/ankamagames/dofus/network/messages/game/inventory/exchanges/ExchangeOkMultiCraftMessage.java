package com.ankamagames.dofus.network.messages.game.inventory.exchanges;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class ExchangeOkMultiCraftMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 5768;
    private boolean _isInitialized = false;
    private Number initiatorId = 0;
    private Number otherId = 0;
    private int role = 0;


    public void serialize(ICustomDataOutput param1) {
         if(this.initiatorId < 0 || this.initiatorId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.initiatorId + ") on element initiatorId.");
         }
         param1.writeVarLong(this.initiatorId);
         if(this.otherId < 0 || this.otherId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.otherId + ") on element otherId.");
         }
         param1.writeVarLong(this.otherId);
         param1.writeByte(this.role);
    }

    public void deserialize(ICustomDataInput param1) {
         this.initiatorId = param1.readVarUhLong();
         if(this.initiatorId < 0 || this.initiatorId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.initiatorId + ") on element of ExchangeOkMultiCraftMessage.initiatorId.");
         }
         this.otherId = param1.readVarUhLong();
         if(this.otherId < 0 || this.otherId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.otherId + ") on element of ExchangeOkMultiCraftMessage.otherId.");
         }
         this.role = param1.readByte();
    }

}