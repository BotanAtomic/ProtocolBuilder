package com.ankamagames.dofus.network.messages.game.context;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class GameMapChangeOrientationRequestMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 945;
    private boolean _isInitialized = false;
    private int direction = 1;


    public void serialize(ICustomDataOutput param1) {
         param1.writeByte(this.direction);
    }

    public void deserialize(ICustomDataInput param1) {
         this.direction = param1.readByte();
         if(this.direction < 0)
         {
            throw new Exception("Forbidden value (" + this.direction + ") on element of GameMapChangeOrientationRequestMessage.direction.");
         }
    }

}