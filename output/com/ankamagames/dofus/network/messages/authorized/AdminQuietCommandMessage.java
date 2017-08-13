package com.ankamagames.dofus.network.messages.authorized;

import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class AdminQuietCommandMessage extends AdminCommandMessage implements INetworkMessage {

    private int protocolId = 5662;
    private boolean _isInitialized = false;


    public void serialize(ICustomDataOutput param1) {
         param1.writeUTF(this.content);
    }

    public void deserialize(ICustomDataInput param1) {
         this.content = param1.readUTF();
    }

}