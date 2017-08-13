package com.ankamagames.dofus.network.messages.game.inventory.items;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class ObjectQuantityMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 3023;
    private boolean _isInitialized = false;
    private int objectUID = 0;
    private int quantity = 0;


    public void serialize(ICustomDataOutput param1) {
         if(this.objectUID < 0)
         {
            throw new Exception("Forbidden value (" + this.objectUID + ") on element objectUID.");
         }
         param1.writeVarInt(this.objectUID);
         if(this.quantity < 0)
         {
            throw new Exception("Forbidden value (" + this.quantity + ") on element quantity.");
         }
         param1.writeVarInt(this.quantity);
    }

    public void deserialize(ICustomDataInput param1) {
         this.objectUID = param1.readVarUhInt();
         if(this.objectUID < 0)
         {
            throw new Exception("Forbidden value (" + this.objectUID + ") on element of ObjectQuantityMessage.objectUID.");
         }
         this.quantity = param1.readVarUhInt();
         if(this.quantity < 0)
         {
            throw new Exception("Forbidden value (" + this.quantity + ") on element of ObjectQuantityMessage.quantity.");
         }
    }

}