package com.ankamagames.dofus.network.messages.game.chat.smiley;

import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class LocalizedChatSmileyMessage extends ChatSmileyMessage implements INetworkMessage {

    private int protocolId = 6185;
    private boolean _isInitialized = false;
    private int cellId = 0;


    public void serialize(ICustomDataOutput param1) {
         super.serializeAs_ChatSmileyMessage(param1);
         if(this.cellId < 0 || this.cellId > 559)
         {
            throw new Exception("Forbidden value (" + this.cellId + ") on element cellId.");
         }
         param1.writeVarShort(this.cellId);
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
         this.cellId = param1.readVarUhShort();
         if(this.cellId < 0 || this.cellId > 559)
         {
            throw new Exception("Forbidden value (" + this.cellId + ") on element of LocalizedChatSmileyMessage.cellId.");
         }
    }

}