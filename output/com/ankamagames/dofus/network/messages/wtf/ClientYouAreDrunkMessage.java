package com.ankamagames.dofus.network.messages.wtf;

import com.ankamagames.dofus.network.messages.debug.DebugInClientMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class ClientYouAreDrunkMessage extends DebugInClientMessage implements INetworkMessage {

    private int protocolId = 6594;
    private boolean _isInitialized = false;


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