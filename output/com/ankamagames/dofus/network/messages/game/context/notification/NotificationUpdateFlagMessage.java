package com.ankamagames.dofus.network.messages.game.context.notification;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class NotificationUpdateFlagMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6090;
    private boolean _isInitialized = false;
    private int index = 0;


    public void serialize(ICustomDataOutput param1) {
         if(this.index < 0)
         {
            throw new Exception("Forbidden value (" + this.index + ") on element index.");
         }
         param1.writeVarShort(this.index);
    }

    public void deserialize(ICustomDataInput param1) {
         this.index = param1.readVarUhShort();
         if(this.index < 0)
         {
            throw new Exception("Forbidden value (" + this.index + ") on element of NotificationUpdateFlagMessage.index.");
         }
    }

}