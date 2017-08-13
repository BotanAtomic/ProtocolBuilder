package com.ankamagames.dofus.network.types.game.context.fight;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class FightAllianceTeamInformations extends FightTeamInformations implements INetworkType {

    private int protocolId = 439;
    private int relation = 0;


    public int getTypeId() {
         return 439;
    }

    public FightAllianceTeamInformations initFightAllianceTeamInformations(int param1,Number  param2,int  param3,int  param4,int  param5,Vector<FightTeamMemberInformations>  param6,int  param7) {
         super.initFightTeamInformations(param1,param2,param3,param4,param5,param6);
         this.relation = param7;
         return this;
    }

    public void reset() {
         super.reset();
         this.relation = 0;
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_FightAllianceTeamInformations(param1);
    }

    public void serializeAs_FightAllianceTeamInformations(ICustomDataOutput param1) {
         super.serializeAs_FightTeamInformations(param1);
         param1.writeByte(this.relation);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_FightAllianceTeamInformations(param1);
    }

    public void deserializeAs_FightAllianceTeamInformations(ICustomDataInput param1) {
         super.deserialize(param1);
         this._relationFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_FightAllianceTeamInformations(param1);
    }

    public void deserializeAsyncAs_FightAllianceTeamInformations(FuncTree param1) {
         super.deserializeAsync(param1);
         param1.addChild(this._relationFunc);
    }

    private void _relationFunc(ICustomDataInput param1) {
         this.relation = param1.readByte();
         if(this.relation < 0)
         {
            throw new Exception("Forbidden value (" + this.relation + ") on element of FightAllianceTeamInformations.relation.");
         }
    }

}