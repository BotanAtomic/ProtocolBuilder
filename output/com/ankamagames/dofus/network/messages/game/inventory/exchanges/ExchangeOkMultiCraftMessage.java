package com.ankamagames.dofus.network.messages.game.inventory.exchanges;

import java.lang.Exception;
import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class ExchangeOkMultiCraftMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public Number initiatorId = 0;
  public Number otherId = 0;
  public int role = 0;
  public static final int protocolId = 5768;

  public void serialize(ICustomDataOutput param1) {
    if (this.initiatorId < 0 || this.initiatorId > 9.007199254740992E15) {
      throw new Error("Forbidden value (" + this.initiatorId + ") on element initiatorId.");
    }
    param1.writeVarLong(this.initiatorId);
    if (this.otherId < 0 || this.otherId > 9.007199254740992E15) {
      throw new Error("Forbidden value (" + this.otherId + ") on element otherId.");
    }
    param1.writeVarLong(this.otherId);
    param1.writeByte(this.role);
  }

  public void deserialize(ICustomDataInput param1) {
    this.initiatorId = param1.readVarUhLong();
    if (this.initiatorId < 0 || this.initiatorId > 9.007199254740992E15) {
      throw new Error(
          "Forbidden value ("
              + this.initiatorId
              + ") on element of ExchangeOkMultiCraftMessage.initiatorId.");
    }

    this.otherId = param1.readVarUhLong();
    if (this.otherId < 0 || this.otherId > 9.007199254740992E15) {
      throw new Error(
          "Forbidden value ("
              + this.otherId
              + ") on element of ExchangeOkMultiCraftMessage.otherId.");
    }

    this.role = param1.readByte();
  }
}
