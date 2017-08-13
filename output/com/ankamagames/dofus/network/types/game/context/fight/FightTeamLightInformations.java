package com.ankamagames.dofus.network.types.game.context.fight;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.utils.BooleanByteWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
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


    public void serialize(ICustomDataOutput param1) {
         super.serializeAs_AbstractFightTeamInformations(param1);
         int _loc2_ = 0;
         _loc2_ = BooleanByteWrapper.setFlag(_loc2_,0,this.hasFriend);
         _loc2_ = BooleanByteWrapper.setFlag(_loc2_,1,this.hasGuildMember);
         _loc2_ = BooleanByteWrapper.setFlag(_loc2_,2,this.hasAllianceMember);
         _loc2_ = BooleanByteWrapper.setFlag(_loc2_,3,this.hasGroupMember);
         _loc2_ = BooleanByteWrapper.setFlag(_loc2_,4,this.hasMyTaxCollector);
         param1.writeByte(_loc2_);
         if(this.teamMembersCount < 0)
         {
            throw new Exception("Forbidden value (" + this.teamMembersCount + ") on element teamMembersCount.");
         }
         param1.writeByte(this.teamMembersCount);
         if(this.meanLevel < 0)
         {
            throw new Exception("Forbidden value (" + this.meanLevel + ") on element meanLevel.");
         }
         param1.writeVarInt(this.meanLevel);
    }

    public void deserialize(ICustomDataInput param1) {
         this.teamId = param1.readByte();
         if(this.teamId < 0)
         {
            throw new Exception("Forbidden value (" + this.teamId + ") on element of AbstractFightTeamInformations.teamId.");
         }
         this.leaderId = param1.readDouble();
         if(this.leaderId < -9.007199254740992E15 || this.leaderId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.leaderId + ") on element of AbstractFightTeamInformations.leaderId.");
         }
         this.teamSide = param1.readByte();
         this.teamTypeId = param1.readByte();
         if(this.teamTypeId < 0)
         {
            throw new Exception("Forbidden value (" + this.teamTypeId + ") on element of AbstractFightTeamInformations.teamTypeId.");
         }
         this.nbWaves = param1.readByte();
         if(this.nbWaves < 0)
         {
            throw new Exception("Forbidden value (" + this.nbWaves + ") on element of AbstractFightTeamInformations.nbWaves.");
         }
         int _loc2_ = param1.readByte();
         this.hasFriend = BooleanByteWrapper.getFlag(_loc2_,0);
         this.hasGuildMember = BooleanByteWrapper.getFlag(_loc2_,1);
         this.hasAllianceMember = BooleanByteWrapper.getFlag(_loc2_,2);
         this.hasGroupMember = BooleanByteWrapper.getFlag(_loc2_,3);
         this.hasMyTaxCollector = BooleanByteWrapper.getFlag(_loc2_,4);
         this.teamMembersCount = param1.readByte();
         if(this.teamMembersCount < 0)
         {
            throw new Exception("Forbidden value (" + this.teamMembersCount + ") on element of FightTeamLightInformations.teamMembersCount.");
         }
         this.meanLevel = param1.readVarUhInt();
         if(this.meanLevel < 0)
         {
            throw new Exception("Forbidden value (" + this.meanLevel + ") on element of FightTeamLightInformations.meanLevel.");
         }
    }

}