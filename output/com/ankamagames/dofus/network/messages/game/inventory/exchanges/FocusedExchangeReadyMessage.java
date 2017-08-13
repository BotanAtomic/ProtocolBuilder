package com.ankamagames.dofus.network.messages.game.inventory.exchanges;

import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class FocusedExchangeReadyMessage extends ExchangeReadyMessage implements INetworkMessage {

    private int protocolId = 6701;
    private boolean _isInitialized = false;
    private int focusActionId = 0;


    public void serialize(ICustomDataOutput param1) {
         super.serializeAs_ExchangeReadyMessage(param1);
         if(this.focusActionId < 0)
         {
            throw new Exception("Forbidden value (" + this.focusActionId + ") on element focusActionId.");
         }
         param1.writeVarInt(this.focusActionId);
    }

    public void deserialize(ICustomDataInput param1) {
         this.ready = param1.readBoolean();
         this.step = param1.readVarUhShort();
         if(this.step < 0)
         {
            throw new Exception("Forbidden value (" + this.step + ") on element of ExchangeReadyMessage.step.");
         }
         this.focusActionId = param1.readVarUhInt();
         if(this.focusActionId < 0)
         {
            throw new Exception("Forbidden value (" + this.focusActionId + ") on element of FocusedExchangeReadyMessage.focusActionId.");
         }
    }

}