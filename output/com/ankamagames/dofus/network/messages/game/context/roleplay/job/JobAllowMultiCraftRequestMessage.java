package com.ankamagames.dofus.network.messages.game.context.roleplay.job;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class JobAllowMultiCraftRequestMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 5748;
    private boolean _isInitialized = false;
    private boolean enabled = false;


    public void serialize(ICustomDataOutput param1) {
         param1.writeBoolean(this.enabled);
    }

    public void deserialize(ICustomDataInput param1) {
         this.enabled = param1.readBoolean();
    }

}