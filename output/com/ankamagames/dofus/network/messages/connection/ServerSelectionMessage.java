package com.ankamagames.dofus.network.messages.connection;

import java.lang.Exception;
import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class ServerSelectionMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public int serverId = 0;
  public static final int protocolId = 40;

  public void serialize(ICustomDataOutput param1) {
    if (this.serverId < 0) {
      throw new Exception("Forbidden value (" + this.serverId + ") on element serverId.");
    }
    param1.writeVarShort(this.serverId);
  }

  public void deserialize(ICustomDataInput param1) {
    this.serverId = param1.readShort();
  }
}
