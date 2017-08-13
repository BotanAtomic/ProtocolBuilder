package com.ankamagames.dofus.network.messages.game.interactive;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.interactive.StatedElement;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class StatedMapUpdateMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 5716;
    private boolean _isInitialized = false;
    private StatedElement[] statedElements;
    private FuncTree _statedElementstree;


    public void serialize(ICustomDataOutput param1) {
         param1.writeShort(this.statedElements.length);
         int _loc2_ = 0;
         while(_loc2_ < this.statedElements.length)
         {
            (this.statedElements[_loc2_] as StatedElement).serializeAs_StatedElement(param1);
            _loc2_++;
         }
    }

    public void deserialize(ICustomDataInput param1) {
         StatedElement _loc4_ = null;
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            _loc4_ = new StatedElement();
            _loc4_.deserialize(param1);
            this.statedElements.push(_loc4_);
            _loc3_++;
         }
    }

}