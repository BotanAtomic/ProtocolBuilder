package com.ankamagames.dofus.network.messages.game.inventory.exchanges;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class ExchangeObjectMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public boolean remote = false;
  public static final int protocolId = 5515;

  public void serialize(ICustomDataOutput param1) {
    param1.writeBoolean(this.remote);
  }

  public void deserialize(ICustomDataInput param1) {
    this.remote = param1.readBoolean();
  }
}
