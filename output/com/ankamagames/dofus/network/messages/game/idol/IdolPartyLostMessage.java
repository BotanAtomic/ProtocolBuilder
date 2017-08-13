package com.ankamagames.dofus.network.messages.game.idol;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class IdolPartyLostMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6580;
    private boolean _isInitialized = false;
    private int idolId = 0;


    public void serialize(ICustomDataOutput param1) {
         if(this.idolId < 0)
         {
            throw new Exception("Forbidden value (" + this.idolId + ") on element idolId.");
         }
         param1.writeVarShort(this.idolId);
    }

    public void deserialize(ICustomDataInput param1) {
         this.idolId = param1.readVarUhShort();
         if(this.idolId < 0)
         {
            throw new Exception("Forbidden value (" + this.idolId + ") on element of IdolPartyLostMessage.idolId.");
         }
    }

}