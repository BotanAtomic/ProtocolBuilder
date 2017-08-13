package com.ankamagames.dofus.network.messages.game.script;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class CinematicMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6053;
    private boolean _isInitialized = false;
    private int cinematicId = 0;


    public void serialize(ICustomDataOutput param1) {
         if(this.cinematicId < 0)
         {
            throw new Exception("Forbidden value (" + this.cinematicId + ") on element cinematicId.");
         }
         param1.writeVarShort(this.cinematicId);
    }

    public void deserialize(ICustomDataInput param1) {
         this.cinematicId = param1.readVarUhShort();
         if(this.cinematicId < 0)
         {
            throw new Exception("Forbidden value (" + this.cinematicId + ") on element of CinematicMessage.cinematicId.");
         }
    }

}