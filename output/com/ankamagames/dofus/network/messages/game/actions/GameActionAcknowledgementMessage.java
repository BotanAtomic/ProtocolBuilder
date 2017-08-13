package com.ankamagames.dofus.network.messages.game.actions;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class GameActionAcknowledgementMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 957;
    private boolean _isInitialized = false;
    private boolean valid = false;
    private int actionId = 0;


    public void serialize(ICustomDataOutput param1) {
         param1.writeBoolean(this.valid);
         param1.writeByte(this.actionId);
    }

    public void deserialize(ICustomDataInput param1) {
         this.valid = param1.readBoolean();
         this.actionId = param1.readByte();
    }

}