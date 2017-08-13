package com.ankamagames.dofus.network.messages.game.alliance;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class AllianceChangeGuildRightsMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6426;
    private boolean _isInitialized = false;
    private int guildId = 0;
    private int rights = 0;


    public void serialize(ICustomDataOutput param1) {
         if(this.guildId < 0)
         {
            throw new Exception("Forbidden value (" + this.guildId + ") on element guildId.");
         }
         param1.writeVarInt(this.guildId);
         if(this.rights < 0)
         {
            throw new Exception("Forbidden value (" + this.rights + ") on element rights.");
         }
         param1.writeByte(this.rights);
    }

    public void deserialize(ICustomDataInput param1) {
         this.guildId = param1.readVarUhInt();
         if(this.guildId < 0)
         {
            throw new Exception("Forbidden value (" + this.guildId + ") on element of AllianceChangeGuildRightsMessage.guildId.");
         }
         this.rights = param1.readByte();
         if(this.rights < 0)
         {
            throw new Exception("Forbidden value (" + this.rights + ") on element of AllianceChangeGuildRightsMessage.rights.");
         }
    }

}