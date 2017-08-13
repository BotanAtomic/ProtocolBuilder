package com.ankamagames.dofus.network.messages.subscription;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class SubscriptionUpdateMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6616;
    private boolean _isInitialized = false;
    private Number timestamp = 0;


    public void serialize(ICustomDataOutput param1) {
         if(this.timestamp < -9.007199254740992E15 || this.timestamp > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.timestamp + ") on element timestamp.");
         }
         param1.writeDouble(this.timestamp);
    }

    public void deserialize(ICustomDataInput param1) {
         this.timestamp = param1.readDouble();
         if(this.timestamp < -9.007199254740992E15 || this.timestamp > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.timestamp + ") on element of SubscriptionUpdateMessage.timestamp.");
         }
    }

}