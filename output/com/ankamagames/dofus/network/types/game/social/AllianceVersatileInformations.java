package package com.ankamagames.dofus.network.types.game.social;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;

public class AllianceVersatileInformations extends Object implements INetworkType {

    private int protocolId = 432;
    private int allianceId = 0;
    private int nbGuilds = 0;
    private int nbMembers = 0;
    private int nbSubarea = 0;


    public int getTypeId() {
         return 432;
    }

    public AllianceVersatileInformations initAllianceVersatileInformations(int param1,int  param2,int  param3,int  param4) {
         this.allianceId = param1;
         this.nbGuilds = param2;
         this.nbMembers = param3;
         this.nbSubarea = param4;
         return this;
    }

    public void reset() {
         this.allianceId = 0;
         this.nbGuilds = 0;
         this.nbMembers = 0;
         this.nbSubarea = 0;
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_AllianceVersatileInformations(param1);
    }

    public void serializeAs_AllianceVersatileInformations(ICustomDataOutput param1) {
         if(this.allianceId < 0)
            throw new Exception("Forbidden value (" + this.allianceId + ") on element allianceId.");
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_AllianceVersatileInformations(param1);
    }

    public void deserializeAs_AllianceVersatileInformations(ICustomDataInput param1) {
         this._allianceIdFunc(param1);
         this._nbGuildsFunc(param1);
         this._nbMembersFunc(param1);
         this._nbSubareaFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_AllianceVersatileInformations(param1);
    }

    public void deserializeAsyncAs_AllianceVersatileInformations(FuncTree param1) {
         param1.addChild(this._allianceIdFunc);
         param1.addChild(this._nbGuildsFunc);
         param1.addChild(this._nbMembersFunc);
         param1.addChild(this._nbSubareaFunc);
    }

    private void _allianceIdFunc(ICustomDataInput param1) {
         this.allianceId = param1.readVarUhInt();
         if(this.allianceId < 0)
            throw new Exception("Forbidden value (" + this.allianceId + ") on element of AllianceVersatileInformations.allianceId.");
    }

    private void _nbGuildsFunc(ICustomDataInput param1) {
         this.nbGuilds = param1.readVarUhShort();
         if(this.nbGuilds < 0)
            throw new Exception("Forbidden value (" + this.nbGuilds + ") on element of AllianceVersatileInformations.nbGuilds.");
    }

    private void _nbMembersFunc(ICustomDataInput param1) {
         this.nbMembers = param1.readVarUhShort();
         if(this.nbMembers < 0)
            throw new Exception("Forbidden value (" + this.nbMembers + ") on element of AllianceVersatileInformations.nbMembers.");
    }

    private void _nbSubareaFunc(ICustomDataInput param1) {
         this.nbSubarea = param1.readVarUhShort();
         if(this.nbSubarea < 0)
            throw new Exception("Forbidden value (" + this.nbSubarea + ") on element of AllianceVersatileInformations.nbSubarea.");
    }

}