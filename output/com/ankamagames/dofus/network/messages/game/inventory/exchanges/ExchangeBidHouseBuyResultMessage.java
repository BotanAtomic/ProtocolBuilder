package com.ankamagames.dofus.network.messages.game.inventory.exchanges;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class ExchangeBidHouseBuyResultMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6272;
    private boolean _isInitialized = false;
    private int uid = 0;
    private boolean bought = false;


    public void serialize(ICustomDataOutput param1) {
         if(this.uid < 0)
         {
            throw new Exception("Forbidden value (" + this.uid + ") on element uid.");
         }
         param1.writeVarInt(this.uid);
         param1.writeBoolean(this.bought);
    }

    public void deserialize(ICustomDataInput param1) {
         this.uid = param1.readVarUhInt();
         if(this.uid < 0)
         {
            throw new Exception("Forbidden value (" + this.uid + ") on element of ExchangeBidHouseBuyResultMessage.uid.");
         }
         this.bought = param1.readBoolean();
    }

}