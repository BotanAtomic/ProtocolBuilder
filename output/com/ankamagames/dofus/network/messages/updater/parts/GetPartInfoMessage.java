package com.ankamagames.dofus.network.messages.updater.parts;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class GetPartInfoMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 1506;
    private boolean _isInitialized = false;
    private String id = "";


    public void serialize(ICustomDataOutput param1) {
         param1.writeUTF(this.id);
    }

    public void deserialize(ICustomDataInput param1) {
         this.id = param1.readUTF();
    }

}