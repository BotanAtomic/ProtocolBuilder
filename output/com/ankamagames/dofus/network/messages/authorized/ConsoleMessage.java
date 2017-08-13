package com.ankamagames.dofus.network.messages.authorized;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class ConsoleMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 75;
    private boolean _isInitialized = false;
    private int type = 0;
    private String content = "";


    public void serialize(ICustomDataOutput param1) {
         param1.writeByte(this.type);
         param1.writeUTF(this.content);
    }

    public void deserialize(ICustomDataInput param1) {
         this.type = param1.readByte();
         if(this.type < 0)
         {
            throw new Exception("Forbidden value (" + this.type + ") on element of ConsoleMessage.type.");
         }
         this.content = param1.readUTF();
    }

}