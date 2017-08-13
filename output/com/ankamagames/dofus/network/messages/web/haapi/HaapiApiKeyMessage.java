package com.ankamagames.dofus.network.messages.web.haapi;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class HaapiApiKeyMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6649;
    private boolean _isInitialized = false;
    private int returnType = 0;
    private int keyType = 0;
    private String token = "";


    public void serialize(ICustomDataOutput param1) {
         param1.writeByte(this.returnType);
         param1.writeByte(this.keyType);
         param1.writeUTF(this.token);
    }

    public void deserialize(ICustomDataInput param1) {
         this.returnType = param1.readByte();
         if(this.returnType < 0)
         {
            throw new Exception("Forbidden value (" + this.returnType + ") on element of HaapiApiKeyMessage.returnType.");
         }
         this.keyType = param1.readByte();
         if(this.keyType < 0)
         {
            throw new Exception("Forbidden value (" + this.keyType + ") on element of HaapiApiKeyMessage.keyType.");
         }
         this.token = param1.readUTF();
    }

}