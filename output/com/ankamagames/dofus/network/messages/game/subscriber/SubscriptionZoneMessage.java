package com.ankamagames.dofus.network.messages.game.subscriber;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class SubscriptionZoneMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 5573;
    private boolean _isInitialized = false;
    private boolean active = false;


    public void serialize(ICustomDataOutput param1) {
         param1.writeBoolean(this.active);
    }

    public void deserialize(ICustomDataInput param1) {
         this.active = param1.readBoolean();
    }

}