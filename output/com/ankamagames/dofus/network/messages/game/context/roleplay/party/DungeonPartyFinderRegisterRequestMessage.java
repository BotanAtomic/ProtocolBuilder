package com.ankamagames.dofus.network.messages.game.context.roleplay.party;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class DungeonPartyFinderRegisterRequestMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6249;
    private boolean _isInitialized = false;
    private int[] dungeonIds;
    private FuncTree _dungeonIdstree;


    public void serialize(ICustomDataOutput param1) {
         param1.writeShort(this.dungeonIds.length);
         int _loc2_ = 0;
         while(_loc2_ < this.dungeonIds.length)
         {
            if(this.dungeonIds[_loc2_] < 0)
            {
               throw new Exception("Forbidden value (" + this.dungeonIds[_loc2_] + ") on element 1 (starting at 1) of dungeonIds.");
            }
            param1.writeVarShort(this.dungeonIds[_loc2_]);
            _loc2_++;
         }
    }

    public void deserialize(ICustomDataInput param1) {
         int _loc4_ = 0;
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            _loc4_ = param1.readVarUhShort();
            if(_loc4_ < 0)
            {
               throw new Exception("Forbidden value (" + _loc4_ + ") on elements of dungeonIds.");
            }
            this.dungeonIds.push(_loc4_);
            _loc3_++;
         }
    }

}