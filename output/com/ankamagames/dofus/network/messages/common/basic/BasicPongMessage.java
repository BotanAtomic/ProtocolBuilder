package com.ankamagames.dofus.network.messages.common.basic;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class BasicPongMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 183;
    private boolean _isInitialized = false;
    private boolean quiet = false;


    public void serialize(ICustomDataOutput param1) {
         param1.writeBoolean(this.quiet);
    }

    public void deserialize(ICustomDataInput param1) {
         this.quiet = param1.readBoolean();
    }

}