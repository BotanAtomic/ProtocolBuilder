package com.ankamagames.dofus.network.messages.game.context.roleplay.fight.arena;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.context.roleplay.fight.arena.ArenaRankInfos;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class GameRolePlayArenaUpdatePlayerInfosMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6301;
    private boolean _isInitialized = false;
    private ArenaRankInfos solo;
    private FuncTree _solotree;


    public void serialize(ICustomDataOutput param1) {
         this.solo.serializeAs_ArenaRankInfos(param1);
    }

    public void deserialize(ICustomDataInput param1) {
         this.solo = new ArenaRankInfos();
         this.solo.deserialize(param1);
    }

}