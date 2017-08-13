package com.ankamagames.dofus.network.messages.game.chat;

import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class ChatClientMultiMessage extends ChatAbstractClientMessage implements INetworkMessage {

    private int protocolId = 861;
    private boolean _isInitialized = false;
    private int channel = 0;


    public void serialize(ICustomDataOutput param1) {
         super.serializeAs_ChatAbstractClientMessage(param1);
         param1.writeByte(this.channel);
    }

    public void deserialize(ICustomDataInput param1) {
         this.content = param1.readUTF();
         this.channel = param1.readByte();
         if(this.channel < 0)
         {
            throw new Exception("Forbidden value (" + this.channel + ") on element of ChatClientMultiMessage.channel.");
         }
    }

}