package com.ankamagames.dofus.network.messages.common.basic;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class BasicPingMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public boolean quiet = false;
  public static final int protocolId = 182;

  public void serialize(ICustomDataOutput param1) {
    param1.writeBoolean(this.quiet);
  }

  public void deserialize(ICustomDataInput param1) {
    this.quiet = param1.readBoolean();
  }
}
