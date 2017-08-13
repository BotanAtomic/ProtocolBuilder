package com.ankamagames.dofus.network.types.game.mount;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class UpdateMountIntBoost extends UpdateMountBoost implements INetworkType {

    private int protocolId = 357;
    private int value = 0;


    public void serialize(ICustomDataOutput param1) {
         param1.writeVarInt(this.rideId);
         param1.writeShort(this.boostToUpdateList.length);
         int _loc2_ = 0;
         while(_loc2_ < this.boostToUpdateList.length)
         {
            param1.writeShort((this.boostToUpdateList[_loc2_] as UpdateMountBoost).getTypeId());
            (this.boostToUpdateList[_loc2_] as UpdateMountBoost).serialize(param1);
            _loc2_++;
         }
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