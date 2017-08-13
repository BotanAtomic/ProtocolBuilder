package com.ankamagames.dofus.network.messages.game.inventory.exchanges;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class ExchangeBidHouseGenericItemAddedMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 5947;
    private boolean _isInitialized = false;
    private int objGenericId = 0;


    public void serialize(ICustomDataOutput param1) {
         if(this.objGenericId < 0)
         {
            throw new Exception("Forbidden value (" + this.objGenericId + ") on element objGenericId.");
         }
         param1.writeVarShort(this.objGenericId);
    }

    public void deserialize(ICustomDataInput param1) {
         this.objGenericId = param1.readVarUhShort();
         if(this.objGenericId < 0)
         {
            throw new Exception("Forbidden value (" + this.objGenericId + ") on element of ExchangeBidHouseGenericItemAddedMessage.objGenericId.");
         }
    }

}