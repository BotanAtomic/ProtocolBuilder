package com.ankamagames.dofus.network.messages.web.haapi;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class HaapiApiKeyRequestMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6648;
    private boolean _isInitialized = false;
    private int keyType = 0;


    public void serialize(ICustomDataOutput param1) {
         param1.writeByte(this.keyType);
    }

    public void deserialize(ICustomDataInput param1) {
         this.keyType = param1.readByte();
         if(this.keyType < 0)
         {
            throw new Exception("Forbidden value (" + this.keyType + ") on element of HaapiApiKeyRequestMessage.keyType.");
         }
    }

}