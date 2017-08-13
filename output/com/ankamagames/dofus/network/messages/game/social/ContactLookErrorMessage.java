package com.ankamagames.dofus.network.messages.game.social;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class ContactLookErrorMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6045;
    private boolean _isInitialized = false;
    private int requestId = 0;


    public void serialize(ICustomDataOutput param1) {
         if(this.requestId < 0)
         {
            throw new Exception("Forbidden value (" + this.requestId + ") on element requestId.");
         }
         param1.writeVarInt(this.requestId);
    }

    public void deserialize(ICustomDataInput param1) {
         this.requestId = param1.readVarUhInt();
         if(this.requestId < 0)
         {
            throw new Exception("Forbidden value (" + this.requestId + ") on element of ContactLookErrorMessage.requestId.");
         }
    }

}