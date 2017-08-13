package com.ankamagames.dofus.network.messages.game.inventory.items;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class ObjectFeedMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6290;
    private boolean _isInitialized = false;
    private int objectUID = 0;
    private int foodUID = 0;
    private int foodQuantity = 0;


    public void serialize(ICustomDataOutput param1) {
         if(this.objectUID < 0)
         {
            throw new Exception("Forbidden value (" + this.objectUID + ") on element objectUID.");
         }
         param1.writeVarInt(this.objectUID);
         if(this.foodUID < 0)
         {
            throw new Exception("Forbidden value (" + this.foodUID + ") on element foodUID.");
         }
         param1.writeVarInt(this.foodUID);
         if(this.foodQuantity < 0)
         {
            throw new Exception("Forbidden value (" + this.foodQuantity + ") on element foodQuantity.");
         }
         param1.writeVarInt(this.foodQuantity);
    }

    public void deserialize(ICustomDataInput param1) {
         this.objectUID = param1.readVarUhInt();
         if(this.objectUID < 0)
         {
            throw new Exception("Forbidden value (" + this.objectUID + ") on element of ObjectFeedMessage.objectUID.");
         }
         this.foodUID = param1.readVarUhInt();
         if(this.foodUID < 0)
         {
            throw new Exception("Forbidden value (" + this.foodUID + ") on element of ObjectFeedMessage.foodUID.");
         }
         this.foodQuantity = param1.readVarUhInt();
         if(this.foodQuantity < 0)
         {
            throw new Exception("Forbidden value (" + this.foodQuantity + ") on element of ObjectFeedMessage.foodQuantity.");
         }
    }

}