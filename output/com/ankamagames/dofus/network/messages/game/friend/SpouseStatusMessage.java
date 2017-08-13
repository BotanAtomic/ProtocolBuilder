package com.ankamagames.dofus.network.messages.game.friend;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class SpouseStatusMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6265;
    private boolean _isInitialized = false;
    private boolean hasSpouse = false;


    public void serialize(ICustomDataOutput param1) {
         param1.writeBoolean(this.hasSpouse);
    }

    public void deserialize(ICustomDataInput param1) {
         this.hasSpouse = param1.readBoolean();
    }

}