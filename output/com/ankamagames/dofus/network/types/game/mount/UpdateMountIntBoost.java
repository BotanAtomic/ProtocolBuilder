package com.ankamagames.dofus.network.types.game.mount;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class UpdateMountIntBoost extends UpdateMountBoost implements INetworkType {

    private int protocolId = 357;
    private int value = 0;


    public void serialize(ICustomDataOutput param1) {
         super.serializeAs_UpdateMountBoost(param1);
         param1.writeInt(this.value);
    }

    public void deserialize(ICustomDataInput param1) {
         int _loc4_ = 0;
         UpdateMountBoost _loc5_ = null;
         this.rideId = param1.readVarInt();
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            _loc4_ = param1.readUnsignedShort();
            _loc5_ = ProtocolTypeManager.getInstance(UpdateMountBoost,_loc4_);
            _loc5_.deserialize(param1);
            this.boostToUpdateList.push(_loc5_);
            _loc3_++;
         }
         this.value = param1.readInt();
    }

}