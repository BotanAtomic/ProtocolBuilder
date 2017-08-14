package com.ankamagames.dofus.network.messages.game.inventory.exchanges;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.mount.UpdateMountBoost;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import com.ankamagames.dofus.network.ProtocolTypeManager;

public class UpdateMountBoostMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public int rideId = 0;
  public Vector<UpdateMountBoost> boostToUpdateList;
  private FuncTree _boostToUpdateListtree;
  public static final int protocolId = 6179;

  public void serialize(ICustomDataOutput param1) {
    param1.writeVarInt(this.rideId);
    param1.writeShort(this.boostToUpdateList.length);
    int _loc2_ = 0;
    while (_loc2_ < this.boostToUpdateList.length) {
      param1.writeShort(((UpdateMountBoost) (this.boostToUpdateList[_loc2_])).getTypeId());
      ((UpdateMountBoost) this.boostToUpdateList[_loc2_]).serialize(param1);
      _loc2_++;
    }
  }

  public void deserialize(ICustomDataInput param1) {
    int _loc4_ = 0;
    UpdateMountBoost _loc5_ = null;
    this.rideId = param1.readVarInt();

    int _loc2_ = param1.readUnsignedShort();
    int _loc3_ = 0;
    while (_loc3_ < _loc2_) {
      _loc4_ = param1.readUnsignedShort();
      _loc5_ = ProtocolTypeManager.getInstance(UpdateMountBoost, _loc4_);
      _loc5_.deserialize(param1);
      this.boostToUpdateList.push(_loc5_);
      _loc3_++;
    }
  }
}
