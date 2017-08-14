package com.ankamagames.dofus.network.messages.game.context.fight;

import java.lang.Exception;
import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class GameFightPlacementSwapPositionsAcceptMessage extends NetworkMessage
    implements INetworkMessage {

  private boolean _isInitialized = false;
  public int requestId = 0;
  public static final int protocolId = 6547;

  public void serialize(ICustomDataOutput param1) {
    if (this.requestId < 0) {
      throw new Exception("Forbidden value (" + this.requestId + ") on element requestId.");
    }
    param1.writeInt(this.requestId);
  }

  public void deserialize(ICustomDataInput param1) {
    this.requestId = param1.readUnsignedByte();
    if (this.requestId < 0 || this.requestId > 255) {
      throw new Exception(
          "Forbidden value ("
              + this.requestId
              + ") on element of ContactLookRequestMessage.requestId.");
    }
  }
}
