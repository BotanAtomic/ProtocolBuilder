package com.ankamagames.dofus.network.messages.game.context.mount;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class PaddockBuyRequestMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 5951;
    private boolean _isInitialized = false;
    private Number proposedPrice = 0;


    public void serialize(ICustomDataOutput param1) {
         if(this.proposedPrice < 0 || this.proposedPrice > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.proposedPrice + ") on element proposedPrice.");
         }
         param1.writeVarLong(this.proposedPrice);
    }

    public void deserialize(ICustomDataInput param1) {
         this.proposedPrice = param1.readVarUhLong();
         if(this.proposedPrice < 0 || this.proposedPrice > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.proposedPrice + ") on element of PaddockBuyRequestMessage.proposedPrice.");
         }
    }

}