package com.ankamagames.dofus.network.messages.game.house;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class HouseTeleportRequestMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6726;
    private boolean _isInitialized = false;
    private int houseId = 0;
    private int houseInstanceId = 0;


    public void serialize(ICustomDataOutput param1) {
         if(this.houseId < 0)
         {
            throw new Exception("Forbidden value (" + this.houseId + ") on element houseId.");
         }
         param1.writeVarInt(this.houseId);
         param1.writeInt(this.houseInstanceId);
    }

    public void deserialize(ICustomDataInput param1) {
         this.houseId = param1.readVarUhInt();
         if(this.houseId < 0)
         {
            throw new Exception("Forbidden value (" + this.houseId + ") on element of HouseTeleportRequestMessage.houseId.");
         }
         this.houseInstanceId = param1.readInt();
    }

}