package package com.ankamagames.dofus.network.types.game.context.roleplay.party;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.dofus.network.types.game.look.EntityLook;
import com.ankamagames.dofus.network.types.game.character.status.PlayerStatus;
import com.ankamagames.dofus.network.types.game.context.roleplay.party.companion.PartyCompanionMemberInformations;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;

public class PartyMemberArenaInformations extends PartyMemberInformations implements INetworkType {

    private int protocolId = 391;
    private int rank = 0;


    public int getTypeId() {
         return 391;
    }

    public PartyMemberArenaInformations initPartyMemberArenaInformations(Number param1,String  param2,int  param3,EntityLook  param4,int  param5,boolean  param6,int  param7,int  param8,int  param9,int  param10,int  param11,int  param12,int  param13,int  param14,int  param15,int  param16,PlayerStatus  param17,Vector.<PartyCompanionMemberInformations>  param18,int  param19) {
         super.initPartyMemberInformations(param1,param2,param3,param4,param5,param6,param7,param8,param9,param10,param11,param12,param13,param14,param15,param16,param17,param18);
         this.rank = param19;
         return this;
    }

    public void reset() {
         super.reset();
         this.rank = 0;
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_PartyMemberArenaInformations(param1);
    }

    public void serializeAs_PartyMemberArenaInformations(ICustomDataOutput param1) {
         super.serializeAs_PartyMemberInformations(param1);
         if(this.rank < 0 || this.rank > 20000)
            throw new Exception("Forbidden value (" + this.rank + ") on element rank.");
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_PartyMemberArenaInformations(param1);
    }

    public void deserializeAs_PartyMemberArenaInformations(ICustomDataInput param1) {
         super.deserialize(param1);
         this._rankFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_PartyMemberArenaInformations(param1);
    }

    public void deserializeAsyncAs_PartyMemberArenaInformations(FuncTree param1) {
         super.deserializeAsync(param1);
         param1.addChild(this._rankFunc);
    }

    private void _rankFunc(ICustomDataInput param1) {
         this.rank = param1.readVarUhShort();
         if(this.rank < 0 || this.rank > 20000)
            throw new Exception("Forbidden value (" + this.rank + ") on element of PartyMemberArenaInformations.rank.");
    }

}