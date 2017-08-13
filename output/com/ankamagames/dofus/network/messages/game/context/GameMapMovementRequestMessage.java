package com.ankamagames.dofus.network.messages.game.context;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class GameMapMovementRequestMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 950;
    private boolean _isInitialized = false;
    private int[] keyMovements;
    private int mapId = 0;
    private FuncTree _keyMovementstree;


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
         int _loc4_ = 0;
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            _loc4_ = param1.readShort();
            if(_loc4_ < 0)
            {
               throw new Exception("Forbidden value (" + _loc4_ + ") on elements of keyMovements.");
            }
            this.keyMovements.push(_loc4_);
            _loc3_++;
         }
         this.mapId = param1.readInt();
         if(this.mapId < 0)
         {
            throw new Exception("Forbidden value (" + this.mapId + ") on element of GameMapMovementRequestMessage.mapId.");
         }
    }

}