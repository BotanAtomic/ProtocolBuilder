package package com.ankamagames.dofus.network.types.game.context.fight;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.dofus.network.ProtocolTypeManager;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class FightTeamInformations extends Abstract {

    private int protocolId = 33;
    private Vector.<FightTeamMemberInformations> teamMembers = ;
    private FuncTree _teamMemberstree = ;
    private int _loc2_ = 0;
    private FightTeamMemberInformations _loc5_ = null;
    private int _loc2_ = param1.readUnsignedShort();
    private int _loc3_ = 0;
    private int _loc3_ = 0;
    private FightTeamMemberInformations _loc3_ = ProtocolTypeManager.getInstance(FightTeamMemberInformations,_loc2_);


    public int getTypeId() {
         return 33;
    }

    public FightTeamInformations initFightTeamInformations(int param1,Number  param2,int  param3,int  param4,int  param5,Vector.<FightTeamMemberInformations>  param6) {
         super.initAbstractFightTeamInformations(param1,param2,param3,param4,param5);
         this.teamMembers = param6;
         return this;
    }

    public void reset() {
         super.reset();
         this.teamMembers = new Vector.<FightTeamMemberInformations>();
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_FightTeamInformations(param1);
    }

    public void serializeAs_FightTeamInformations(ICustomDataOutput param1) {
         super.serializeAs_AbstractFightTeamInformations(param1);
         param1.writeShort(this.teamMembers.length);
         int _loc2_ = 0;
         while(_loc2_ < this.teamMembers.length)
            param1.writeShort((this.teamMembers[_loc2_] as FightTeamMemberInformations).getTypeId());
            (this.teamMembers[_loc2_] as FightTeamMemberInformations).serialize(param1);
            _loc2_++;
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_FightTeamInformations(param1);
    }

    public void deserializeAs_FightTeamInformations(ICustomDataInput param1) {
         int _loc4_ = 0;
         FightTeamMemberInformations _loc5_ = null;
         super.deserialize(param1);
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
            _loc4_ = param1.readUnsignedShort();
            _loc5_ = ProtocolTypeManager.getInstance(FightTeamMemberInformations,_loc4_);
            _loc5_.deserialize(param1);
            this.teamMembers.push(_loc5_);
            _loc3_++;
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_FightTeamInformations(param1);
    }

    public void deserializeAsyncAs_FightTeamInformations(FuncTree param1) {
         super.deserializeAsync(param1);
         this._teamMemberstree = param1.addChild(this._teamMemberstreeFunc);
    }

    private void _teamMemberstreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
            this._teamMemberstree.addChild(this._teamMembersFunc);
            _loc3_++;
    }

    private void _teamMembersFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         FightTeamMemberInformations _loc3_ = ProtocolTypeManager.getInstance(FightTeamMemberInformations,_loc2_);
         _loc3_.deserialize(param1);
         this.teamMembers.push(_loc3_);
    }

}