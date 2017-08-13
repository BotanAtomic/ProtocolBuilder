package com.ankamagames.dofus.network.messages.game.context.fight;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class GameFightPlacementSwapPositionsOfferMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6542;
    private boolean _isInitialized = false;
    private int requestId = 0;
    private Number requesterId = 0;
    private int requesterCellId = 0;
    private Number requestedId = 0;
    private int requestedCellId = 0;


    public void serialize(ICustomDataOutput param1) {
         if(this.requestId < 0)
         {
            throw new Exception("Forbidden value (" + this.requestId + ") on element requestId.");
         }
         param1.writeInt(this.requestId);
         if(this.requesterId < -9.007199254740992E15 || this.requesterId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.requesterId + ") on element requesterId.");
         }
         param1.writeDouble(this.requesterId);
         if(this.requesterCellId < 0 || this.requesterCellId > 559)
         {
            throw new Exception("Forbidden value (" + this.requesterCellId + ") on element requesterCellId.");
         }
         param1.writeVarShort(this.requesterCellId);
         if(this.requestedId < -9.007199254740992E15 || this.requestedId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.requestedId + ") on element requestedId.");
         }
         param1.writeDouble(this.requestedId);
         if(this.requestedCellId < 0 || this.requestedCellId > 559)
         {
            throw new Exception("Forbidden value (" + this.requestedCellId + ") on element requestedCellId.");
         }
         param1.writeVarShort(this.requestedCellId);
    }

    public void deserialize(ICustomDataInput param1) {
         this.requestId = param1.readInt();
         if(this.requestId < 0)
         {
            throw new Exception("Forbidden value (" + this.requestId + ") on element of GameFightPlacementSwapPositionsOfferMessage.requestId.");
         }
         this.requesterId = param1.readDouble();
         if(this.requesterId < -9.007199254740992E15 || this.requesterId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.requesterId + ") on element of GameFightPlacementSwapPositionsOfferMessage.requesterId.");
         }
         this.requesterCellId = param1.readVarUhShort();
         if(this.requesterCellId < 0 || this.requesterCellId > 559)
         {
            throw new Exception("Forbidden value (" + this.requesterCellId + ") on element of GameFightPlacementSwapPositionsOfferMessage.requesterCellId.");
         }
         this.requestedId = param1.readDouble();
         if(this.requestedId < -9.007199254740992E15 || this.requestedId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.requestedId + ") on element of GameFightPlacementSwapPositionsOfferMessage.requestedId.");
         }
         this.requestedCellId = param1.readVarUhShort();
         if(this.requestedCellId < 0 || this.requestedCellId > 559)
         {
            throw new Exception("Forbidden value (" + this.requestedCellId + ") on element of GameFightPlacementSwapPositionsOfferMessage.requestedCellId.");
         }
    }

}