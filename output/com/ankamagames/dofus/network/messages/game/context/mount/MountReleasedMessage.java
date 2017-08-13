package com.ankamagames.dofus.network.messages.game.context.mount;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class MountReleasedMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6308;
    private boolean _isInitialized = false;
    private int mountId = 0;


    public void serialize(ICustomDataOutput param1) {
         param1.writeVarInt(this.mountId);
    }

    public void deserialize(ICustomDataInput param1) {
         this.mountId = param1.readVarInt();
    }

}