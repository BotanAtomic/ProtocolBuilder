package com.ankamagames.dofus.network.messages.game.guild.tax;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class GuildFightLeaveRequestMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 5715;
    private boolean _isInitialized = false;
    private int taxCollectorId = 0;
    private Number characterId = 0;


    public void serialize(ICustomDataOutput param1) {
         if(this.taxCollectorId < 0)
         {
            throw new Exception("Forbidden value (" + this.taxCollectorId + ") on element taxCollectorId.");
         }
         param1.writeInt(this.taxCollectorId);
         if(this.characterId < 0 || this.characterId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.characterId + ") on element characterId.");
         }
         param1.writeVarLong(this.characterId);
    }

    public void deserialize(ICustomDataInput param1) {
         this.taxCollectorId = param1.readInt();
         if(this.taxCollectorId < 0)
         {
            throw new Exception("Forbidden value (" + this.taxCollectorId + ") on element of GuildFightLeaveRequestMessage.taxCollectorId.");
         }
         this.characterId = param1.readVarUhLong();
         if(this.characterId < 0 || this.characterId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.characterId + ") on element of GuildFightLeaveRequestMessage.characterId.");
         }
    }

}