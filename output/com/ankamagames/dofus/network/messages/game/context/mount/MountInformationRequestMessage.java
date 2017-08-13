package com.ankamagames.dofus.network.messages.game.context.mount;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class MountInformationRequestMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 5972;
    private boolean _isInitialized = false;
    private Number id = 0;
    private Number time = 0;


    public void serialize(ICustomDataOutput param1) {
         if(this.id < -9.007199254740992E15 || this.id > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.id + ") on element id.");
         }
         param1.writeDouble(this.id);
         if(this.time < -9.007199254740992E15 || this.time > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.time + ") on element time.");
         }
         param1.writeDouble(this.time);
    }

    public void deserialize(ICustomDataInput param1) {
         this.id = param1.readDouble();
         if(this.id < -9.007199254740992E15 || this.id > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.id + ") on element of MountInformationRequestMessage.id.");
         }
         this.time = param1.readDouble();
         if(this.time < -9.007199254740992E15 || this.time > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.time + ") on element of MountInformationRequestMessage.time.");
         }
    }

}