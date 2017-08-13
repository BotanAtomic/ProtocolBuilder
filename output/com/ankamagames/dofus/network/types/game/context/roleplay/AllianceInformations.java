package com.ankamagames.dofus.network.types.game.context.roleplay;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.dofus.network.types.game.guild.GuildEmblem;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class AllianceInformations extends BasicNamed {

    private int protocolId = 417;
    private GuildEmblem allianceEmblem;
    private FuncTree _allianceEmblemtree;


    public int getTypeId() {
         return 417;
    }

    public AllianceInformations initAllianceInformations(int param1,String  param2,String  param3,GuildEmblem  param4) {
         super.initBasicNamedAllianceInformations(param1,param2,param3);
         this.allianceEmblem = param4;
         return this;
    }

    public void reset() {
         super.reset();
         this.allianceEmblem = new GuildEmblem();
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_AllianceInformations(param1);
    }

    public void serializeAs_AllianceInformations(ICustomDataOutput param1) {
         super.serializeAs_BasicNamedAllianceInformations(param1);
         this.allianceEmblem.serializeAs_GuildEmblem(param1);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_AllianceInformations(param1);
    }

    public void deserializeAs_AllianceInformations(ICustomDataInput param1) {
         super.deserialize(param1);
         this.allianceEmblem = new GuildEmblem();
         this.allianceEmblem.deserialize(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_AllianceInformations(param1);
    }

    public void deserializeAsyncAs_AllianceInformations(FuncTree param1) {
         super.deserializeAsync(param1);
         this._allianceEmblemtree = param1.addChild(this._allianceEmblemtreeFunc);
    }

    private void _allianceEmblemtreeFunc(ICustomDataInput param1) {
         this.allianceEmblem = new GuildEmblem();
         this.allianceEmblem.deserializeAsync(this._allianceEmblemtree);
    }

}