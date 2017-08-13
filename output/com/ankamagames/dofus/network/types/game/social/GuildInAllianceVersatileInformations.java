package package com.ankamagames.dofus.network.types.game.social;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;

public class GuildInAllianceVersatileInformations extends GuildVersatileInformations implements INetworkType {

    private int protocolId = 437;
    private int allianceId = 0;


    public int getTypeId() {
         return 437;
    }

    public GuildInAllianceVersatileInformations initGuildInAllianceVersatileInformations(int param1,Number  param2,int  param3,int  param4,int  param5) {
         super.initGuildVersatileInformations(param1,param2,param3,param4);
         this.allianceId = param5;
         return this;
    }

    public void reset() {
         super.reset();
         this.allianceId = 0;
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_GuildInAllianceVersatileInformations(param1);
    }

    public void serializeAs_GuildInAllianceVersatileInformations(ICustomDataOutput param1) {
         super.serializeAs_GuildVersatileInformations(param1);
         if(this.allianceId < 0)
            throw new Exception("Forbidden value (" + this.allianceId + ") on element allianceId.");
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_GuildInAllianceVersatileInformations(param1);
    }

    public void deserializeAs_GuildInAllianceVersatileInformations(ICustomDataInput param1) {
         super.deserialize(param1);
         this._allianceIdFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_GuildInAllianceVersatileInformations(param1);
    }

    public void deserializeAsyncAs_GuildInAllianceVersatileInformations(FuncTree param1) {
         super.deserializeAsync(param1);
         param1.addChild(this._allianceIdFunc);
    }

    private void _allianceIdFunc(ICustomDataInput param1) {
         this.allianceId = param1.readVarUhInt();
         if(this.allianceId < 0)
            throw new Exception("Forbidden value (" + this.allianceId + ") on element of GuildInAllianceVersatileInformations.allianceId.");
    }

}