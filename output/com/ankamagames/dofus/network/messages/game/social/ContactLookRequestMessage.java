package com.ankamagames.dofus.network.messages.game.social;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class ContactLookRequestMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 5932;
    private boolean _isInitialized = false;
    private int requestId = 0;
    private int contactType = 0;


    public void serialize(ICustomDataOutput param1) {
         if(this.requestId < 0 || this.requestId > 255)
         {
            throw new Exception("Forbidden value (" + this.requestId + ") on element requestId.");
         }
         param1.writeByte(this.requestId);
         param1.writeByte(this.contactType);
    }

    public void deserialize(ICustomDataInput param1) {
         this.requestId = param1.readUnsignedByte();
         if(this.requestId < 0 || this.requestId > 255)
         {
            throw new Exception("Forbidden value (" + this.requestId + ") on element of ContactLookRequestMessage.requestId.");
         }
         this.contactType = param1.readByte();
         if(this.contactType < 0)
         {
            throw new Exception("Forbidden value (" + this.contactType + ") on element of ContactLookRequestMessage.contactType.");
         }
    }

}