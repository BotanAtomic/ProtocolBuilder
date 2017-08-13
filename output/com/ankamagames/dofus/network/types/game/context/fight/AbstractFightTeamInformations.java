package com.ankamagames.dofus.network.types.game.context.fight;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class AbstractFightTeamInformations extends Object implements INetworkType {

    private int protocolId = 116;
    private int teamId = 2;
    private Number leaderId = 0;
    private int teamSide = 0;
    private int teamTypeId = 0;
    private int nbWaves = 0;


    public void serialize(ICustomDataOutput param1) {
         param1.writeByte(this.teamId);
         if(this.leaderId < -9.007199254740992E15 || this.leaderId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.leaderId + ") on element leaderId.");
         }
         param1.writeDouble(this.leaderId);
         param1.writeByte(this.teamSide);
         param1.writeByte(this.teamTypeId);
         if(this.nbWaves < 0)
         {
            throw new Exception("Forbidden value (" + this.nbWaves + ") on element nbWaves.");
         }
         param1.writeByte(this.nbWaves);
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
    }

}