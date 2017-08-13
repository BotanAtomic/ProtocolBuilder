package com.ankamagames.dofus.network.messages.game.inventory.exchanges;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class RecycleResultMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6601;
    private boolean _isInitialized = false;
    private int nuggetsForPrism = 0;
    private int nuggetsForPlayer = 0;


    public void serialize(ICustomDataOutput param1) {
         if(this.nuggetsForPrism < 0)
         {
            throw new Exception("Forbidden value (" + this.nuggetsForPrism + ") on element nuggetsForPrism.");
         }
         param1.writeVarInt(this.nuggetsForPrism);
         if(this.nuggetsForPlayer < 0)
         {
            throw new Exception("Forbidden value (" + this.nuggetsForPlayer + ") on element nuggetsForPlayer.");
         }
         param1.writeVarInt(this.nuggetsForPlayer);
    }

    public void deserialize(ICustomDataInput param1) {
         this.nuggetsForPrism = param1.readVarUhInt();
         if(this.nuggetsForPrism < 0)
         {
            throw new Exception("Forbidden value (" + this.nuggetsForPrism + ") on element of RecycleResultMessage.nuggetsForPrism.");
         }
         this.nuggetsForPlayer = param1.readVarUhInt();
         if(this.nuggetsForPlayer < 0)
         {
            throw new Exception("Forbidden value (" + this.nuggetsForPlayer + ") on element of RecycleResultMessage.nuggetsForPlayer.");
         }
    }

}