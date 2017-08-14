package com.ankamagames.dofus.network.messages.game.inventory.storage;

import java.lang.Exception;
import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class StorageKamasUpdateMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public Number kamasTotal = 0;
  public static final int protocolId = 5645;

  public void serialize(ICustomDataOutput param1) {
    if (this.kamasTotal < 0 || this.kamasTotal > 9.007199254740992E15) {
      throw new Exception("Forbidden value (" + this.kamasTotal + ") on element kamasTotal.");
    }
    param1.writeVarLong(this.kamasTotal);
  }

  public void deserialize(ICustomDataInput param1) {
    this.kamasTotal = param1.readVarUhLong();
    if (this.kamasTotal < 0 || this.kamasTotal > 9.007199254740992E15) {
      throw new Exception(
          "Forbidden value ("
              + this.kamasTotal
              + ") on element of StorageKamasUpdateMessage.kamasTotal.");
    }
  }
}
