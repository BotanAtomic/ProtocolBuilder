package com.ankamagames.dofus.network.messages.game.context.fight;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.context.fight.FightTeamInformations;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class GameFightUpdateTeamMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 5572;
    private boolean _isInitialized = false;
    private int fightId = 0;
    private FightTeamInformations team;
    private FuncTree _teamtree;


    public void serialize(ICustomDataOutput param1) {
         if(this.fightId < 0)
         {
            throw new Exception("Forbidden value (" + this.fightId + ") on element fightId.");
         }
         param1.writeShort(this.fightId);
         this.team.serializeAs_FightTeamInformations(param1);
    }

    public void deserialize(ICustomDataInput param1) {
         this.fightId = param1.readShort();
         if(this.fightId < 0)
         {
            throw new Exception("Forbidden value (" + this.fightId + ") on element of GameFightUpdateTeamMessage.fightId.");
         }
         this.team = new FightTeamInformations();
         this.team.deserialize(param1);
    }

}