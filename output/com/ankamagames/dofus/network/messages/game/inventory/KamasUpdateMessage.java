package com.ankamagames.dofus.network.messages.game.inventory;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class KamasUpdateMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 5537;
    private boolean _isInitialized = false;
    private Number kamasTotal = 0;


    public void serialize(ICustomDataOutput param1) {
         if(this.kamasTotal < 0 || this.kamasTotal > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.kamasTotal + ") on element kamasTotal.");
         }
         param1.writeVarLong(this.kamasTotal);
    }

    public void deserialize(ICustomDataInput param1) {
         this.kamasTotal = param1.readVarUhLong();
         if(this.kamasTotal < 0 || this.kamasTotal > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.kamasTotal + ") on element of KamasUpdateMessage.kamasTotal.");
         }
    }

}