package com.ankamagames.dofus.network.messages.game.pvp;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class UpdateMapPlayersAgressableStatusMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6454;
    private boolean _isInitialized = false;
    private Number[] playerIds;
    private int[] enable;
    private FuncTree _playerIdstree;
    private FuncTree _enabletree;


    public void serialize(ICustomDataOutput param1) {
         param1.writeShort(this.playerIds.length);
         int _loc2_ = 0;
         while(_loc2_ < this.playerIds.length)
         {
            if(this.playerIds[_loc2_] < 0 || this.playerIds[_loc2_] > 9.007199254740992E15)
            {
               throw new Exception("Forbidden value (" + this.playerIds[_loc2_] + ") on element 1 (starting at 1) of playerIds.");
            }
            param1.writeVarLong(this.playerIds[_loc2_]);
            _loc2_++;
         }
         param1.writeShort(this.enable.length);
         int _loc3_ = 0;
         while(_loc3_ < this.enable.length)
         {
            param1.writeByte(this.enable[_loc3_]);
            _loc3_++;
         }
    }

    public void deserialize(ICustomDataInput param1) {
         Object _loc6_ = NaN;
         int _loc7_ = 0;
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            _loc6_ = param1.readVarUhLong();
            if(_loc6_ < 0 || _loc6_ > 9.007199254740992E15)
            {
               throw new Exception("Forbidden value (" + _loc6_ + ") on elements of playerIds.");
            }
            this.playerIds.push(_loc6_);
            _loc3_++;
         }
         int _loc4_ = param1.readUnsignedShort();
         int _loc5_ = 0;
         while(_loc5_ < _loc4_)
         {
            _loc7_ = param1.readByte();
            if(_loc7_ < 0)
            {
               throw new Exception("Forbidden value (" + _loc7_ + ") on elements of enable.");
            }
            this.enable.push(_loc7_);
            _loc5_++;
         }
    }

}