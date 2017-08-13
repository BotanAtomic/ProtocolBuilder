package com.ankamagames.dofus.network.messages.queues;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class LoginQueueStatusMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 10;
    private boolean _isInitialized = false;
    private int position = 0;
    private int total = 0;


    public void serialize(ICustomDataOutput param1) {
         if(this.position < 0 || this.position > 65535)
         {
            throw new Exception("Forbidden value (" + this.position + ") on element position.");
         }
         param1.writeShort(this.position);
         if(this.total < 0 || this.total > 65535)
         {
            throw new Exception("Forbidden value (" + this.total + ") on element total.");
         }
         param1.writeShort(this.total);
    }

    public void deserialize(ICustomDataInput param1) {
         this.position = param1.readUnsignedShort();
         if(this.position < 0 || this.position > 65535)
         {
            throw new Exception("Forbidden value (" + this.position + ") on element of LoginQueueStatusMessage.position.");
         }
         this.total = param1.readUnsignedShort();
         if(this.total < 0 || this.total > 65535)
         {
            throw new Exception("Forbidden value (" + this.total + ") on element of LoginQueueStatusMessage.total.");
         }
    }

}