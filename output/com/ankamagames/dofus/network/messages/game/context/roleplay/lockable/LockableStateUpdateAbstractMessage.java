package com.ankamagames.dofus.network.messages.game.context.roleplay.lockable;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class LockableStateUpdateAbstractMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 5671;
    private boolean _isInitialized = false;
    private boolean locked = false;


    public void serialize(ICustomDataOutput param1) {
         param1.writeBoolean(this.locked);
    }

    public void deserialize(ICustomDataInput param1) {
         this.locked = param1.readBoolean();
    }

}