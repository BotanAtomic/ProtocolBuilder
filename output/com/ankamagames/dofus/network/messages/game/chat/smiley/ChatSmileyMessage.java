package com.ankamagames.dofus.network.messages.game.chat.smiley;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class ChatSmileyMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 801;
    private boolean _isInitialized = false;
    private Number entityId = 0;
    private int smileyId = 0;
    private int accountId = 0;


    public void serialize(ICustomDataOutput param1) {
         if(this.entityId < -9.007199254740992E15 || this.entityId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.entityId + ") on element entityId.");
         }
         param1.writeDouble(this.entityId);
         if(this.smileyId < 0)
         {
            throw new Exception("Forbidden value (" + this.smileyId + ") on element smileyId.");
         }
         param1.writeVarShort(this.smileyId);
         if(this.accountId < 0)
         {
            throw new Exception("Forbidden value (" + this.accountId + ") on element accountId.");
         }
         param1.writeInt(this.accountId);
    }

    public void deserialize(ICustomDataInput param1) {
         this.entityId = param1.readDouble();
         if(this.entityId < -9.007199254740992E15 || this.entityId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.entityId + ") on element of ChatSmileyMessage.entityId.");
         }
         this.smileyId = param1.readVarUhShort();
         if(this.smileyId < 0)
         {
            throw new Exception("Forbidden value (" + this.smileyId + ") on element of ChatSmileyMessage.smileyId.");
         }
         this.accountId = param1.readInt();
         if(this.accountId < 0)
         {
            throw new Exception("Forbidden value (" + this.accountId + ") on element of ChatSmileyMessage.accountId.");
         }
    }

}