package com.ankamagames.dofus.network.messages.game.initialization;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class OnConnectionEventMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 5726;
    private boolean _isInitialized = false;
    private int eventType = 0;


    public void serialize(ICustomDataOutput param1) {
         param1.writeByte(this.eventType);
    }

    public void deserialize(ICustomDataInput param1) {
         this.eventType = param1.readByte();
         if(this.eventType < 0)
         {
            throw new Exception("Forbidden value (" + this.eventType + ") on element of OnConnectionEventMessage.eventType.");
         }
    }

}