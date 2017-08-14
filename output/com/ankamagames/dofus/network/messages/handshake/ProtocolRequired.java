package com.ankamagames.dofus.network.messages.handshake;

import java.lang.Exception;
import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class ProtocolRequired extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public int requiredVersion = 0;
  public int currentVersion = 0;
  public static final int protocolId = 1;

  public void serialize(ICustomDataOutput param1) {
    if (this.requiredVersion < 0) {
      throw new Error("Forbidden value (" + this.requiredVersion + ") on element requiredVersion.");
    }
    param1.writeInt(this.requiredVersion);
    if (this.currentVersion < 0) {
      throw new Error("Forbidden value (" + this.currentVersion + ") on element currentVersion.");
    }
    param1.writeInt(this.currentVersion);
  }

  public void deserialize(ICustomDataInput param1) {
    this.requiredVersion = param1.readInt();
    if (this.requiredVersion < 0) {
      throw new Error(
          "Forbidden value ("
              + this.requiredVersion
              + ") on element of ProtocolRequired.requiredVersion.");
    }

    this.currentVersion = param1.readInt();
    if (this.currentVersion < 0) {
      throw new Error(
          "Forbidden value ("
              + this.currentVersion
              + ") on element of ProtocolRequired.currentVersion.");
    }
  }
}
