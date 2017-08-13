package com.ankamagames.dofus.network.messages.security;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class CheckFileRequestMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6154;
    private boolean _isInitialized = false;
    private String filename = "";
    private int type = 0;


    public void serialize(ICustomDataOutput param1) {
         param1.writeUTF(this.filename);
         param1.writeByte(this.type);
    }

    public void deserialize(ICustomDataInput param1) {
         this.filename = param1.readUTF();
         this.type = param1.readByte();
         if(this.type < 0)
         {
            throw new Exception("Forbidden value (" + this.type + ") on element of CheckFileRequestMessage.type.");
         }
    }

}