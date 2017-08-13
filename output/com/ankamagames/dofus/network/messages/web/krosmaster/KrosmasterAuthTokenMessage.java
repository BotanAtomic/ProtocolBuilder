package com.ankamagames.dofus.network.messages.web.krosmaster;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class KrosmasterAuthTokenMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6351;
    private boolean _isInitialized = false;
    private String token = "";


    public void serialize(ICustomDataOutput param1) {
         param1.writeUTF(this.token);
    }

    public void deserialize(ICustomDataInput param1) {
         this.token = param1.readUTF();
    }

}