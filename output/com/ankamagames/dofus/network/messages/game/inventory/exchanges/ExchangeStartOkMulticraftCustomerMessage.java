package com.ankamagames.dofus.network.messages.game.inventory.exchanges;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class ExchangeStartOkMulticraftCustomerMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 5817;
    private boolean _isInitialized = false;
    private int skillId = 0;
    private int crafterJobLevel = 0;


    public void serialize(ICustomDataOutput param1) {
         if(this.skillId < 0)
         {
            throw new Exception("Forbidden value (" + this.skillId + ") on element skillId.");
         }
         param1.writeVarInt(this.skillId);
         if(this.crafterJobLevel < 0 || this.crafterJobLevel > 255)
         {
            throw new Exception("Forbidden value (" + this.crafterJobLevel + ") on element crafterJobLevel.");
         }
         param1.writeByte(this.crafterJobLevel);
    }

    public void deserialize(ICustomDataInput param1) {
         this.skillId = param1.readVarUhInt();
         if(this.skillId < 0)
         {
            throw new Exception("Forbidden value (" + this.skillId + ") on element of ExchangeStartOkMulticraftCustomerMessage.skillId.");
         }
         this.crafterJobLevel = param1.readUnsignedByte();
         if(this.crafterJobLevel < 0 || this.crafterJobLevel > 255)
         {
            throw new Exception("Forbidden value (" + this.crafterJobLevel + ") on element of ExchangeStartOkMulticraftCustomerMessage.crafterJobLevel.");
         }
    }

}