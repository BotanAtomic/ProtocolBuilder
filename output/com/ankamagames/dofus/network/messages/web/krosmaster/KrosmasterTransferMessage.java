package com.ankamagames.dofus.network.messages.web.krosmaster;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class KrosmasterTransferMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6348;
    private boolean _isInitialized = false;
    private String uid = "";
    private int failure = 0;


    public void serialize(ICustomDataOutput param1) {
         param1.writeUTF(this.uid);
         param1.writeByte(this.failure);
    }

    public void deserialize(ICustomDataInput param1) {
         this.uid = param1.readUTF();
         this.failure = param1.readByte();
         if(this.failure < 0)
         {
            throw new Exception("Forbidden value (" + this.failure + ") on element of KrosmasterTransferMessage.failure.");
         }
    }

}