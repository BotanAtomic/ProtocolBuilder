package com.ankamagames.dofus.network.types.game.context.roleplay;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.dofus.network.types.game.guild.GuildEmblem;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class GuildInformations extends Basic {

    private int protocolId = 127;
    private GuildEmblem guildEmblem;
    private FuncTree _guildEmblemtree;


    public int getTypeId() {
         return 127;
    }

    public GuildInformations initGuildInformations(int param1,String  param2,int  param3,GuildEmblem  param4) {
         super.initBasicGuildInformations(param1,param2,param3);
         this.guildEmblem = param4;
         return this;
    }

    public void reset() {
         super.reset();
         this.guildEmblem = new GuildEmblem();
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_GuildInformations(param1);
    }

    public void serializeAs_GuildInformations(ICustomDataOutput param1) {
         super.serializeAs_BasicGuildInformations(param1);
         this.guildEmblem.serializeAs_GuildEmblem(param1);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_GuildInformations(param1);
    }

    public void deserializeAs_GuildInformations(ICustomDataInput param1) {
         super.deserialize(param1);
         this.guildEmblem = new GuildEmblem();
         this.guildEmblem.deserialize(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_GuildInformations(param1);
    }

    public void deserializeAsyncAs_GuildInformations(FuncTree param1) {
         super.deserializeAsync(param1);
         this._guildEmblemtree = param1.addChild(this._guildEmblemtreeFunc);
    }

    private void _guildEmblemtreeFunc(ICustomDataInput param1) {
         this.guildEmblem = new GuildEmblem();
         this.guildEmblem.deserializeAsync(this._guildEmblemtree);
    }

}