package com.ankamagames.dofus.network.messages.game.idol;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class IdolPartyRegisterRequestMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6582;
    private boolean _isInitialized = false;
    private boolean register = false;


    public void serialize(ICustomDataOutput param1) {
         param1.writeBoolean(this.register);
    }

    public void deserialize(ICustomDataInput param1) {
         this.register = param1.readBoolean();
    }

}