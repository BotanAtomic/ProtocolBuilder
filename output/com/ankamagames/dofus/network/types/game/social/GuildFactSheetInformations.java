package com.ankamagames.dofus.network.types.game.social;

import com.ankamagames.dofus.network.types.game.context.roleplay.GuildInformations;
import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.dofus.network.types.game.guild.GuildEmblem;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;

public class GuildFactSheetInformations extends GuildInformations implements INetworkType {

    private int protocolId = 424;
    private Number leaderId = 0;
    private int nbMembers = 0;


    public int getTypeId() {
         return 424;
    }

    public GuildFactSheetInformations initGuildFactSheetInformations(int param1,String  param2,int  param3,GuildEmblem  param4,Number  param5,int  param6) {
         super.initGuildInformations(param1,param2,param3,param4);
         this.leaderId = param5;
         this.nbMembers = param6;
         return this;
    }

    public void reset() {
         super.reset();
         this.leaderId = 0;
         this.nbMembers = 0;
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_GuildFactSheetInformations(param1);
    }

    public void serializeAs_GuildFactSheetInformations(ICustomDataOutput param1) {
         super.serializeAs_GuildInformations(param1);
         if(this.leaderId < 0 || this.leaderId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.leaderId + ") on element leaderId.");
         }
         param1.writeVarLong(this.leaderId);
         if(this.nbMembers < 0)
         {
            throw new Exception("Forbidden value (" + this.nbMembers + ") on element nbMembers.");
         }
         param1.writeVarShort(this.nbMembers);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_GuildFactSheetInformations(param1);
    }

    public void deserializeAs_GuildFactSheetInformations(ICustomDataInput param1) {
         super.deserialize(param1);
         this._leaderIdFunc(param1);
         this._nbMembersFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_GuildFactSheetInformations(param1);
    }

    public void deserializeAsyncAs_GuildFactSheetInformations(FuncTree param1) {
         super.deserializeAsync(param1);
         param1.addChild(this._leaderIdFunc);
         param1.addChild(this._nbMembersFunc);
    }

    private void _leaderIdFunc(ICustomDataInput param1) {
         this.leaderId = param1.readVarUhLong();
         if(this.leaderId < 0 || this.leaderId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.leaderId + ") on element of GuildFactSheetInformations.leaderId.");
         }
    }

    private void _nbMembersFunc(ICustomDataInput param1) {
         this.nbMembers = param1.readVarUhShort();
         if(this.nbMembers < 0)
         {
            throw new Exception("Forbidden value (" + this.nbMembers + ") on element of GuildFactSheetInformations.nbMembers.");
         }
    }

}