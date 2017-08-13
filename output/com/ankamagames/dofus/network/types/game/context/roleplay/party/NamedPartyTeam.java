package com.ankamagames.dofus.network.types.game.context.roleplay.party;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class NamedPartyTeam extends Object implements INetworkType {

    private int protocolId = 469;
    private int teamId = 2;
    private String partyName = "";


    public int getTypeId() {
         return 469;
    }

    public NamedPartyTeam initNamedPartyTeam(int param1,String  param2) {
         this.teamId = param1;
         this.partyName = param2;
         return this;
    }

    public void reset() {
         this.teamId = 2;
         this.partyName = "";
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_NamedPartyTeam(param1);
    }

    public void serializeAs_NamedPartyTeam(ICustomDataOutput param1) {
         param1.writeByte(this.teamId);
         param1.writeUTF(this.partyName);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_NamedPartyTeam(param1);
    }

    public void deserializeAs_NamedPartyTeam(ICustomDataInput param1) {
         this._teamIdFunc(param1);
         this._partyNameFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_NamedPartyTeam(param1);
    }

    public void deserializeAsyncAs_NamedPartyTeam(FuncTree param1) {
         param1.addChild(this._teamIdFunc);
         param1.addChild(this._partyNameFunc);
    }

    private void _teamIdFunc(ICustomDataInput param1) {
         this.teamId = param1.readByte();
         if(this.teamId < 0)
         {
            throw new Exception("Forbidden value (" + this.teamId + ") on element of NamedPartyTeam.teamId.");
         }
    }

    private void _partyNameFunc(ICustomDataInput param1) {
         this.partyName = param1.readUTF();
    }

}