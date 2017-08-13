package com.ankamagames.dofus.network.messages.game.context.mount;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class MountInformationInPaddockRequestMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 5975;
    private boolean _isInitialized = false;
    private int mapRideId = 0;


    public void serialize(ICustomDataOutput param1) {
         param1.writeVarInt(this.mapRideId);
    }

    public void deserialize(ICustomDataInput param1) {
         this.mapRideId = param1.readVarInt();
    }

}