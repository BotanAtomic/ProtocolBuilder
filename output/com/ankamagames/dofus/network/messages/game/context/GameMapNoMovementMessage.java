package com.ankamagames.dofus.network.messages.game.context;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class GameMapNoMovementMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public int cellX = 0;
  public int cellY = 0;
  public static final int protocolId = 954;

  public void serialize(ICustomDataOutput param1) {
    param1.writeShort(this.cellX);
    param1.writeShort(this.cellY);
  }

  public void deserialize(ICustomDataInput param1) {
    this.cellX = param1.readShort();

    this.cellY = param1.readShort();
  }
}
