package com.ankamagames.dofus.network.messages.game.context;

import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class GameCautiousMapMovementRequestMessage extends GameMapMovementRequestMessage implements INetworkMessage {

    private int protocolId = 6496;
    private boolean _isInitialized = false;


    public void serialize(ICustomDataOutput param1) {
         param1.writeShort(this.keyMovements.length);
         int _loc2_ = 0;
         while(_loc2_ < this.keyMovements.length)
         {
            if(this.keyMovements[_loc2_] < 0)
            {
               throw new Exception("Forbidden value (" + this.keyMovements[_loc2_] + ") on element 1 (starting at 1) of keyMovements.");
            }
            param1.writeShort(this.keyMovements[_loc2_]);
            _loc2_++;
         }
         if(this.mapId < 0)
         {
            throw new Exception("Forbidden value (" + this.mapId + ") on element mapId.");
         }
         param1.writeInt(this.mapId);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_GameMapMovementRequestMessage(param1);
    }

}