package com.ankamagames.dofus.network.messages.game.basic;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class BasicWhoAmIRequestMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 5664;
    private boolean _isInitialized = false;
    private boolean verbose = false;


    public void serialize(ICustomDataOutput param1) {
         param1.writeBoolean(this.verbose);
    }

    public void deserialize(ICustomDataInput param1) {
         this.verbose = param1.readBoolean();
    }

}