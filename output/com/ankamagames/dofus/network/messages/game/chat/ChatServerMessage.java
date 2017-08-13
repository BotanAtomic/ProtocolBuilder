package com.ankamagames.dofus.network.messages.game.chat;

import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class ChatServerMessage extends ChatAbstractServerMessage implements INetworkMessage {

    private int protocolId = 881;
    private boolean _isInitialized = false;
    private Number senderId = 0;
    private String senderName = "";
    private int senderAccountId = 0;


    public void serialize(ICustomDataOutput param1) {
         param1.writeByte(this.channel);
         param1.writeUTF(this.content);
         if(this.timestamp < 0)
         {
            throw new Exception("Forbidden value (" + this.timestamp + ") on element timestamp.");
         }
         param1.writeInt(this.timestamp);
         param1.writeUTF(this.fingerprint);
         if(this.senderId < -9.007199254740992E15 || this.senderId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.senderId + ") on element senderId.");
         }
         param1.writeDouble(this.senderId);
         param1.writeUTF(this.senderName);
         if(this.senderAccountId < 0)
         {
            throw new Exception("Forbidden value (" + this.senderAccountId + ") on element senderAccountId.");
         }
         param1.writeInt(this.senderAccountId);
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
         this.senderId = param1.readDouble();
         if(this.senderId < -9.007199254740992E15 || this.senderId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.senderId + ") on element of ChatServerMessage.senderId.");
         }
         this.senderName = param1.readUTF();
         this.senderAccountId = param1.readInt();
         if(this.senderAccountId < 0)
         {
            throw new Exception("Forbidden value (" + this.senderAccountId + ") on element of ChatServerMessage.senderAccountId.");
         }
    }

}