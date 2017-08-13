package com.ankamagames.dofus.network.messages.game.look;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class AccessoryPreviewErrorMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6521;
    private boolean _isInitialized = false;
    private int error = 0;


    public void serialize(ICustomDataOutput param1) {
         param1.writeByte(this.error);
    }

    public void deserialize(ICustomDataInput param1) {
         this.error = param1.readByte();
         if(this.error < 0)
         {
            throw new Exception("Forbidden value (" + this.error + ") on element of AccessoryPreviewErrorMessage.error.");
         }
    }

}