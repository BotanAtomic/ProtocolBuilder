package com.ankamagames.dofus.network.types.game.paddock;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.dofus.network.types.game.context.roleplay.GuildInformations;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class PaddockGuildedInformations extends PaddockBuyableInformations implements INetworkType {

    private int protocolId = 508;
    private boolean deserted = false;
    private GuildInformations guildInfo;
    private FuncTree _guildInfotree;


    public int getTypeId() {
         return 508;
    }

    public PaddockGuildedInformations initPaddockGuildedInformations(Number param1,boolean  param2,boolean  param3,GuildInformations  param4) {
         super.initPaddockBuyableInformations(param1,param2);
         this.deserted = param3;
         this.guildInfo = param4;
         return this;
    }

    public void reset() {
         super.reset();
         this.deserted = false;
         this.guildInfo = new GuildInformations();
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_PaddockGuildedInformations(param1);
    }

    public void serializeAs_PaddockGuildedInformations(ICustomDataOutput param1) {
         super.serializeAs_PaddockBuyableInformations(param1);
         param1.writeBoolean(this.deserted);
         this.guildInfo.serializeAs_GuildInformations(param1);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_PaddockGuildedInformations(param1);
    }

    public void deserializeAs_PaddockGuildedInformations(ICustomDataInput param1) {
         super.deserialize(param1);
         this._desertedFunc(param1);
         this.guildInfo = new GuildInformations();
         this.guildInfo.deserialize(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_PaddockGuildedInformations(param1);
    }

    public void deserializeAsyncAs_PaddockGuildedInformations(FuncTree param1) {
         super.deserializeAsync(param1);
         param1.addChild(this._desertedFunc);
         this._guildInfotree = param1.addChild(this._guildInfotreeFunc);
    }

    private void _desertedFunc(ICustomDataInput param1) {
         this.deserted = param1.readBoolean();
    }

    private void _guildInfotreeFunc(ICustomDataInput param1) {
         this.guildInfo = new GuildInformations();
         this.guildInfo.deserializeAsync(this._guildInfotree);
    }

}