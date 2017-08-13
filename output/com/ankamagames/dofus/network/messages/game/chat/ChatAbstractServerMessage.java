package com.ankamagames.dofus.network.messages.game.chat;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class ChatAbstractServerMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 880;
    private boolean _isInitialized = false;
    private int channel = 0;
    private String content = "";
    private int timestamp = 0;
    private String fingerprint = "";


    public void serialize(ICustomDataOutput param1) {
         param1.writeByte(this.channel);
         param1.writeUTF(this.content);
         if(this.timestamp < 0)
         {
            throw new Exception("Forbidden value (" + this.timestamp + ") on element timestamp.");
         }
         param1.writeInt(this.timestamp);
         param1.writeUTF(this.fingerprint);
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
    }

}