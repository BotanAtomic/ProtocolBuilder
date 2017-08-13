package com.ankamagames.dofus.network.messages.game.context;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class GameMapNoMovementMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 954;
    private boolean _isInitialized = false;
    private int cellX = 0;
    private int cellY = 0;


    public void serialize(ICustomDataOutput param1) {
         param1.writeShort(this.cellX);
         param1.writeShort(this.cellY);
    }

    public void deserialize(ICustomDataInput param1) {
         this.cellX = param1.readShort();
         this.cellY = param1.readShort();
    }

}