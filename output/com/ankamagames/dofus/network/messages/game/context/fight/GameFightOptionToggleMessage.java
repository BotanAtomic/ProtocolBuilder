package com.ankamagames.dofus.network.messages.game.context.fight;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class GameFightOptionToggleMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 707;
    private boolean _isInitialized = false;
    private int option = 3;


    public void serialize(ICustomDataOutput param1) {
         param1.writeByte(this.option);
    }

    public void deserialize(ICustomDataInput param1) {
         this.option = param1.readByte();
         if(this.option < 0)
         {
            throw new Exception("Forbidden value (" + this.option + ") on element of GameFightOptionToggleMessage.option.");
         }
    }

}