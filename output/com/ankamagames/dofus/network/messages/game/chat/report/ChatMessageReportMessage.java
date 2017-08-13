package com.ankamagames.dofus.network.messages.game.chat.report;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class ChatMessageReportMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 821;
    private boolean _isInitialized = false;
    private String senderName = "";
    private String content = "";
    private int timestamp = 0;
    private int channel = 0;
    private String fingerprint = "";
    private int reason = 0;


    public void serialize(ICustomDataOutput param1) {
         param1.writeUTF(this.senderName);
         param1.writeUTF(this.content);
         if(this.timestamp < 0)
         {
            throw new Exception("Forbidden value (" + this.timestamp + ") on element timestamp.");
         }
         param1.writeInt(this.timestamp);
         param1.writeByte(this.channel);
         param1.writeUTF(this.fingerprint);
         if(this.reason < 0)
         {
            throw new Exception("Forbidden value (" + this.reason + ") on element reason.");
         }
         param1.writeByte(this.reason);
    }

    public void deserialize(ICustomDataInput param1) {
         this.senderName = param1.readUTF();
         this.content = param1.readUTF();
         this.timestamp = param1.readInt();
         if(this.timestamp < 0)
         {
            throw new Exception("Forbidden value (" + this.timestamp + ") on element of ChatMessageReportMessage.timestamp.");
         }
         this.channel = param1.readByte();
         if(this.channel < 0)
         {
            throw new Exception("Forbidden value (" + this.channel + ") on element of ChatMessageReportMessage.channel.");
         }
         this.fingerprint = param1.readUTF();
         this.reason = param1.readByte();
         if(this.reason < 0)
         {
            throw new Exception("Forbidden value (" + this.reason + ") on element of ChatMessageReportMessage.reason.");
         }
    }

}