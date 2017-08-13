package com.ankamagames.dofus.network.messages.game.context;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.context.ActorOrientation;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class GameMapChangeOrientationsMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6155;
    private boolean _isInitialized = false;
    private ActorOrientation[] orientations;
    private FuncTree _orientationstree;


    public void serialize(ICustomDataOutput param1) {
         param1.writeShort(this.orientations.length);
         int _loc2_ = 0;
         while(_loc2_ < this.orientations.length)
         {
            (this.orientations[_loc2_] as ActorOrientation).serializeAs_ActorOrientation(param1);
            _loc2_++;
         }
    }

    public void deserialize(ICustomDataInput param1) {
         ActorOrientation _loc4_ = null;
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            _loc4_ = new ActorOrientation();
            _loc4_.deserialize(param1);
            this.orientations.push(_loc4_);
            _loc3_++;
         }
    }

}