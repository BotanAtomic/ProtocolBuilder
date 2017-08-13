package com.ankamagames.dofus.network.messages.game.chat;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class ChatAbstractClientMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 850;
    private boolean _isInitialized = false;
    private String content = "";


    public void serialize(ICustomDataOutput param1) {
         param1.writeUTF(this.content);
    }

    public void deserialize(ICustomDataInput param1) {
         this.content = param1.readUTF();
    }

}