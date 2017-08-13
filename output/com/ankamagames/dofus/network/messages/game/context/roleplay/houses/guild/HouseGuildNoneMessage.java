package com.ankamagames.dofus.network.messages.game.context.roleplay.houses.guild;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class HouseGuildNoneMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 5701;
    private boolean _isInitialized = false;
    private int houseId = 0;
    private int instanceId = 0;
    private boolean secondHand = false;


    public void serialize(ICustomDataOutput param1) {
         if(this.houseId < 0)
         {
            throw new Exception("Forbidden value (" + this.houseId + ") on element houseId.");
         }
         param1.writeVarInt(this.houseId);
         if(this.instanceId < 0)
         {
            throw new Exception("Forbidden value (" + this.instanceId + ") on element instanceId.");
         }
         param1.writeInt(this.instanceId);
         param1.writeBoolean(this.secondHand);
    }

    public void deserialize(ICustomDataInput param1) {
         this.houseId = param1.readVarUhInt();
         if(this.houseId < 0)
         {
            throw new Exception("Forbidden value (" + this.houseId + ") on element of HouseGuildNoneMessage.houseId.");
         }
         this.instanceId = param1.readInt();
         if(this.instanceId < 0)
         {
            throw new Exception("Forbidden value (" + this.instanceId + ") on element of HouseGuildNoneMessage.instanceId.");
         }
         this.secondHand = param1.readBoolean();
    }

}