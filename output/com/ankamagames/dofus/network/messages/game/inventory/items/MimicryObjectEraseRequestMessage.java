package com.ankamagames.dofus.network.messages.game.inventory.items;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class MimicryObjectEraseRequestMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6457;
    private boolean _isInitialized = false;
    private int hostUID = 0;
    private int hostPos = 0;


    public void serialize(ICustomDataOutput param1) {
         if(this.hostUID < 0)
         {
            throw new Exception("Forbidden value (" + this.hostUID + ") on element hostUID.");
         }
         param1.writeVarInt(this.hostUID);
         if(this.hostPos < 0 || this.hostPos > 255)
         {
            throw new Exception("Forbidden value (" + this.hostPos + ") on element hostPos.");
         }
         param1.writeByte(this.hostPos);
    }

    public void deserialize(ICustomDataInput param1) {
         this.hostUID = param1.readVarUhInt();
         if(this.hostUID < 0)
         {
            throw new Exception("Forbidden value (" + this.hostUID + ") on element of MimicryObjectEraseRequestMessage.hostUID.");
         }
         this.hostPos = param1.readUnsignedByte();
         if(this.hostPos < 0 || this.hostPos > 255)
         {
            throw new Exception("Forbidden value (" + this.hostPos + ") on element of MimicryObjectEraseRequestMessage.hostPos.");
         }
    }

}