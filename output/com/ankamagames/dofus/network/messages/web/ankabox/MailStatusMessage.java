package com.ankamagames.dofus.network.messages.web.ankabox;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class MailStatusMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6275;
    private boolean _isInitialized = false;
    private int unread = 0;
    private int total = 0;


    public void serialize(ICustomDataOutput param1) {
         if(this.unread < 0)
         {
            throw new Exception("Forbidden value (" + this.unread + ") on element unread.");
         }
         param1.writeVarShort(this.unread);
         if(this.total < 0)
         {
            throw new Exception("Forbidden value (" + this.total + ") on element total.");
         }
         param1.writeVarShort(this.total);
    }

    public void deserialize(ICustomDataInput param1) {
         this.unread = param1.readVarUhShort();
         if(this.unread < 0)
         {
            throw new Exception("Forbidden value (" + this.unread + ") on element of MailStatusMessage.unread.");
         }
         this.total = param1.readVarUhShort();
         if(this.total < 0)
         {
            throw new Exception("Forbidden value (" + this.total + ") on element of MailStatusMessage.total.");
         }
    }

}