package com.ankamagames.dofus.network.messages.game.context.roleplay.fight.arena;

import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.context.roleplay.fight.arena.ArenaRankInfos;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class GameRolePlayArenaUpdatePlayerInfosAllQueuesMessage extends GameRolePlayArenaUpdatePlayerInfosMessage implements INetworkMessage {

    private int protocolId = 6728;
    private boolean _isInitialized = false;
    private ArenaRankInfos team;
    private ArenaRankInfos duel;
    private FuncTree _teamtree;
    private FuncTree _dueltree;


    public void serialize(ICustomDataOutput param1) {
         this.solo.serializeAs_ArenaRankInfos(param1);
         this.team.serializeAs_ArenaRankInfos(param1);
         this.duel.serializeAs_ArenaRankInfos(param1);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_GameRolePlayArenaUpdatePlayerInfosMessage(param1);
         this.team = new ArenaRankInfos();
         this.team.deserialize(param1);
         this.duel = new ArenaRankInfos();
         this.duel.deserialize(param1);
    }

}