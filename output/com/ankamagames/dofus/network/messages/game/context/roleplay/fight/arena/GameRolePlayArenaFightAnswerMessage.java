package com.ankamagames.dofus.network.messages.game.context.roleplay.fight.arena;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class GameRolePlayArenaFightAnswerMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6279;
    private boolean _isInitialized = false;
    private int fightId = 0;
    private boolean accept = false;


    public void serialize(ICustomDataOutput param1) {
         param1.writeInt(this.fightId);
         param1.writeBoolean(this.accept);
    }

    public void deserialize(ICustomDataInput param1) {
         this.fightId = param1.readInt();
         this.accept = param1.readBoolean();
    }

}