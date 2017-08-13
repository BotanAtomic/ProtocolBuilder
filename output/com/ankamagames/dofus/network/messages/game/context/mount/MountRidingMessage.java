package com.ankamagames.dofus.network.messages.game.context.mount;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class MountRidingMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 5967;
    private boolean _isInitialized = false;
    private boolean isRiding = false;


    public void serialize(ICustomDataOutput param1) {
         param1.writeBoolean(this.isRiding);
    }

    public void deserialize(ICustomDataInput param1) {
         this.isRiding = param1.readBoolean();
    }

}