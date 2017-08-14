package com.ankamagames.dofus.network.messages.game.context.fight;

import java.lang.Exception;
import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class GameFightNewRoundMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public int roundNumber = 0;
  public static final int protocolId = 6239;

  public void serialize(ICustomDataOutput param1) {
    if (this.roundNumber < 0) {
      throw new Exception("Forbidden value (" + this.roundNumber + ") on element roundNumber.");
    }
    param1.writeVarInt(this.roundNumber);
  }

  public void deserialize(ICustomDataInput param1) {
    this.roundNumber = param1.readVarUhInt();
    if (this.roundNumber < 0) {
      throw new Exception(
          "Forbidden value ("
              + this.roundNumber
              + ") on element of GameFightNewRoundMessage.roundNumber.");
    }
  }
}
