package com.ankamagames.dofus.network.messages.game.inventory.exchanges;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.context.roleplay.job.DecraftedItemStackInfo;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class DecraftResultMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6569;
    private boolean _isInitialized = false;
    private DecraftedItemStackInfo[] results;
    private FuncTree _resultstree;


    public void serialize(ICustomDataOutput param1) {
         param1.writeShort(this.results.length);
         int _loc2_ = 0;
         while(_loc2_ < this.results.length)
         {
            (this.results[_loc2_] as DecraftedItemStackInfo).serializeAs_DecraftedItemStackInfo(param1);
            _loc2_++;
         }
    }

    public void deserialize(ICustomDataInput param1) {
         DecraftedItemStackInfo _loc4_ = null;
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            _loc4_ = new DecraftedItemStackInfo();
            _loc4_.deserialize(param1);
            this.results.push(_loc4_);
            _loc3_++;
         }
    }

}