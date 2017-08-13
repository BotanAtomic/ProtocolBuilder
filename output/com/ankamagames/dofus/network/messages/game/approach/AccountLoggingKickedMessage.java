package com.ankamagames.dofus.network.messages.game.approach;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class AccountLoggingKickedMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6029;
    private boolean _isInitialized = false;
    private int days = 0;
    private int hours = 0;
    private int minutes = 0;


    public void serialize(ICustomDataOutput param1) {
         if(this.days < 0)
         {
            throw new Exception("Forbidden value (" + this.days + ") on element days.");
         }
         param1.writeVarShort(this.days);
         if(this.hours < 0)
         {
            throw new Exception("Forbidden value (" + this.hours + ") on element hours.");
         }
         param1.writeByte(this.hours);
         if(this.minutes < 0)
         {
            throw new Exception("Forbidden value (" + this.minutes + ") on element minutes.");
         }
         param1.writeByte(this.minutes);
    }

    public void deserialize(ICustomDataInput param1) {
         this.days = param1.readVarUhShort();
         if(this.days < 0)
         {
            throw new Exception("Forbidden value (" + this.days + ") on element of AccountLoggingKickedMessage.days.");
         }
         this.hours = param1.readByte();
         if(this.hours < 0)
         {
            throw new Exception("Forbidden value (" + this.hours + ") on element of AccountLoggingKickedMessage.hours.");
         }
         this.minutes = param1.readByte();
         if(this.minutes < 0)
         {
            throw new Exception("Forbidden value (" + this.minutes + ") on element of AccountLoggingKickedMessage.minutes.");
         }
    }

}