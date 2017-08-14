package com.ankamagames.dofus.network.messages.game.context.fight;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class GameFightReadyMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public boolean isReady = false;
  public static final int protocolId = 708;

  public void serialize(ICustomDataOutput param1) {
    param1.writeBoolean(this.isReady);
  }

  public void deserialize(ICustomDataInput param1) {
    this.isReady = param1.readBoolean();
  }
}
