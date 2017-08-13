package com.ankamagames.dofus.network.messages.game.inventory.exchanges;

import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class ExchangeCraftInformationObjectMessage extends ExchangeCraftResultWithObjectIdMessage implements INetworkMessage {

    private int protocolId = 5794;
    private boolean _isInitialized = false;
    private Number playerId = 0;


    public void serialize(ICustomDataOutput param1) {
         super.serializeAs_ExchangeCraftResultMessage(param1);
         if(this.objectGenericId < 0)
         {
            throw new Exception("Forbidden value (" + this.objectGenericId + ") on element objectGenericId.");
         }
         param1.writeVarShort(this.objectGenericId);
         if(this.playerId < 0 || this.playerId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.playerId + ") on element playerId.");
         }
         param1.writeVarLong(this.playerId);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_ExchangeCraftResultWithObjectIdMessage(param1);
         this.playerId = param1.readVarUhLong();
         if(this.playerId < 0 || this.playerId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.playerId + ") on element of ExchangeCraftInformationObjectMessage.playerId.");
         }
    }

}