package package com.ankamagames.dofus.network.types.game.social;

import com.ankamagames.dofus.network.types.game.context.roleplay.GuildInformations;
import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.dofus.network.types.game.context.roleplay.BasicNamedAllianceInformations;
import com.ankamagames.dofus.network.types.game.guild.GuildEmblem;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class AlliancedGuildFactSheetInformations extends GuildInformations implements INetworkType {

    private int protocolId = 422;
    private BasicNamedAllianceInformations allianceInfos = ;
    private FuncTree _allianceInfostree = ;


    public int getTypeId() {
         return 422;
    }

    public AlliancedGuildFactSheetInformations initAlliancedGuildFactSheetInformations(int param1,String  param2,int  param3,GuildEmblem  param4,BasicNamedAllianceInformations  param5) {
         super.initGuildInformations(param1,param2,param3,param4);
         this.allianceInfos = param5;
         return this;
    }

    public void reset() {
         super.reset();
         this.allianceInfos = new BasicNamedAllianceInformations();
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_AlliancedGuildFactSheetInformations(param1);
    }

    public void serializeAs_AlliancedGuildFactSheetInformations(ICustomDataOutput param1) {
         super.serializeAs_GuildInformations(param1);
         this.allianceInfos.serializeAs_BasicNamedAllianceInformations(param1);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_AlliancedGuildFactSheetInformations(param1);
    }

    public void deserializeAs_AlliancedGuildFactSheetInformations(ICustomDataInput param1) {
         super.deserialize(param1);
         this.allianceInfos = new BasicNamedAllianceInformations();
         this.allianceInfos.deserialize(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_AlliancedGuildFactSheetInformations(param1);
    }

    public void deserializeAsyncAs_AlliancedGuildFactSheetInformations(FuncTree param1) {
         super.deserializeAsync(param1);
         this._allianceInfostree = param1.addChild(this._allianceInfostreeFunc);
    }

    private void _allianceInfostreeFunc(ICustomDataInput param1) {
         this.allianceInfos = new BasicNamedAllianceInformations();
         this.allianceInfos.deserializeAsync(this._allianceInfostree);
    }

}