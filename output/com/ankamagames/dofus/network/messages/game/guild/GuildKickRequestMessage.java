package com.ankamagames.dofus.network.messages.game.guild;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class GuildKickRequestMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 5887;
    private boolean _isInitialized = false;
    private Number kickedId = 0;


    public void serialize(ICustomDataOutput param1) {
         if(this.kickedId < 0 || this.kickedId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.kickedId + ") on element kickedId.");
         }
         param1.writeVarLong(this.kickedId);
    }

    public void deserialize(ICustomDataInput param1) {
         this.kickedId = param1.readVarUhLong();
         if(this.kickedId < 0 || this.kickedId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.kickedId + ") on element of GuildKickRequestMessage.kickedId.");
         }
    }

}