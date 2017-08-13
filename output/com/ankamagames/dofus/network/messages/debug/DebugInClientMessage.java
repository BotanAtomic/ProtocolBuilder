package com.ankamagames.dofus.network.messages.debug;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class DebugInClientMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6028;
    private boolean _isInitialized = false;
    private int level = 0;
    private String message = "";


    public void serialize(ICustomDataOutput param1) {
         param1.writeByte(this.level);
         param1.writeUTF(this.message);
    }

    public void deserialize(ICustomDataInput param1) {
         this.level = param1.readByte();
         if(this.level < 0)
         {
            throw new Exception("Forbidden value (" + this.level + ") on element of DebugInClientMessage.level.");
         }
         this.message = param1.readUTF();
    }

}