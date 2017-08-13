package com.ankamagames.dofus.network.types.game.context.fight;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;

public class FightTeamMemberInformations extends Object implements INetworkType {

    private int protocolId = 44;
    private Number id = 0;


    public int getTypeId() {
         return 44;
    }

    public FightTeamMemberInformations initFightTeamMemberInformations(Number param1) {
         this.id = param1;
         return this;
    }

    public void reset() {
         this.id = 0;
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_FightTeamMemberInformations(param1);
    }

    public void serializeAs_FightTeamMemberInformations(ICustomDataOutput param1) {
         if(this.id < -9.007199254740992E15 || this.id > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.id + ") on element id.");
         }
         param1.writeDouble(this.id);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_FightTeamMemberInformations(param1);
    }

    public void deserializeAs_FightTeamMemberInformations(ICustomDataInput param1) {
         this._idFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_FightTeamMemberInformations(param1);
    }

    public void deserializeAsyncAs_FightTeamMemberInformations(FuncTree param1) {
         param1.addChild(this._idFunc);
    }

    private void _idFunc(ICustomDataInput param1) {
         this.id = param1.readDouble();
         if(this.id < -9.007199254740992E15 || this.id > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.id + ") on element of FightTeamMemberInformations.id.");
         }
    }

}