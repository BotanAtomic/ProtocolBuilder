package com.ankamagames.dofus.network.types.game.social;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class GuildInAllianceVersatileInformations extends GuildVersatileInformations implements INetworkType {

    private int protocolId = 437;
    private int allianceId = 0;


    public void serialize(ICustomDataOutput param1) {
         if(this.guildId < 0)
         {
            throw new Exception("Forbidden value (" + this.guildId + ") on element guildId.");
         }
         param1.writeVarInt(this.guildId);
         if(this.leaderId < 0 || this.leaderId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.leaderId + ") on element leaderId.");
         }
         param1.writeVarLong(this.leaderId);
         if(this.guildLevel < 1 || this.guildLevel > 200)
         {
            throw new Exception("Forbidden value (" + this.guildLevel + ") on element guildLevel.");
         }
         param1.writeByte(this.guildLevel);
         if(this.nbMembers < 1 || this.nbMembers > 240)
         {
            throw new Exception("Forbidden value (" + this.nbMembers + ") on element nbMembers.");
         }
         param1.writeByte(this.nbMembers);
         if(this.allianceId < 0)
         {
            throw new Exception("Forbidden value (" + this.allianceId + ") on element allianceId.");
         }
         param1.writeVarInt(this.allianceId);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_GuildVersatileInformations(param1);
         this.allianceId = param1.readVarUhInt();
         if(this.allianceId < 0)
         {
            throw new Exception("Forbidden value (" + this.allianceId + ") on element of GuildInAllianceVersatileInformations.allianceId.");
         }
    }

}