package com.ankamagames.dofus.network.messages.game.context.fight;

import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.context.roleplay.party.NamedPartyTeam;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class GameFightSpectatorJoinMessage extends GameFightJoinMessage implements INetworkMessage {

    private int protocolId = 6504;
    private boolean _isInitialized = false;
    private NamedPartyTeam[] namedPartyTeams;
    private FuncTree _namedPartyTeamstree;


    public void serialize(ICustomDataOutput param1) {
         super.serializeAs_GameFightJoinMessage(param1);
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
         int _loc2_ = param1.readByte();
         this.isTeamPhase = BooleanByteWrapper.getFlag(_loc2_,0);
         this.canBeCancelled = BooleanByteWrapper.getFlag(_loc2_,1);
         this.canSayReady = BooleanByteWrapper.getFlag(_loc2_,2);
         this.isFightStarted = BooleanByteWrapper.getFlag(_loc2_,3);
         this.timeMaxBeforeFightStart = param1.readShort();
         if(this.timeMaxBeforeFightStart < 0)
         {
            throw new Exception("Forbidden value (" + this.timeMaxBeforeFightStart + ") on element of GameFightJoinMessage.timeMaxBeforeFightStart.");
         }
         this.fightType = param1.readByte();
         if(this.fightType < 0)
         {
            throw new Exception("Forbidden value (" + this.fightType + ") on element of GameFightJoinMessage.fightType.");
         }
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