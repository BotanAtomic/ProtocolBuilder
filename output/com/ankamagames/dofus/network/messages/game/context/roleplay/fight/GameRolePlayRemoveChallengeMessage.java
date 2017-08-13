package com.ankamagames.dofus.network.messages.game.context.roleplay.fight;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class GameRolePlayRemoveChallengeMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 300;
    private boolean _isInitialized = false;
    private int fightId = 0;


    public void serialize(ICustomDataOutput param1) {
         param1.writeInt(this.fightId);
    }

    public void deserialize(ICustomDataInput param1) {
         this.fightId = param1.readInt();
    }

}