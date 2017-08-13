package com.ankamagames.dofus.network.messages.game.context;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class GameContextRemoveMultipleElementsMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 252;
    private boolean _isInitialized = false;
    private Number[] elementsIds;
    private FuncTree _elementsIdstree;


    public void serialize(ICustomDataOutput param1) {
         param1.writeShort(this.elementsIds.length);
         int _loc2_ = 0;
         while(_loc2_ < this.elementsIds.length)
         {
            if(this.elementsIds[_loc2_] < -9.007199254740992E15 || this.elementsIds[_loc2_] > 9.007199254740992E15)
            {
               throw new Exception("Forbidden value (" + this.elementsIds[_loc2_] + ") on element 1 (starting at 1) of elementsIds.");
            }
            param1.writeDouble(this.elementsIds[_loc2_]);
            _loc2_++;
         }
    }

    public void deserialize(ICustomDataInput param1) {
         Object _loc4_ = NaN;
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            _loc4_ = param1.readDouble();
            if(_loc4_ < -9.007199254740992E15 || _loc4_ > 9.007199254740992E15)
            {
               throw new Exception("Forbidden value (" + _loc4_ + ") on elements of elementsIds.");
            }
            this.elementsIds.push(_loc4_);
            _loc3_++;
         }
    }

}