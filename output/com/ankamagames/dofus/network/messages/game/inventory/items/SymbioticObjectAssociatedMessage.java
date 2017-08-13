package com.ankamagames.dofus.network.messages.game.inventory.items;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class SymbioticObjectAssociatedMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6527;
    private boolean _isInitialized = false;
    private int hostUID = 0;


    public void serialize(ICustomDataOutput param1) {
         if(this.hostUID < 0)
         {
            throw new Exception("Forbidden value (" + this.hostUID + ") on element hostUID.");
         }
         param1.writeVarInt(this.hostUID);
    }

    public void deserialize(ICustomDataInput param1) {
         this.hostUID = param1.readVarUhInt();
         if(this.hostUID < 0)
         {
            throw new Exception("Forbidden value (" + this.hostUID + ") on element of SymbioticObjectAssociatedMessage.hostUID.");
         }
    }

}