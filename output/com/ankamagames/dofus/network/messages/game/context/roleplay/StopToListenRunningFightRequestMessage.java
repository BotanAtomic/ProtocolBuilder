package com.ankamagames.dofus.network.messages.game.context.roleplay;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class StopToListenRunningFightRequestMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6124;


    public void serialize(ICustomDataOutput param1) {
    }

    public void deserialize(ICustomDataInput param1) {
    }

}