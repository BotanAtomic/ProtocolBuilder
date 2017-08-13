package com.ankamagames.dofus.network.messages.game.context.roleplay.houses;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class HouseSellRequestMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 5697;
    private boolean _isInitialized = false;
    private int instanceId = 0;
    private Number amount = 0;
    private boolean forSale = false;


    public void serialize(ICustomDataOutput param1) {
         if(this.instanceId < 0)
         {
            throw new Exception("Forbidden value (" + this.instanceId + ") on element instanceId.");
         }
         param1.writeInt(this.instanceId);
         if(this.amount < 0 || this.amount > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.amount + ") on element amount.");
         }
         param1.writeVarLong(this.amount);
         param1.writeBoolean(this.forSale);
    }

    public void deserialize(ICustomDataInput param1) {
         this.instanceId = param1.readInt();
         if(this.instanceId < 0)
         {
            throw new Exception("Forbidden value (" + this.instanceId + ") on element of HouseSellRequestMessage.instanceId.");
         }
         this.amount = param1.readVarUhLong();
         if(this.amount < 0 || this.amount > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.amount + ") on element of HouseSellRequestMessage.amount.");
         }
         this.forSale = param1.readBoolean();
    }

}