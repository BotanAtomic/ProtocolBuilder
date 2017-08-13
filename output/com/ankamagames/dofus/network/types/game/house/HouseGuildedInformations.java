package package com.ankamagames.dofus.network.types.game.house;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.dofus.network.types.game.context.roleplay.GuildInformations;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class HouseGuildedInformations extends HouseInstanceInformations implements INetworkType {

    private int protocolId = 512;
    private GuildInformations guildInfo = ;
    private FuncTree _guildInfotree = ;


    public int getTypeId() {
         return 512;
    }

    public HouseGuildedInformations initHouseGuildedInformations(int param1,boolean  param2,boolean  param3,String  param4,Number  param5,boolean  param6,GuildInformations  param7) {
         super.initHouseInstanceInformations(param1,param2,param3,param4,param5,param6);
         this.guildInfo = param7;
         return this;
    }

    public void reset() {
         super.reset();
         this.guildInfo = new GuildInformations();
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_HouseGuildedInformations(param1);
    }

    public void serializeAs_HouseGuildedInformations(ICustomDataOutput param1) {
         super.serializeAs_HouseInstanceInformations(param1);
         this.guildInfo.serializeAs_GuildInformations(param1);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_HouseGuildedInformations(param1);
    }

    public void deserializeAs_HouseGuildedInformations(ICustomDataInput param1) {
         super.deserialize(param1);
         this.guildInfo = new GuildInformations();
         this.guildInfo.deserialize(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_HouseGuildedInformations(param1);
    }

    public void deserializeAsyncAs_HouseGuildedInformations(FuncTree param1) {
         super.deserializeAsync(param1);
         this._guildInfotree = param1.addChild(this._guildInfotreeFunc);
    }

    private void _guildInfotreeFunc(ICustomDataInput param1) {
         this.guildInfo = new GuildInformations();
         this.guildInfo.deserializeAsync(this._guildInfotree);
    }

}