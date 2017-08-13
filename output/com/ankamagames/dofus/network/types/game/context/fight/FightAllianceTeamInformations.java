package com.ankamagames.dofus.network.types.game.context.fight;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class FightAllianceTeamInformations extends FightTeamInformations implements INetworkType {

    private int protocolId = 439;
    private int relation = 0;


    public void serialize(ICustomDataOutput param1) {
         super.serializeAs_FightTeamInformations(param1);
         param1.writeByte(this.relation);
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
         this.relation = param1.readByte();
         if(this.relation < 0)
         {
            throw new Exception("Forbidden value (" + this.relation + ") on element of FightAllianceTeamInformations.relation.");
         }
    }

}