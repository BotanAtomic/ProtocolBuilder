package com.ankamagames.dofus.network.messages.game.friend;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class IgnoredAddRequestMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 5673;
    private boolean _isInitialized = false;
    private String name = "";
    private boolean session = false;


    public void serialize(ICustomDataOutput param1) {
         param1.writeUTF(this.name);
         param1.writeBoolean(this.session);
    }

    public void deserialize(ICustomDataInput param1) {
         this.name = param1.readUTF();
         this.session = param1.readBoolean();
    }

}