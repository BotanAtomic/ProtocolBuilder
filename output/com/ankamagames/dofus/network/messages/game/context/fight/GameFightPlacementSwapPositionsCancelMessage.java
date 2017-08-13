package com.ankamagames.dofus.network.messages.game.context.fight;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class GameFightPlacementSwapPositionsCancelMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6543;
    private boolean _isInitialized = false;
    private int requestId = 0;


    public void serialize(ICustomDataOutput param1) {
         if(this.requestId < 0)
         {
            throw new Exception("Forbidden value (" + this.requestId + ") on element requestId.");
         }
         param1.writeInt(this.requestId);
    }

    public void deserialize(ICustomDataInput param1) {
         this.requestId = param1.readInt();
         if(this.requestId < 0)
         {
            throw new Exception("Forbidden value (" + this.requestId + ") on element of GameFightPlacementSwapPositionsCancelMessage.requestId.");
         }
    }

}