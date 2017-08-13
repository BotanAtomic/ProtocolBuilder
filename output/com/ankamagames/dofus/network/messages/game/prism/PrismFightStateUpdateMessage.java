package com.ankamagames.dofus.network.messages.game.prism;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class PrismFightStateUpdateMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6040;
    private boolean _isInitialized = false;
    private int state = 0;


    public void serialize(ICustomDataOutput param1) {
         if(this.state < 0)
         {
            throw new Exception("Forbidden value (" + this.state + ") on element state.");
         }
         param1.writeByte(this.state);
    }

    public void deserialize(ICustomDataInput param1) {
         this.state = param1.readByte();
         if(this.state < 0)
         {
            throw new Exception("Forbidden value (" + this.state + ") on element of PrismFightStateUpdateMessage.state.");
         }
    }

}