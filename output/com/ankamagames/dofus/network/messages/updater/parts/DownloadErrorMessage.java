package com.ankamagames.dofus.network.messages.updater.parts;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class DownloadErrorMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 1513;
    private boolean _isInitialized = false;
    private int errorId = 0;
    private String message = "";
    private String helpUrl = "";


    public void serialize(ICustomDataOutput param1) {
         param1.writeByte(this.errorId);
         param1.writeUTF(this.message);
         param1.writeUTF(this.helpUrl);
    }

    public void deserialize(ICustomDataInput param1) {
         this.errorId = param1.readByte();
         if(this.errorId < 0)
         {
            throw new Exception("Forbidden value (" + this.errorId + ") on element of DownloadErrorMessage.errorId.");
         }
         this.message = param1.readUTF();
         this.helpUrl = param1.readUTF();
    }

}