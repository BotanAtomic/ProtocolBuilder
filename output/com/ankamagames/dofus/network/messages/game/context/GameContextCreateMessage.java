package com.ankamagames.dofus.network.messages.game.context;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class GameContextCreateMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 200;
    private boolean _isInitialized = false;
    private int context = 1;


    public void serialize(ICustomDataOutput param1) {
         param1.writeByte(this.context);
    }

    public void deserialize(ICustomDataInput param1) {
         this.context = param1.readByte();
         if(this.context < 0)
         {
            throw new Exception("Forbidden value (" + this.context + ") on element of GameContextCreateMessage.context.");
         }
    }

}