package com.ankamagames.dofus.network.messages.game.inventory.exchanges;

import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class ExchangePlayerMultiCraftRequestMessage extends ExchangeRequestMessage implements INetworkMessage {

    private int protocolId = 5784;
    private boolean _isInitialized = false;
    private Number target = 0;
    private int skillId = 0;


    public void serialize(ICustomDataOutput param1) {
         param1.writeByte(this.exchangeType);
         if(this.target < 0 || this.target > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.target + ") on element target.");
         }
         param1.writeVarLong(this.target);
         if(this.skillId < 0)
         {
            throw new Exception("Forbidden value (" + this.skillId + ") on element skillId.");
         }
         param1.writeVarInt(this.skillId);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_ExchangeRequestMessage(param1);
         this.target = param1.readVarUhLong();
         if(this.target < 0 || this.target > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.target + ") on element of ExchangePlayerMultiCraftRequestMessage.target.");
         }
         this.skillId = param1.readVarUhInt();
         if(this.skillId < 0)
         {
            throw new Exception("Forbidden value (" + this.skillId + ") on element of ExchangePlayerMultiCraftRequestMessage.skillId.");
         }
    }

}