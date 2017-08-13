package com.ankamagames.dofus.network.types.game.context.roleplay;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class HumanOptionGuild extends HumanOption implements INetworkType {

    private int protocolId = 409;
    private GuildInformations guildInformations;
    private FuncTree _guildInformationstree;


    public int getTypeId() {
         return 409;
    }

    public HumanOptionGuild initHumanOptionGuild(GuildInformations param1) {
         this.guildInformations = param1;
         return this;
    }

    public void reset() {
         this.guildInformations = new GuildInformations();
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_HumanOptionGuild(param1);
    }

    public void serializeAs_HumanOptionGuild(ICustomDataOutput param1) {
         super.serializeAs_HumanOption(param1);
         this.guildInformations.serializeAs_GuildInformations(param1);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_HumanOptionGuild(param1);
    }

    public void deserializeAs_HumanOptionGuild(ICustomDataInput param1) {
         super.deserialize(param1);
         this.guildInformations = new GuildInformations();
         this.guildInformations.deserialize(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_HumanOptionGuild(param1);
    }

    public void deserializeAsyncAs_HumanOptionGuild(FuncTree param1) {
         super.deserializeAsync(param1);
         this._guildInformationstree = param1.addChild(this._guildInformationstreeFunc);
    }

    private void _guildInformationstreeFunc(ICustomDataInput param1) {
         this.guildInformations = new GuildInformations();
         this.guildInformations.deserializeAsync(this._guildInformationstree);
    }

}