package com.ankamagames.dofus.network.types.game.context.roleplay.party;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class NamedPartyTeamWithOutcome extends Object implements INetworkType {

    private int protocolId = 470;
    private NamedPartyTeam team;
    private int outcome = 0;
    private FuncTree _teamtree;


    public int getTypeId() {
         return 470;
    }

    public NamedPartyTeamWithOutcome initNamedPartyTeamWithOutcome(NamedPartyTeam param1,int  param2) {
         this.team = param1;
         this.outcome = param2;
         return this;
    }

    public void reset() {
         this.team = new NamedPartyTeam();
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_NamedPartyTeamWithOutcome(param1);
    }

    public void serializeAs_NamedPartyTeamWithOutcome(ICustomDataOutput param1) {
         this.team.serializeAs_NamedPartyTeam(param1);
         param1.writeVarShort(this.outcome);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_NamedPartyTeamWithOutcome(param1);
    }

    public void deserializeAs_NamedPartyTeamWithOutcome(ICustomDataInput param1) {
         this.team = new NamedPartyTeam();
         this.team.deserialize(param1);
         this._outcomeFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_NamedPartyTeamWithOutcome(param1);
    }

    public void deserializeAsyncAs_NamedPartyTeamWithOutcome(FuncTree param1) {
         this._teamtree = param1.addChild(this._teamtreeFunc);
         param1.addChild(this._outcomeFunc);
    }

    private void _teamtreeFunc(ICustomDataInput param1) {
         this.team = new NamedPartyTeam();
         this.team.deserializeAsync(this._teamtree);
    }

    private void _outcomeFunc(ICustomDataInput param1) {
         this.outcome = param1.readVarUhShort();
         if(this.outcome < 0)
         {
            throw new Exception("Forbidden value (" + this.outcome + ") on element of NamedPartyTeamWithOutcome.outcome.");
         }
    }

}