package com.ankamagames.dofus.network.messages.game.inventory.exchanges;

import java.lang.Exception;
import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class ExchangeCraftResultMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public int craftResult = 0;
  public static final int protocolId = 5790;

  public void serialize(ICustomDataOutput param1) {
    param1.writeByte(this.craftResult);
  }

  public void deserialize(ICustomDataInput param1) {
    this.craftResult = param1.readByte();
    if (this.craftResult < 0) {
      throw new Error(
          "Forbidden value ("
              + this.craftResult
              + ") on element of ExchangeCraftResultMessage.craftResult.");
    }
  }
}
