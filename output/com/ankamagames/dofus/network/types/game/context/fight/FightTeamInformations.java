package com.ankamagames.dofus.network.types.game.context.fight;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.dofus.network.ProtocolTypeManager;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class FightTeamInformations extends Abstract {

    private int protocolId = 33;
    private FightTeamMemberInformations[] teamMembers;
    private FuncTree _teamMemberstree;


    public void serialize(ICustomDataOutput param1) {
         super.serializeAs_AbstractFightTeamInformations(param1);
         param1.writeShort(this.teamMembers.length);
         int _loc2_ = 0;
         while(_loc2_ < this.teamMembers.length)
         {
            param1.writeShort((this.teamMembers[_loc2_] as FightTeamMemberInformations).getTypeId());
            (this.teamMembers[_loc2_] as FightTeamMemberInformations).serialize(param1);
            _loc2_++;
         }
    }

    public void deserialize(ICustomDataInput param1) {
         int _loc4_ = 0;
         FightTeamMemberInformations _loc5_ = null;
         this.actionId = param1.readVarUhShort();
         if(this.actionId < 0)
         {
            throw new Exception("Forbidden value (" + this.actionId + ") on element of AbstractGameActionMessage.actionId.");
         }
         this.sourceId = param1.readDouble();
         if(this.sourceId < -9.007199254740992E15 || this.sourceId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.sourceId + ") on element of AbstractGameActionMessage.sourceId.");
         }
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            _loc4_ = param1.readUnsignedShort();
            _loc5_ = ProtocolTypeManager.getInstance(FightTeamMemberInformations,_loc4_);
            _loc5_.deserialize(param1);
            this.teamMembers.push(_loc5_);
            _loc3_++;
         }
    }

}