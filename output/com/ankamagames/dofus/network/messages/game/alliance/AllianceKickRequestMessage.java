package com.ankamagames.dofus.network.messages.game.alliance;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class AllianceKickRequestMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6400;
    private boolean _isInitialized = false;
    private int kickedId = 0;


    public void serialize(ICustomDataOutput param1) {
         if(this.kickedId < 0)
         {
            throw new Exception("Forbidden value (" + this.kickedId + ") on element kickedId.");
         }
         param1.writeVarInt(this.kickedId);
    }

    public void deserialize(ICustomDataInput param1) {
         this.kickedId = param1.readVarUhInt();
         if(this.kickedId < 0)
         {
            throw new Exception("Forbidden value (" + this.kickedId + ") on element of AllianceKickRequestMessage.kickedId.");
         }
    }

}