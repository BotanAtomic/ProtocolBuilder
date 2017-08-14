package com.ankamagames.dofus.network.messages.game.context;

import java.lang.Exception;
import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class GameMapChangeOrientationRequestMessage extends NetworkMessage
    implements INetworkMessage {

  private boolean _isInitialized = false;
  public int direction = 1;
  public static final int protocolId = 945;

  public void serialize(ICustomDataOutput param1) {
    param1.writeByte(this.direction);
  }

  public void deserialize(ICustomDataInput param1) {
    this.direction = param1.readByte();
    if (this.direction < 0) {
      throw new Error(
          "Forbidden value ("
              + this.direction
              + ") on element of TreasureHuntStepFollowDirectionToPOI.direction.");
    }
  }
}
