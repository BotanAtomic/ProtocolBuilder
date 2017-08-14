package com.ankamagames.dofus.network.messages.game.inventory.exchanges;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class ExchangeCraftCountModifiedMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public int count = 0;
  public static final int protocolId = 6595;

  public void serialize(ICustomDataOutput param1) {
    param1.writeVarInt(this.count);
  }

  public void deserialize(ICustomDataInput param1) {
    this.count = param1.readVarInt();
  }
}
