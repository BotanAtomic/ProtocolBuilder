package com.ankamagames.dofus.network.messages.game.guild;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class GuildFactsRequestMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6404;
    private boolean _isInitialized = false;
    private int guildId = 0;


    public void serialize(ICustomDataOutput param1) {
         if(this.guildId < 0)
         {
            throw new Exception("Forbidden value (" + this.guildId + ") on element guildId.");
         }
         param1.writeVarInt(this.guildId);
    }

    public void deserialize(ICustomDataInput param1) {
         this.guildId = param1.readVarUhInt();
         if(this.guildId < 0)
         {
            throw new Exception("Forbidden value (" + this.guildId + ") on element of GuildFactsRequestMessage.guildId.");
         }
    }

}