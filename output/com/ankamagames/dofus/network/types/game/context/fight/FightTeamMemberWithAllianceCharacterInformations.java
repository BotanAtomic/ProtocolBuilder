package package com.ankamagames.dofus.network.types.game.context.fight;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.dofus.network.types.game.context.roleplay.BasicAllianceInformations;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class FightTeamMemberWithAllianceCharacterInformations extends FightTeamMemberCharacterInformations implements INetworkType {

    private int protocolId = 426;
    private BasicAllianceInformations allianceInfos = ;
    private FuncTree _allianceInfostree = ;


    public int getTypeId() {
         return 426;
    }

    public FightTeamMemberWithAllianceCharacterInformations initFightTeamMemberWithAllianceCharacterInformations(Number param1,String  param2,int  param3,BasicAllianceInformations  param4) {
         super.initFightTeamMemberCharacterInformations(param1,param2,param3);
         this.allianceInfos = param4;
         return this;
    }

    public void reset() {
         super.reset();
         this.allianceInfos = new BasicAllianceInformations();
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_FightTeamMemberWithAllianceCharacterInformations(param1);
    }

    public void serializeAs_FightTeamMemberWithAllianceCharacterInformations(ICustomDataOutput param1) {
         super.serializeAs_FightTeamMemberCharacterInformations(param1);
         this.allianceInfos.serializeAs_BasicAllianceInformations(param1);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_FightTeamMemberWithAllianceCharacterInformations(param1);
    }

    public void deserializeAs_FightTeamMemberWithAllianceCharacterInformations(ICustomDataInput param1) {
         super.deserialize(param1);
         this.allianceInfos = new BasicAllianceInformations();
         this.allianceInfos.deserialize(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_FightTeamMemberWithAllianceCharacterInformations(param1);
    }

    public void deserializeAsyncAs_FightTeamMemberWithAllianceCharacterInformations(FuncTree param1) {
         super.deserializeAsync(param1);
         this._allianceInfostree = param1.addChild(this._allianceInfostreeFunc);
    }

    private void _allianceInfostreeFunc(ICustomDataInput param1) {
         this.allianceInfos = new BasicAllianceInformations();
         this.allianceInfos.deserializeAsync(this._allianceInfostree);
    }

}