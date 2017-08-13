package com.ankamagames.dofus.network.messages.connection.search;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class AcquaintanceSearchMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6144;
    private boolean _isInitialized = false;
    private String nickname = "";


    public void serialize(ICustomDataOutput param1) {
         param1.writeUTF(this.nickname);
    }

    public void deserialize(ICustomDataInput param1) {
         this.nickname = param1.readUTF();
    }

}