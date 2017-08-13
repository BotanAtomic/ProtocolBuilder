package com.ankamagames.dofus.network.messages.game.context.roleplay.treasureHunt;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class TreasureHuntShowLegendaryUIMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6498;
    private boolean _isInitialized = false;
    private int[] availableLegendaryIds;
    private FuncTree _availableLegendaryIdstree;


    public void serialize(ICustomDataOutput param1) {
         param1.writeShort(this.availableLegendaryIds.length);
         int _loc2_ = 0;
         while(_loc2_ < this.availableLegendaryIds.length)
         {
            if(this.availableLegendaryIds[_loc2_] < 0)
            {
               throw new Exception("Forbidden value (" + this.availableLegendaryIds[_loc2_] + ") on element 1 (starting at 1) of availableLegendaryIds.");
            }
            param1.writeVarShort(this.availableLegendaryIds[_loc2_]);
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
               throw new Exception("Forbidden value (" + _loc4_ + ") on elements of availableLegendaryIds.");
            }
            this.availableLegendaryIds.push(_loc4_);
            _loc3_++;
         }
    }

}