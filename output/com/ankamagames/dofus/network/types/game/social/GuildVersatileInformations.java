package com.ankamagames.dofus.network.types.game.social;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;

public class GuildVersatileInformations extends Object implements INetworkType {

    private int protocolId = 435;
    private int guildId = 0;
    private Number leaderId = 0;
    private int guildLevel = 0;
    private int nbMembers = 0;


    public int getTypeId() {
         return 435;
    }

    public GuildVersatileInformations initGuildVersatileInformations(int param1,Number  param2,int  param3,int  param4) {
         this.guildId = param1;
         this.leaderId = param2;
         this.guildLevel = param3;
         this.nbMembers = param4;
         return this;
    }

    public void reset() {
         this.guildId = 0;
         this.leaderId = 0;
         this.guildLevel = 0;
         this.nbMembers = 0;
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_GuildVersatileInformations(param1);
    }

    public void serializeAs_GuildVersatileInformations(ICustomDataOutput param1) {
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
         this.deserializeAs_GuildVersatileInformations(param1);
    }

    public void deserializeAs_GuildVersatileInformations(ICustomDataInput param1) {
         this._guildIdFunc(param1);
         this._leaderIdFunc(param1);
         this._guildLevelFunc(param1);
         this._nbMembersFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_GuildVersatileInformations(param1);
    }

    public void deserializeAsyncAs_GuildVersatileInformations(FuncTree param1) {
         param1.addChild(this._guildIdFunc);
         param1.addChild(this._leaderIdFunc);
         param1.addChild(this._guildLevelFunc);
         param1.addChild(this._nbMembersFunc);
    }

    private void _guildIdFunc(ICustomDataInput param1) {
         this.guildId = param1.readVarUhInt();
         if(this.guildId < 0)
         {
            throw new Exception("Forbidden value (" + this.guildId + ") on element of GuildVersatileInformations.guildId.");
         }
    }

    private void _leaderIdFunc(ICustomDataInput param1) {
         this.leaderId = param1.readVarUhLong();
         if(this.leaderId < 0 || this.leaderId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.leaderId + ") on element of GuildVersatileInformations.leaderId.");
         }
    }

    private void _guildLevelFunc(ICustomDataInput param1) {
         this.guildLevel = param1.readUnsignedByte();
         if(this.guildLevel < 1 || this.guildLevel > 200)
         {
            throw new Exception("Forbidden value (" + this.guildLevel + ") on element of GuildVersatileInformations.guildLevel.");
         }
    }

    private void _nbMembersFunc(ICustomDataInput param1) {
         this.nbMembers = param1.readUnsignedByte();
         if(this.nbMembers < 1 || this.nbMembers > 240)
         {
            throw new Exception("Forbidden value (" + this.nbMembers + ") on element of GuildVersatileInformations.nbMembers.");
         }
    }

}