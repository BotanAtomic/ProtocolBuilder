package com.ankamagames.dofus.network.messages.game.chat;

import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class ChatClientPrivateMessage extends ChatAbstractClientMessage implements INetworkMessage {

    private int protocolId = 851;
    private boolean _isInitialized = false;
    private String receiver = "";


    public void serialize(ICustomDataOutput param1) {
         param1.writeUTF(this.content);
         param1.writeUTF(this.receiver);
    }

    public void deserialize(ICustomDataInput param1) {
         this.content = param1.readUTF();
         this.receiver = param1.readUTF();
    }

}