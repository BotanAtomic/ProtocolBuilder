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


    public void serialize(ICustomDataOutput param1) {
         super.serializeAs_BasicGuildInformations(param1);
         this.guildEmblem.serializeAs_GuildEmblem(param1);
    }

    public void deserialize(ICustomDataInput param1) {
         this.quiet = param1.readBoolean();
         this.guildEmblem = new GuildEmblem();
         this.guildEmblem.deserialize(param1);
    }

}