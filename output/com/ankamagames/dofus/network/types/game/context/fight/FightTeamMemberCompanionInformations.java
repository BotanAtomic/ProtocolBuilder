package com.ankamagames.dofus.network.types.game.context.fight;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;

public class FightTeamMemberCompanionInformations extends FightTeamMemberInformations implements INetworkType {

    private int protocolId = 451;
    private int companionId = 0;
    private int level = 0;
    private Number masterId = 0;


    public int getTypeId() {
         return 451;
    }

    public FightTeamMemberCompanionInformations initFightTeamMemberCompanionInformations(Number param1,int  param2,int  param3,Number  param4) {
         super.initFightTeamMemberInformations(param1);
         this.companionId = param2;
         this.level = param3;
         this.masterId = param4;
         return this;
    }

    public void reset() {
         super.reset();
         this.companionId = 0;
         this.level = 0;
         this.masterId = 0;
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_FightTeamMemberCompanionInformations(param1);
    }

    public void serializeAs_FightTeamMemberCompanionInformations(ICustomDataOutput param1) {
         super.serializeAs_FightTeamMemberInformations(param1);
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
         this.deserializeAs_FightTeamMemberCompanionInformations(param1);
    }

    public void deserializeAs_FightTeamMemberCompanionInformations(ICustomDataInput param1) {
         super.deserialize(param1);
         this._companionIdFunc(param1);
         this._levelFunc(param1);
         this._masterIdFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_FightTeamMemberCompanionInformations(param1);
    }

    public void deserializeAsyncAs_FightTeamMemberCompanionInformations(FuncTree param1) {
         super.deserializeAsync(param1);
         param1.addChild(this._companionIdFunc);
         param1.addChild(this._levelFunc);
         param1.addChild(this._masterIdFunc);
    }

    private void _companionIdFunc(ICustomDataInput param1) {
         this.companionId = param1.readByte();
         if(this.companionId < 0)
         {
            throw new Exception("Forbidden value (" + this.companionId + ") on element of FightTeamMemberCompanionInformations.companionId.");
         }
    }

    private void _levelFunc(ICustomDataInput param1) {
         this.level = param1.readUnsignedByte();
         if(this.level < 1 || this.level > 200)
         {
            throw new Exception("Forbidden value (" + this.level + ") on element of FightTeamMemberCompanionInformations.level.");
         }
    }

    private void _masterIdFunc(ICustomDataInput param1) {
         this.masterId = param1.readDouble();
         if(this.masterId < -9.007199254740992E15 || this.masterId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.masterId + ") on element of FightTeamMemberCompanionInformations.masterId.");
         }
    }

}