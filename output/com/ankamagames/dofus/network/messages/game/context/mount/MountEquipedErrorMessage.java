package com.ankamagames.dofus.network.messages.game.context.mount;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class MountEquipedErrorMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 5963;
    private boolean _isInitialized = false;
    private int errorType = 0;


    public void serialize(ICustomDataOutput param1) {
         param1.writeByte(this.errorType);
    }

    public void deserialize(ICustomDataInput param1) {
         this.errorType = param1.readByte();
         if(this.errorType < 0)
         {
            throw new Exception("Forbidden value (" + this.errorType + ") on element of MountEquipedErrorMessage.errorType.");
         }
    }

}