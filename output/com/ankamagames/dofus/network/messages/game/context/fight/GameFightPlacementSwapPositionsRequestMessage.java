package com.ankamagames.dofus.network.messages.game.context.fight;

import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class GameFightPlacementSwapPositionsRequestMessage extends GameFightPlacementPositionRequestMessage implements INetworkMessage {

    private int protocolId = 6541;
    private boolean _isInitialized = false;
    private Number requestedId = 0;


    public void serialize(ICustomDataOutput param1) {
         if(this.cellId < 0 || this.cellId > 559)
         {
            throw new Exception("Forbidden value (" + this.cellId + ") on element cellId.");
         }
         param1.writeVarShort(this.cellId);
         if(this.requestedId < -9.007199254740992E15 || this.requestedId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.requestedId + ") on element requestedId.");
         }
         param1.writeDouble(this.requestedId);
    }

    public void deserialize(ICustomDataInput param1) {
         this.cellId = param1.readVarUhShort();
         if(this.cellId < 0 || this.cellId > 559)
         {
            throw new Exception("Forbidden value (" + this.cellId + ") on element of GameFightPlacementPositionRequestMessage.cellId.");
         }
         this.requestedId = param1.readDouble();
         if(this.requestedId < -9.007199254740992E15 || this.requestedId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.requestedId + ") on element of GameFightPlacementSwapPositionsRequestMessage.requestedId.");
         }
    }

}