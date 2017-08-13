package com.ankamagames.dofus.network.messages.game.interactive;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.interactive.InteractiveElement;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import com.ankamagames.dofus.network.ProtocolTypeManager;

public class InteractiveMapUpdateMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 5002;
    private boolean _isInitialized = false;
    private InteractiveElement[] interactiveElements;
    private FuncTree _interactiveElementstree;


    public void serialize(ICustomDataOutput param1) {
         param1.writeShort(this.interactiveElements.length);
         int _loc2_ = 0;
         while(_loc2_ < this.interactiveElements.length)
         {
            param1.writeShort((this.interactiveElements[_loc2_] as InteractiveElement).getTypeId());
            (this.interactiveElements[_loc2_] as InteractiveElement).serialize(param1);
            _loc2_++;
         }
    }

    public void deserialize(ICustomDataInput param1) {
         int _loc4_ = 0;
         InteractiveElement _loc5_ = null;
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            _loc4_ = param1.readUnsignedShort();
            _loc5_ = ProtocolTypeManager.getInstance(InteractiveElement,_loc4_);
            _loc5_.deserialize(param1);
            this.interactiveElements.push(_loc5_);
            _loc3_++;
         }
    }

}