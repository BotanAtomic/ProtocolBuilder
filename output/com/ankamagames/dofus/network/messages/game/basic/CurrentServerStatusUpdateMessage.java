package com.ankamagames.dofus.network.messages.game.basic;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class CurrentServerStatusUpdateMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6525;
    private boolean _isInitialized = false;
    private int status = 1;


    public void serialize(ICustomDataOutput param1) {
         param1.writeByte(this.status);
    }

    public void deserialize(ICustomDataInput param1) {
         this.status = param1.readByte();
         if(this.status < 0)
         {
            throw new Exception("Forbidden value (" + this.status + ") on element of CurrentServerStatusUpdateMessage.status.");
         }
    }

}