package com.ankamagames.dofus.network.messages.game.friend;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.friend.IgnoredInformations;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import com.ankamagames.dofus.network.ProtocolTypeManager;

public class IgnoredListMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 5674;
    private boolean _isInitialized = false;
    private IgnoredInformations[] ignoredList;
    private FuncTree _ignoredListtree;


    public void serialize(ICustomDataOutput param1) {
         param1.writeShort(this.ignoredList.length);
         int _loc2_ = 0;
         while(_loc2_ < this.ignoredList.length)
         {
            param1.writeShort((this.ignoredList[_loc2_] as IgnoredInformations).getTypeId());
            (this.ignoredList[_loc2_] as IgnoredInformations).serialize(param1);
            _loc2_++;
         }
    }

    public void deserialize(ICustomDataInput param1) {
         int _loc4_ = 0;
         IgnoredInformations _loc5_ = null;
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            _loc4_ = param1.readUnsignedShort();
            _loc5_ = ProtocolTypeManager.getInstance(IgnoredInformations,_loc4_);
            _loc5_.deserialize(param1);
            this.ignoredList.push(_loc5_);
            _loc3_++;
         }
    }

}