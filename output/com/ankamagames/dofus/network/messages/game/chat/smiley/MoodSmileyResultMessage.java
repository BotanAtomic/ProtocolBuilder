package com.ankamagames.dofus.network.messages.game.chat.smiley;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class MoodSmileyResultMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6196;
    private boolean _isInitialized = false;
    private int resultCode = 1;
    private int smileyId = 0;


    public void serialize(ICustomDataOutput param1) {
         param1.writeByte(this.resultCode);
         if(this.smileyId < 0)
         {
            throw new Exception("Forbidden value (" + this.smileyId + ") on element smileyId.");
         }
         param1.writeVarShort(this.smileyId);
    }

    public void deserialize(ICustomDataInput param1) {
         this.resultCode = param1.readByte();
         if(this.resultCode < 0)
         {
            throw new Exception("Forbidden value (" + this.resultCode + ") on element of MoodSmileyResultMessage.resultCode.");
         }
         this.smileyId = param1.readVarUhShort();
         if(this.smileyId < 0)
         {
            throw new Exception("Forbidden value (" + this.smileyId + ") on element of MoodSmileyResultMessage.smileyId.");
         }
    }

}