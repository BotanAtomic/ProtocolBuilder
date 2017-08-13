package com.ankamagames.dofus.network.messages.game.prism;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class PrismInfoJoinLeaveRequestMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 5844;
    private boolean _isInitialized = false;
    private boolean join = false;


    public void serialize(ICustomDataOutput param1) {
         param1.writeBoolean(this.join);
    }

    public void deserialize(ICustomDataInput param1) {
         this.join = param1.readBoolean();
    }

}