package com.ankamagames.dofus.network.types.game.context.roleplay;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.dofus.network.types.game.guild.GuildEmblem;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;

public class GuildInAllianceInformations extends GuildInformations implements INetworkType {

    private int protocolId = 420;
    private int nbMembers = 0;


    public int getTypeId() {
         return 420;
    }

    public GuildInAllianceInformations initGuildInAllianceInformations(int param1,String  param2,int  param3,GuildEmblem  param4,int  param5) {
         super.initGuildInformations(param1,param2,param3,param4);
         this.nbMembers = param5;
         return this;
    }

    public void reset() {
         super.reset();
         this.nbMembers = 0;
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_GuildInAllianceInformations(param1);
    }

    public void serializeAs_GuildInAllianceInformations(ICustomDataOutput param1) {
         super.serializeAs_GuildInformations(param1);
         if(this.nbMembers < 1 || this.nbMembers > 240)
         {
            throw new Exception("Forbidden value (" + this.nbMembers + ") on element nbMembers.");
         }
         param1.writeByte(this.nbMembers);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_GuildInAllianceInformations(param1);
    }

    public void deserializeAs_GuildInAllianceInformations(ICustomDataInput param1) {
         super.deserialize(param1);
         this._nbMembersFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_GuildInAllianceInformations(param1);
    }

    public void deserializeAsyncAs_GuildInAllianceInformations(FuncTree param1) {
         super.deserializeAsync(param1);
         param1.addChild(this._nbMembersFunc);
    }

    private void _nbMembersFunc(ICustomDataInput param1) {
         this.nbMembers = param1.readUnsignedByte();
         if(this.nbMembers < 1 || this.nbMembers > 240)
         {
            throw new Exception("Forbidden value (" + this.nbMembers + ") on element of GuildInAllianceInformations.nbMembers.");
         }
    }

}