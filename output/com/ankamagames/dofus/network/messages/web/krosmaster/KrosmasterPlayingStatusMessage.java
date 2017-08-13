package com.ankamagames.dofus.network.messages.web.krosmaster;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class KrosmasterPlayingStatusMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6347;
    private boolean _isInitialized = false;
    private boolean playing = false;


    public void serialize(ICustomDataOutput param1) {
         param1.writeBoolean(this.playing);
    }

    public void deserialize(ICustomDataInput param1) {
         this.playing = param1.readBoolean();
    }

}