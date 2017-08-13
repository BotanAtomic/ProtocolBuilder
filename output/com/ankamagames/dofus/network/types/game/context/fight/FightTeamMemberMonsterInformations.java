package com.ankamagames.dofus.network.types.game.context.fight;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;

public class FightTeamMemberMonsterInformations extends FightTeamMemberInformations implements INetworkType {

    private int protocolId = 6;
    private int monsterId = 0;
    private int grade = 0;


    public int getTypeId() {
         return 6;
    }

    public FightTeamMemberMonsterInformations initFightTeamMemberMonsterInformations(Number param1,int  param2,int  param3) {
         super.initFightTeamMemberInformations(param1);
         this.monsterId = param2;
         this.grade = param3;
         return this;
    }

    public void reset() {
         super.reset();
         this.monsterId = 0;
         this.grade = 0;
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_FightTeamMemberMonsterInformations(param1);
    }

    public void serializeAs_FightTeamMemberMonsterInformations(ICustomDataOutput param1) {
         super.serializeAs_FightTeamMemberInformations(param1);
         param1.writeInt(this.monsterId);
         if(this.grade < 0)
         {
            throw new Exception("Forbidden value (" + this.grade + ") on element grade.");
         }
         param1.writeByte(this.grade);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_FightTeamMemberMonsterInformations(param1);
    }

    public void deserializeAs_FightTeamMemberMonsterInformations(ICustomDataInput param1) {
         super.deserialize(param1);
         this._monsterIdFunc(param1);
         this._gradeFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_FightTeamMemberMonsterInformations(param1);
    }

    public void deserializeAsyncAs_FightTeamMemberMonsterInformations(FuncTree param1) {
         super.deserializeAsync(param1);
         param1.addChild(this._monsterIdFunc);
         param1.addChild(this._gradeFunc);
    }

    private void _monsterIdFunc(ICustomDataInput param1) {
         this.monsterId = param1.readInt();
    }

    private void _gradeFunc(ICustomDataInput param1) {
         this.grade = param1.readByte();
         if(this.grade < 0)
         {
            throw new Exception("Forbidden value (" + this.grade + ") on element of FightTeamMemberMonsterInformations.grade.");
         }
    }

}