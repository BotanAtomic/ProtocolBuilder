package com.ankamagames.dofus.network.types.game.context.fight;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class FightTeamMemberCompanionInformations extends FightTeamMemberInformations implements INetworkType {

    private int protocolId = 451;
    private int companionId = 0;
    private int level = 0;
    private Number masterId = 0;


    public void serialize(ICustomDataOutput param1) {
         if(this.id < -9.007199254740992E15 || this.id > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.id + ") on element id.");
         }
         param1.writeDouble(this.id);
         if(this.companionId < 0)
         {
            throw new Exception("Forbidden value (" + this.companionId + ") on element companionId.");
         }
         param1.writeByte(this.companionId);
         if(this.level < 1 || this.level > 200)
         {
            throw new Exception("Forbidden value (" + this.level + ") on element level.");
         }
         param1.writeByte(this.level);
         if(this.masterId < -9.007199254740992E15 || this.masterId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.masterId + ") on element masterId.");
         }
         param1.writeDouble(this.masterId);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_FightTeamMemberInformations(param1);
         this.companionId = param1.readByte();
         if(this.companionId < 0)
         {
            throw new Exception("Forbidden value (" + this.companionId + ") on element of FightTeamMemberCompanionInformations.companionId.");
         }
         this.level = param1.readUnsignedByte();
         if(this.level < 1 || this.level > 200)
         {
            throw new Exception("Forbidden value (" + this.level + ") on element of FightTeamMemberCompanionInformations.level.");
         }
         this.masterId = param1.readDouble();
         if(this.masterId < -9.007199254740992E15 || this.masterId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.masterId + ") on element of FightTeamMemberCompanionInformations.masterId.");
         }
    }

}