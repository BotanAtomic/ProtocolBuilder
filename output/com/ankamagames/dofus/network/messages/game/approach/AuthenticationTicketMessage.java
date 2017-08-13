package com.ankamagames.dofus.network.messages.game.approach;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class AuthenticationTicketMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 110;
    private boolean _isInitialized = false;
    private String lang = "";
    private String ticket = "";


    public void serialize(ICustomDataOutput param1) {
         param1.writeUTF(this.lang);
         param1.writeUTF(this.ticket);
    }

    public void deserialize(ICustomDataInput param1) {
         this.lang = param1.readUTF();
         this.ticket = param1.readUTF();
    }

}