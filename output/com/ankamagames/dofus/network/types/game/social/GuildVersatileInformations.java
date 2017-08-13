package com.ankamagames.dofus.network.types.game.social;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class GuildVersatileInformations extends Object implements INetworkType {

    private int protocolId = 435;
    private int guildId = 0;
    private Number leaderId = 0;
    private int guildLevel = 0;
    private int nbMembers = 0;


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
    }

    public void deserialize(ICustomDataInput param1) {
         this.guildId = param1.readVarUhInt();
         if(this.guildId < 0)
         {
            throw new Exception("Forbidden value (" + this.guildId + ") on element of GuildVersatileInformations.guildId.");
         }
         this.leaderId = param1.readVarUhLong();
         if(this.leaderId < 0 || this.leaderId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.leaderId + ") on element of GuildVersatileInformations.leaderId.");
         }
         this.guildLevel = param1.readUnsignedByte();
         if(this.guildLevel < 1 || this.guildLevel > 200)
         {
            throw new Exception("Forbidden value (" + this.guildLevel + ") on element of GuildVersatileInformations.guildLevel.");
         }
         this.nbMembers = param1.readUnsignedByte();
         if(this.nbMembers < 1 || this.nbMembers > 240)
         {
            throw new Exception("Forbidden value (" + this.nbMembers + ") on element of GuildVersatileInformations.nbMembers.");
         }
    }

}