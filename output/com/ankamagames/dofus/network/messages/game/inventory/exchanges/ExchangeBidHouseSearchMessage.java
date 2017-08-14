package com.ankamagames.dofus.network.messages.game.inventory.exchanges;

import java.lang.Exception;
import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class ExchangeBidHouseSearchMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public int type = 0;
  public int genId = 0;
  public static final int protocolId = 5806;

  public void serialize(ICustomDataOutput param1) {
    if (this.type < 0) {
      throw new Exception("Forbidden value (" + this.type + ") on element type.");
    }
    param1.writeVarInt(this.type);
    if (this.genId < 0) {
      throw new Exception("Forbidden value (" + this.genId + ") on element genId.");
    }
    param1.writeVarShort(this.genId);
  }

  public void deserialize(ICustomDataInput param1) {
    this.type = param1.readByte();
    if (this.type < 0) {
      throw new Exception(
          "Forbidden value (" + this.type + ") on element of UpdateMountBoost.type.");
    }

    this.genId = param1.readVarUhShort();
    if (this.genId < 0) {
      throw new Exception(
          "Forbidden value ("
              + this.genId
              + ") on element of ExchangeBidHouseSearchMessage.genId.");
    }
  }
}
