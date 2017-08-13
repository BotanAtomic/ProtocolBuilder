package com.ankamagames.dofus.network.messages.game.context.fight;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class GameFightPlacementSwapPositionsCancelledMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6546;
    private boolean _isInitialized = false;
    private int requestId = 0;
    private Number cancellerId = 0;


    public void serialize(ICustomDataOutput param1) {
         if(this.requestId < 0)
         {
            throw new Exception("Forbidden value (" + this.requestId + ") on element requestId.");
         }
         param1.writeInt(this.requestId);
         if(this.cancellerId < -9.007199254740992E15 || this.cancellerId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.cancellerId + ") on element cancellerId.");
         }
         param1.writeDouble(this.cancellerId);
    }

    public void deserialize(ICustomDataInput param1) {
         this.requestId = param1.readInt();
         if(this.requestId < 0)
         {
            throw new Exception("Forbidden value (" + this.requestId + ") on element of GameFightPlacementSwapPositionsCancelledMessage.requestId.");
         }
         this.cancellerId = param1.readDouble();
         if(this.cancellerId < -9.007199254740992E15 || this.cancellerId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.cancellerId + ") on element of GameFightPlacementSwapPositionsCancelledMessage.cancellerId.");
         }
    }

}