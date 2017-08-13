package com.ankamagames.dofus.network.messages.game.inventory.exchanges;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class ExchangeBidHouseTypeMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 5803;
    private boolean _isInitialized = false;
    private int type = 0;


    public void serialize(ICustomDataOutput param1) {
         if(this.type < 0)
         {
            throw new Exception("Forbidden value (" + this.type + ") on element type.");
         }
         param1.writeVarInt(this.type);
    }

    public void deserialize(ICustomDataInput param1) {
         this.type = param1.readVarUhInt();
         if(this.type < 0)
         {
            throw new Exception("Forbidden value (" + this.type + ") on element of ExchangeBidHouseTypeMessage.type.");
         }
    }

}