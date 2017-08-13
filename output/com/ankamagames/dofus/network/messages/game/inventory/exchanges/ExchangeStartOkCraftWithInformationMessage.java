package com.ankamagames.dofus.network.messages.game.inventory.exchanges;

import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class ExchangeStartOkCraftWithInformationMessage extends ExchangeStartOkCraftMessage implements INetworkMessage {

    private int protocolId = 5941;
    private boolean _isInitialized = false;
    private int skillId = 0;


    public void serialize(ICustomDataOutput param1) {
         if(this.skillId < 0)
         {
            throw new Exception("Forbidden value (" + this.skillId + ") on element skillId.");
         }
         param1.writeVarInt(this.skillId);
    }

    public void deserialize(ICustomDataInput param1) {
         this.skillId = param1.readVarUhInt();
         if(this.skillId < 0)
         {
            throw new Exception("Forbidden value (" + this.skillId + ") on element of ExchangeStartOkCraftWithInformationMessage.skillId.");
         }
    }

}