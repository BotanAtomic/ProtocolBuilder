package com.ankamagames.dofus.network.messages.game.tinsel;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class TitleGainedMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6364;
    private boolean _isInitialized = false;
    private int titleId = 0;


    public void serialize(ICustomDataOutput param1) {
         if(this.titleId < 0)
         {
            throw new Exception("Forbidden value (" + this.titleId + ") on element titleId.");
         }
         param1.writeVarShort(this.titleId);
    }

    public void deserialize(ICustomDataInput param1) {
         this.titleId = param1.readVarUhShort();
         if(this.titleId < 0)
         {
            throw new Exception("Forbidden value (" + this.titleId + ") on element of TitleGainedMessage.titleId.");
         }
    }

}