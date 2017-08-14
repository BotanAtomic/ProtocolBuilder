package com.ankamagames.dofus.network.messages.game.context.fight;

import java.lang.Exception;
import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class GameFightPlacementSwapPositionsCancelledMessage extends NetworkMessage
    implements INetworkMessage {

  private boolean _isInitialized = false;
  public int requestId = 0;
  public Number cancellerId = 0;
  public static final int protocolId = 6546;

  public void serialize(ICustomDataOutput param1) {
    if (this.requestId < 0) {
      throw new Error("Forbidden value (" + this.requestId + ") on element requestId.");
    }
    param1.writeInt(this.requestId);
    if (this.cancellerId < -9.007199254740992E15 || this.cancellerId > 9.007199254740992E15) {
      throw new Error("Forbidden value (" + this.cancellerId + ") on element cancellerId.");
    }
    param1.writeDouble(this.cancellerId);
  }

  public void deserialize(ICustomDataInput param1) {
    this.requestId = param1.readUnsignedByte();
    if (this.requestId < 0 || this.requestId > 255) {
      throw new Error(
          "Forbidden value ("
              + this.requestId
              + ") on element of ContactLookRequestMessage.requestId.");
    }

    this.cancellerId = param1.readDouble();
    if (this.cancellerId < -9.007199254740992E15 || this.cancellerId > 9.007199254740992E15) {
      throw new Error(
          "Forbidden value ("
              + this.cancellerId
              + ") on element of GameFightPlacementSwapPositionsCancelledMessage.cancellerId.");
    }
  }
}
