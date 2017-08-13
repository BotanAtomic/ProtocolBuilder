package com.ankamagames.dofus.network.types.game.context.fight;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class FightTeamMemberMonsterInformations extends FightTeamMemberInformations implements INetworkType {

    private int protocolId = 6;
    private int monsterId = 0;
    private int grade = 0;


    public void serialize(ICustomDataOutput param1) {
         super.serializeAs_FightTeamMemberInformations(param1);
         param1.writeInt(this.monsterId);
         if(this.grade < 0)
         {
            throw new Exception("Forbidden value (" + this.grade + ") on element grade.");
         }
         param1.writeByte(this.grade);
    }

    public void deserialize(ICustomDataInput param1) {
         this.id = param1.readDouble();
         if(this.id < -9.007199254740992E15 || this.id > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.id + ") on element of FightTeamMemberInformations.id.");
         }
         this.monsterId = param1.readInt();
         this.grade = param1.readByte();
         if(this.grade < 0)
         {
            throw new Exception("Forbidden value (" + this.grade + ") on element of FightTeamMemberMonsterInformations.grade.");
         }
    }

}