package com.ankamagames.dofus.network.messages.game.inventory.items;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class ObjectJobAddedMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6014;
    private boolean _isInitialized = false;
    private int jobId = 0;


    public void serialize(ICustomDataOutput param1) {
         if(this.jobId < 0)
         {
            throw new Exception("Forbidden value (" + this.jobId + ") on element jobId.");
         }
         param1.writeByte(this.jobId);
    }

    public void deserialize(ICustomDataInput param1) {
         this.jobId = param1.readByte();
         if(this.jobId < 0)
         {
            throw new Exception("Forbidden value (" + this.jobId + ") on element of ObjectJobAddedMessage.jobId.");
         }
    }

}