package com.ankamagames.dofus.network.messages.game.inventory.exchanges;

import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class ExchangeStartedWithStorageMessage extends ExchangeStartedMessage implements INetworkMessage {

    private int protocolId = 6236;
    private boolean _isInitialized = false;
    private int storageMaxSlot = 0;


    public void serialize(ICustomDataOutput param1) {
         super.serializeAs_ExchangeStartedMessage(param1);
         if(this.storageMaxSlot < 0)
         {
            throw new Exception("Forbidden value (" + this.storageMaxSlot + ") on element storageMaxSlot.");
         }
         param1.writeVarInt(this.storageMaxSlot);
    }

    public void deserialize(ICustomDataInput param1) {
         this.exchangeType = param1.readByte();
         this.storageMaxSlot = param1.readVarUhInt();
         if(this.storageMaxSlot < 0)
         {
            throw new Exception("Forbidden value (" + this.storageMaxSlot + ") on element of ExchangeStartedWithStorageMessage.storageMaxSlot.");
         }
    }

}