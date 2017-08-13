package com.ankamagames.dofus.network.messages.common.basic;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class AggregateStatMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6669;
    private boolean _isInitialized = false;
    private int statId = 0;


    public void serialize(ICustomDataOutput param1) {
         param1.writeVarShort(this.statId);
    }

    public void deserialize(ICustomDataInput param1) {
         this.statId = param1.readVarUhShort();
         if(this.statId < 0)
         {
            throw new Exception("Forbidden value (" + this.statId + ") on element of AggregateStatMessage.statId.");
         }
    }

}