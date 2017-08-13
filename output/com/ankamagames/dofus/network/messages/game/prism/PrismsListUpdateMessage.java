package com.ankamagames.dofus.network.messages.game.prism;

import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.prism.PrismSubareaEmptyInfo;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class PrismsListUpdateMessage extends PrismsListMessage implements INetworkMessage {

    private int protocolId = 6438;
    private boolean _isInitialized = false;


    public void serialize(ICustomDataOutput param1) {
         param1.writeShort(this.prisms.length);
         int _loc2_ = 0;
         while(_loc2_ < this.prisms.length)
         {
            param1.writeShort((this.prisms[_loc2_] as PrismSubareaEmptyInfo).getTypeId());
            (this.prisms[_loc2_] as PrismSubareaEmptyInfo).serialize(param1);
            _loc2_++;
         }
    }

    public void deserialize(ICustomDataInput param1) {
         int _loc4_ = 0;
         PrismSubareaEmptyInfo _loc5_ = null;
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            _loc4_ = param1.readUnsignedShort();
            _loc5_ = ProtocolTypeManager.getInstance(PrismSubareaEmptyInfo,_loc4_);
            _loc5_.deserialize(param1);
            this.prisms.push(_loc5_);
            _loc3_++;
         }
    }

}