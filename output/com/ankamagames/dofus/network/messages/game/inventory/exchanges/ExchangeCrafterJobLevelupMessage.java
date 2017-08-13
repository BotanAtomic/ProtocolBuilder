package com.ankamagames.dofus.network.messages.game.inventory.exchanges;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class ExchangeCrafterJobLevelupMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6598;
    private boolean _isInitialized = false;
    private int crafterJobLevel = 0;


    public void serialize(ICustomDataOutput param1) {
         if(this.crafterJobLevel < 0 || this.crafterJobLevel > 255)
         {
            throw new Exception("Forbidden value (" + this.crafterJobLevel + ") on element crafterJobLevel.");
         }
         param1.writeByte(this.crafterJobLevel);
    }

    public void deserialize(ICustomDataInput param1) {
         this.crafterJobLevel = param1.readUnsignedByte();
         if(this.crafterJobLevel < 0 || this.crafterJobLevel > 255)
         {
            throw new Exception("Forbidden value (" + this.crafterJobLevel + ") on element of ExchangeCrafterJobLevelupMessage.crafterJobLevel.");
         }
    }

}