package com.ankamagames.dofus.network.messages.connection;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class SelectedServerRefusedMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 41;
    private boolean _isInitialized = false;
    private int serverId = 0;
    private int error = 1;
    private int serverStatus = 1;


    public void serialize(ICustomDataOutput param1) {
         if(this.serverId < 0)
         {
            throw new Exception("Forbidden value (" + this.serverId + ") on element serverId.");
         }
         param1.writeVarShort(this.serverId);
         param1.writeByte(this.error);
         param1.writeByte(this.serverStatus);
    }

    public void deserialize(ICustomDataInput param1) {
         this.serverId = param1.readVarUhShort();
         if(this.serverId < 0)
         {
            throw new Exception("Forbidden value (" + this.serverId + ") on element of SelectedServerRefusedMessage.serverId.");
         }
         this.error = param1.readByte();
         if(this.error < 0)
         {
            throw new Exception("Forbidden value (" + this.error + ") on element of SelectedServerRefusedMessage.error.");
         }
         this.serverStatus = param1.readByte();
         if(this.serverStatus < 0)
         {
            throw new Exception("Forbidden value (" + this.serverStatus + ") on element of SelectedServerRefusedMessage.serverStatus.");
         }
    }

}