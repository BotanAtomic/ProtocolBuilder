package com.ankamagames.dofus.network.messages.game.actions.sequence;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class SequenceEndMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 956;
    private boolean _isInitialized = false;
    private int actionId = 0;
    private Number authorId = 0;
    private int sequenceType = 0;


    public void serialize(ICustomDataOutput param1) {
         if(this.actionId < 0)
         {
            throw new Exception("Forbidden value (" + this.actionId + ") on element actionId.");
         }
         param1.writeVarShort(this.actionId);
         if(this.authorId < -9.007199254740992E15 || this.authorId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.authorId + ") on element authorId.");
         }
         param1.writeDouble(this.authorId);
         param1.writeByte(this.sequenceType);
    }

    public void deserialize(ICustomDataInput param1) {
         this.actionId = param1.readVarUhShort();
         if(this.actionId < 0)
         {
            throw new Exception("Forbidden value (" + this.actionId + ") on element of SequenceEndMessage.actionId.");
         }
         this.authorId = param1.readDouble();
         if(this.authorId < -9.007199254740992E15 || this.authorId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.authorId + ") on element of SequenceEndMessage.authorId.");
         }
         this.sequenceType = param1.readByte();
    }

}