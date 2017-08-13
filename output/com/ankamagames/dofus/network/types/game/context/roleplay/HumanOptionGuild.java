package com.ankamagames.dofus.network.types.game.context.roleplay;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class HumanOptionGuild extends HumanOption implements INetworkType {

    private int protocolId = 409;
    private GuildInformations guildInformations;
    private FuncTree _guildInformationstree;


    public void serialize(ICustomDataOutput param1) {
         this.guildInformations.serializeAs_GuildInformations(param1);
    }

    public void deserialize(ICustomDataInput param1) {
         this.guildInformations = new GuildInformations();
         this.guildInformations.deserialize(param1);
    }

}