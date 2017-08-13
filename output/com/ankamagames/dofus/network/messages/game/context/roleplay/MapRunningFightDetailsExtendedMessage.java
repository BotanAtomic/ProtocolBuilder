package com.ankamagames.dofus.network.messages.game.context.roleplay;

import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.context.roleplay.party.NamedPartyTeam;
import com.ankamagames.dofus.network.types.game.context.fight.GameFightFighterLightInformations;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class MapRunningFightDetailsExtendedMessage extends MapRunningFightDetailsMessage implements INetworkMessage {

    private int protocolId = 6500;
    private boolean _isInitialized = false;
    private NamedPartyTeam[] namedPartyTeams;
    private FuncTree _namedPartyTeamstree;


    public void serialize(ICustomDataOutput param1) {
         if(this.fightId < 0)
         {
            throw new Exception("Forbidden value (" + this.fightId + ") on element fightId.");
         }
         param1.writeInt(this.fightId);
         param1.writeShort(this.attackers.length);
         int _loc2_ = 0;
         while(_loc2_ < this.attackers.length)
         {
            param1.writeShort((this.attackers[_loc2_] as GameFightFighterLightInformations).getTypeId());
            (this.attackers[_loc2_] as GameFightFighterLightInformations).serialize(param1);
            _loc2_++;
         }
         param1.writeShort(this.defenders.length);
         int _loc3_ = 0;
         while(_loc3_ < this.defenders.length)
         {
            param1.writeShort((this.defenders[_loc3_] as GameFightFighterLightInformations).getTypeId());
            (this.defenders[_loc3_] as GameFightFighterLightInformations).serialize(param1);
            _loc3_++;
         }
         param1.writeShort(this.namedPartyTeams.length);
         int _loc2_ = 0;
         while(_loc2_ < this.namedPartyTeams.length)
         {
            (this.namedPartyTeams[_loc2_] as NamedPartyTeam).serializeAs_NamedPartyTeam(param1);
            _loc2_++;
         }
    }

    public void deserialize(ICustomDataInput param1) {
         NamedPartyTeam _loc4_ = null;
         this.deserializeAs_MapRunningFightDetailsMessage(param1);
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            _loc4_ = new NamedPartyTeam();
            _loc4_.deserialize(param1);
            this.namedPartyTeams.push(_loc4_);
            _loc3_++;
         }
    }

}