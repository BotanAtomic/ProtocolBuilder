package com.ankamagames.dofus.network.messages.game.context.roleplay.fight.arena;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class GameRolePlayArenaFighterStatusMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6281;
    private boolean _isInitialized = false;
    private int fightId = 0;
    private int playerId = 0;
    private boolean accepted = false;


    public void serialize(ICustomDataOutput param1) {
         param1.writeInt(this.fightId);
         param1.writeInt(this.playerId);
         param1.writeBoolean(this.accepted);
    }

    public void deserialize(ICustomDataInput param1) {
         this.fightId = param1.readInt();
         this.playerId = param1.readInt();
         this.accepted = param1.readBoolean();
    }

}