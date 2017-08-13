package com.ankamagames.dofus.network.messages.game.context.mount;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class MountFeedRequestMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6189;
    private boolean _isInitialized = false;
    private int mountUid = 0;
    private int mountLocation = 0;
    private int mountFoodUid = 0;
    private int quantity = 0;


    public void serialize(ICustomDataOutput param1) {
         if(this.mountUid < 0)
         {
            throw new Exception("Forbidden value (" + this.mountUid + ") on element mountUid.");
         }
         param1.writeVarInt(this.mountUid);
         param1.writeByte(this.mountLocation);
         if(this.mountFoodUid < 0)
         {
            throw new Exception("Forbidden value (" + this.mountFoodUid + ") on element mountFoodUid.");
         }
         param1.writeVarInt(this.mountFoodUid);
         if(this.quantity < 0)
         {
            throw new Exception("Forbidden value (" + this.quantity + ") on element quantity.");
         }
         param1.writeVarInt(this.quantity);
    }

    public void deserialize(ICustomDataInput param1) {
         this.mountUid = param1.readVarUhInt();
         if(this.mountUid < 0)
         {
            throw new Exception("Forbidden value (" + this.mountUid + ") on element of MountFeedRequestMessage.mountUid.");
         }
         this.mountLocation = param1.readByte();
         this.mountFoodUid = param1.readVarUhInt();
         if(this.mountFoodUid < 0)
         {
            throw new Exception("Forbidden value (" + this.mountFoodUid + ") on element of MountFeedRequestMessage.mountFoodUid.");
         }
         this.quantity = param1.readVarUhInt();
         if(this.quantity < 0)
         {
            throw new Exception("Forbidden value (" + this.quantity + ") on element of MountFeedRequestMessage.quantity.");
         }
    }

}