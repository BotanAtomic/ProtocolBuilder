package package com.ankamagames.dofus.network.types.game.context.fight;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.utils.BooleanByteWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;

public class FightTeamLightInformations extends AbstractFightTeamInformations implements INetworkType {

    private int protocolId = 115;
    private int teamMembersCount = 0;
    private int meanLevel = 0;
    private boolean hasFriend = false;
    private boolean hasGuildMember = false;
    private boolean hasAllianceMember = false;
    private boolean hasGroupMember = false;
    private boolean hasMyTaxCollector = false;
    private int _loc2_ = 0;


    public int getTypeId() {
         return 115;
    }

    public FightTeamLightInformations initFightTeamLightInformations(int param1,Number  param2,int  param3,int  param4,int  param5,int  param6,int  param7,boolean  param8,boolean  param9,boolean  param10,boolean  param11,boolean  param12) {
         super.initAbstractFightTeamInformations(param1,param2,param3,param4,param5);
         this.teamMembersCount = param6;
         this.meanLevel = param7;
         this.hasFriend = param8;
         this.hasGuildMember = param9;
         this.hasAllianceMember = param10;
         this.hasGroupMember = param11;
         this.hasMyTaxCollector = param12;
         return this;
    }

    public void reset() {
         super.reset();
         this.teamMembersCount = 0;
         this.meanLevel = 0;
         this.hasFriend = false;
         this.hasGuildMember = false;
         this.hasAllianceMember = false;
         this.hasGroupMember = false;
         this.hasMyTaxCollector = false;
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_FightTeamLightInformations(param1);
    }

    public void serializeAs_FightTeamLightInformations(ICustomDataOutput param1) {
         super.serializeAs_AbstractFightTeamInformations(param1);
         int _loc2_ = 0;
         _loc2_ = BooleanByteWrapper.setFlag(_loc2_,0,this.hasFriend);
         _loc2_ = BooleanByteWrapper.setFlag(_loc2_,1,this.hasGuildMember);
         _loc2_ = BooleanByteWrapper.setFlag(_loc2_,2,this.hasAllianceMember);
         _loc2_ = BooleanByteWrapper.setFlag(_loc2_,3,this.hasGroupMember);
         _loc2_ = BooleanByteWrapper.setFlag(_loc2_,4,this.hasMyTaxCollector);
         param1.writeByte(_loc2_);
         if(this.teamMembersCount < 0)
            throw new Exception("Forbidden value (" + this.teamMembersCount + ") on element teamMembersCount.");
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_FightTeamLightInformations(param1);
    }

    public void deserializeAs_FightTeamLightInformations(ICustomDataInput param1) {
         super.deserialize(param1);
         this.deserializeByteBoxes(param1);
         this._teamMembersCountFunc(param1);
         this._meanLevelFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_FightTeamLightInformations(param1);
    }

    public void deserializeAsyncAs_FightTeamLightInformations(FuncTree param1) {
         super.deserializeAsync(param1);
         param1.addChild(this.deserializeByteBoxes);
         param1.addChild(this._teamMembersCountFunc);
         param1.addChild(this._meanLevelFunc);
    }

    private void deserializeByteBoxes(ICustomDataInput param1) {
         int _loc2_ = param1.readByte();
         this.hasFriend = BooleanByteWrapper.getFlag(_loc2_,0);
         this.hasGuildMember = BooleanByteWrapper.getFlag(_loc2_,1);
         this.hasAllianceMember = BooleanByteWrapper.getFlag(_loc2_,2);
         this.hasGroupMember = BooleanByteWrapper.getFlag(_loc2_,3);
         this.hasMyTaxCollector = BooleanByteWrapper.getFlag(_loc2_,4);
    }

    private void _teamMembersCountFunc(ICustomDataInput param1) {
         this.teamMembersCount = param1.readByte();
         if(this.teamMembersCount < 0)
            throw new Exception("Forbidden value (" + this.teamMembersCount + ") on element of FightTeamLightInformations.teamMembersCount.");
    }

    private void _meanLevelFunc(ICustomDataInput param1) {
         this.meanLevel = param1.readVarUhInt();
         if(this.meanLevel < 0)
            throw new Exception("Forbidden value (" + this.meanLevel + ") on element of FightTeamLightInformations.meanLevel.");
    }

}