package com.ankamagames.dofus.network.messages.game.moderation;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class PopupWarningMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6134;
    private boolean _isInitialized = false;
    private int lockDuration = 0;
    private String author = "";
    private String content = "";


    public void serialize(ICustomDataOutput param1) {
         if(this.lockDuration < 0 || this.lockDuration > 255)
         {
            throw new Exception("Forbidden value (" + this.lockDuration + ") on element lockDuration.");
         }
         param1.writeByte(this.lockDuration);
         param1.writeUTF(this.author);
         param1.writeUTF(this.content);
    }

    public void deserialize(ICustomDataInput param1) {
         this.lockDuration = param1.readUnsignedByte();
         if(this.lockDuration < 0 || this.lockDuration > 255)
         {
            throw new Exception("Forbidden value (" + this.lockDuration + ") on element of PopupWarningMessage.lockDuration.");
         }
         this.author = param1.readUTF();
         this.content = param1.readUTF();
    }

}