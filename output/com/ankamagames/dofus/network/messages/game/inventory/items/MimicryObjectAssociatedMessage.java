package com.ankamagames.dofus.network.messages.game.inventory.items;

import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class MimicryObjectAssociatedMessage extends SymbioticObjectAssociatedMessage implements INetworkMessage {

    private int protocolId = 6462;
    private boolean _isInitialized = false;


    public void serialize(ICustomDataOutput param1) {
         if(this.hostUID < 0)
         {
            throw new Exception("Forbidden value (" + this.hostUID + ") on element hostUID.");
         }
         param1.writeVarInt(this.hostUID);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_SymbioticObjectAssociatedMessage(param1);
    }

}