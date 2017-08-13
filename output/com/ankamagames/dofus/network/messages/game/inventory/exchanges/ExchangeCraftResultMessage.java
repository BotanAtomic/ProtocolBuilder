package com.ankamagames.dofus.network.messages.game.inventory.exchanges;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class ExchangeCraftResultMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 5790;
    private boolean _isInitialized = false;
    private int craftResult = 0;


    public void serialize(ICustomDataOutput param1) {
         param1.writeByte(this.craftResult);
    }

    public void deserialize(ICustomDataInput param1) {
         this.craftResult = param1.readByte();
         if(this.craftResult < 0)
         {
            throw new Exception("Forbidden value (" + this.craftResult + ") on element of ExchangeCraftResultMessage.craftResult.");
         }
    }

}