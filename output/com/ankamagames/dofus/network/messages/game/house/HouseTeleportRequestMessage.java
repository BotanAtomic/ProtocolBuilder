package com.ankamagames.dofus.network.messages.game.house;

import java.lang.Exception;
import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class HouseTeleportRequestMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public int houseId = 0;
  public int houseInstanceId = 0;
  public static final int protocolId = 6726;

  public void serialize(ICustomDataOutput param1) {
    if (this.houseId < 0) {
      throw new Error("Forbidden value (" + this.houseId + ") on element houseId.");
    }
    param1.writeVarInt(this.houseId);
    param1.writeInt(this.houseInstanceId);
  }

  public void deserialize(ICustomDataInput param1) {
    this.houseId = param1.readVarUhInt();
    if (this.houseId < 0) {
      throw new Error(
          "Forbidden value (" + this.houseId + ") on element of HouseInformations.houseId.");
    }

    this.houseInstanceId = param1.readInt();
  }
}
