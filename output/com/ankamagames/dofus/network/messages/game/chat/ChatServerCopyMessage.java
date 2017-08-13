package com.ankamagames.dofus.network.messages.game.chat;

import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class ChatServerCopyMessage extends ChatAbstractServerMessage implements INetworkMessage {

    private int protocolId = 882;
    private boolean _isInitialized = false;
    private Number receiverId = 0;
    private String receiverName = "";


    public void serialize(ICustomDataOutput param1) {
         super.serializeAs_ChatAbstractServerMessage(param1);
         if(this.receiverId < 0 || this.receiverId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.receiverId + ") on element receiverId.");
         }
         param1.writeVarLong(this.receiverId);
         param1.writeUTF(this.receiverName);
    }

    public void deserialize(ICustomDataInput param1) {
         this.channel = param1.readByte();
         if(this.channel < 0)
         {
            throw new Exception("Forbidden value (" + this.channel + ") on element of ChatAbstractServerMessage.channel.");
         }
         this.content = param1.readUTF();
         this.timestamp = param1.readInt();
         if(this.timestamp < 0)
         {
            throw new Exception("Forbidden value (" + this.timestamp + ") on element of ChatAbstractServerMessage.timestamp.");
         }
         this.fingerprint = param1.readUTF();
         this.receiverId = param1.readVarUhLong();
         if(this.receiverId < 0 || this.receiverId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.receiverId + ") on element of ChatServerCopyMessage.receiverId.");
         }
         this.receiverName = param1.readUTF();
    }

}