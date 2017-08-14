package com.ankamagames.dofus.network.messages.game.context.mount;

import java.lang.Exception;
import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class PaddockBuyRequestMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public Number proposedPrice = 0;
  public static final int protocolId = 5951;

  public void serialize(ICustomDataOutput param1) {
    if (this.proposedPrice < 0 || this.proposedPrice > 9.007199254740992E15) {
      throw new Error("Forbidden value (" + this.proposedPrice + ") on element proposedPrice.");
    }
    param1.writeVarLong(this.proposedPrice);
  }

  public void deserialize(ICustomDataInput param1) {
    this.proposedPrice = param1.readVarUhLong();
    if (this.proposedPrice < 0 || this.proposedPrice > 9.007199254740992E15) {
      throw new Error(
          "Forbidden value ("
              + this.proposedPrice
              + ") on element of HouseBuyRequestMessage.proposedPrice.");
    }
  }
}
