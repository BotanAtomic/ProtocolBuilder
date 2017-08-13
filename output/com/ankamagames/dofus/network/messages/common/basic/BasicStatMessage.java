package com.ankamagames.dofus.network.messages.common.basic;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class BasicStatMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6530;
    private boolean _isInitialized = false;
    private Number timeSpent = 0;
    private int statId = 0;


    public void serialize(ICustomDataOutput param1) {
         if(this.timeSpent < 0 || this.timeSpent > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.timeSpent + ") on element timeSpent.");
         }
         param1.writeDouble(this.timeSpent);
         param1.writeVarShort(this.statId);
    }

    public void deserialize(ICustomDataInput param1) {
         this.timeSpent = param1.readDouble();
         if(this.timeSpent < 0 || this.timeSpent > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.timeSpent + ") on element of BasicStatMessage.timeSpent.");
         }
         this.statId = param1.readVarUhShort();
         if(this.statId < 0)
         {
            throw new Exception("Forbidden value (" + this.statId + ") on element of BasicStatMessage.statId.");
         }
    }

}