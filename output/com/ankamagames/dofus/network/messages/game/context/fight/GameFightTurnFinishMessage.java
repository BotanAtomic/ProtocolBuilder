package com.ankamagames.dofus.network.messages.game.context.fight;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class GameFightTurnFinishMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 718;
    private boolean _isInitialized = false;
    private boolean isAfk = false;


    public void serialize(ICustomDataOutput param1) {
         param1.writeBoolean(this.isAfk);
    }

    public void deserialize(ICustomDataInput param1) {
         this.isAfk = param1.readBoolean();
    }

}