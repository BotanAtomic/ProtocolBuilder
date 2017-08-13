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


    public void serialize(ICustomDataOutput param1) {
         this.team.serializeAs_NamedPartyTeam(param1);
         param1.writeVarShort(this.outcome);
    }

    public void deserialize(ICustomDataInput param1) {
         this.team = new NamedPartyTeam();
         this.team.deserialize(param1);
         this.outcome = param1.readVarUhShort();
         if(this.outcome < 0)
         {
            throw new Exception("Forbidden value (" + this.outcome + ") on element of NamedPartyTeamWithOutcome.outcome.");
         }
    }

}