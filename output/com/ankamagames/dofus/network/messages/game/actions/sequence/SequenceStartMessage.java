package com.ankamagames.dofus.network.messages.game.actions.sequence;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class SequenceStartMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 955;
    private boolean _isInitialized = false;
    private int sequenceType = 0;
    private Number authorId = 0;


    public void serialize(ICustomDataOutput param1) {
         param1.writeByte(this.sequenceType);
         if(this.authorId < -9.007199254740992E15 || this.authorId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.authorId + ") on element authorId.");
         }
         param1.writeDouble(this.authorId);
    }

    public void deserialize(ICustomDataInput param1) {
         this.sequenceType = param1.readByte();
         this.authorId = param1.readDouble();
         if(this.authorId < -9.007199254740992E15 || this.authorId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.authorId + ") on element of SequenceStartMessage.authorId.");
         }
    }

}