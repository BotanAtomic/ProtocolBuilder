package com.ankamagames.dofus.network.messages.game.inventory.exchanges;

import java.lang.Exception;
import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class ExchangeCrafterJobLevelupMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public int crafterJobLevel = 0;
  public static final int protocolId = 6598;

  public void serialize(ICustomDataOutput param1) {
    if (this.crafterJobLevel < 0 || this.crafterJobLevel > 255) {
      throw new Error("Forbidden value (" + this.crafterJobLevel + ") on element crafterJobLevel.");
    }
    param1.writeByte(this.crafterJobLevel);
  }

  public void deserialize(ICustomDataInput param1) {
    this.crafterJobLevel = param1.readUnsignedByte();
    if (this.crafterJobLevel < 0 || this.crafterJobLevel > 255) {
      throw new Error(
          "Forbidden value ("
              + this.crafterJobLevel
              + ") on element of ExchangeStartOkMulticraftCustomerMessage.crafterJobLevel.");
    }
  }
}
