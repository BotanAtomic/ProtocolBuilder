package com.ankamagames.dofus.network.messages.game.pvp;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class SetEnableAVARequestMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6443;
    private boolean _isInitialized = false;
    private boolean enable = false;


    public void serialize(ICustomDataOutput param1) {
         param1.writeBoolean(this.enable);
    }

    public void deserialize(ICustomDataInput param1) {
         this.enable = param1.readBoolean();
    }

}