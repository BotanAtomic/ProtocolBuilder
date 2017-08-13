package com.ankamagames.dofus.network.messages.game.basic;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class SequenceNumberMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6317;
    private boolean _isInitialized = false;
    private int number = 0;


    public void serialize(ICustomDataOutput param1) {
         if(this.number < 0 || this.number > 65535)
         {
            throw new Exception("Forbidden value (" + this.number + ") on element number.");
         }
         param1.writeShort(this.number);
    }

    public void deserialize(ICustomDataInput param1) {
         this.number = param1.readUnsignedShort();
         if(this.number < 0 || this.number > 65535)
         {
            throw new Exception("Forbidden value (" + this.number + ") on element of SequenceNumberMessage.number.");
         }
    }

}