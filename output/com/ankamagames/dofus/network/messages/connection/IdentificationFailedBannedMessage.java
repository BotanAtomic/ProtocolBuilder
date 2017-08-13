package com.ankamagames.dofus.network.messages.connection;

import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class IdentificationFailedBannedMessage extends IdentificationFailedMessage implements INetworkMessage {

    private int protocolId = 6174;
    private boolean _isInitialized = false;
    private Number banEndDate = 0;


    public void serialize(ICustomDataOutput param1) {
         param1.writeByte(this.reason);
         if(this.banEndDate < 0 || this.banEndDate > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.banEndDate + ") on element banEndDate.");
         }
         param1.writeDouble(this.banEndDate);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_IdentificationFailedMessage(param1);
         this.banEndDate = param1.readDouble();
         if(this.banEndDate < 0 || this.banEndDate > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.banEndDate + ") on element of IdentificationFailedBannedMessage.banEndDate.");
         }
    }

}