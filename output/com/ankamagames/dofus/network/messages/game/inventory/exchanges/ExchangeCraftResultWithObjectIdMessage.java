package com.ankamagames.dofus.network.messages.game.inventory.exchanges;

import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class ExchangeCraftResultWithObjectIdMessage extends ExchangeCraftResultMessage implements INetworkMessage {

    private int protocolId = 6000;
    private boolean _isInitialized = false;
    private int objectGenericId = 0;


    public void serialize(ICustomDataOutput param1) {
         super.serializeAs_ExchangeCraftResultMessage(param1);
         if(this.objectGenericId < 0)
         {
            throw new Exception("Forbidden value (" + this.objectGenericId + ") on element objectGenericId.");
         }
         param1.writeVarShort(this.objectGenericId);
    }

    public void deserialize(ICustomDataInput param1) {
         this.craftResult = param1.readByte();
         if(this.craftResult < 0)
         {
            throw new Exception("Forbidden value (" + this.craftResult + ") on element of ExchangeCraftResultMessage.craftResult.");
         }
         this.objectGenericId = param1.readVarUhShort();
         if(this.objectGenericId < 0)
         {
            throw new Exception("Forbidden value (" + this.objectGenericId + ") on element of ExchangeCraftResultWithObjectIdMessage.objectGenericId.");
         }
    }

}