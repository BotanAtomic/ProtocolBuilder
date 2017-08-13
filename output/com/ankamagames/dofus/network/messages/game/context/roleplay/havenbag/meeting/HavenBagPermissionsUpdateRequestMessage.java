package com.ankamagames.dofus.network.messages.game.context.roleplay.havenbag.meeting;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class HavenBagPermissionsUpdateRequestMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6714;
    private boolean _isInitialized = false;
    private int permissions = 0;


    public void serialize(ICustomDataOutput param1) {
         if(this.permissions < 0)
         {
            throw new Exception("Forbidden value (" + this.permissions + ") on element permissions.");
         }
         param1.writeInt(this.permissions);
    }

    public void deserialize(ICustomDataInput param1) {
         this.permissions = param1.readInt();
         if(this.permissions < 0)
         {
            throw new Exception("Forbidden value (" + this.permissions + ") on element of HavenBagPermissionsUpdateRequestMessage.permissions.");
         }
    }

}