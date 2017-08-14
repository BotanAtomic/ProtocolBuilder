package com.ankamagames.dofus.network.messages.game.context.roleplay.havenbag.meeting;

import java.lang.Exception;
import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class HavenBagPermissionsUpdateRequestMessage extends NetworkMessage
    implements INetworkMessage {

  private boolean _isInitialized = false;
  public int permissions = 0;
  public static final int protocolId = 6714;

  public void serialize(ICustomDataOutput param1) {
    if (this.permissions < 0) {
      throw new Error("Forbidden value (" + this.permissions + ") on element permissions.");
    }
    param1.writeInt(this.permissions);
  }

  public void deserialize(ICustomDataInput param1) {
    this.permissions = param1.readInt();
    if (this.permissions < 0) {
      throw new Error(
          "Forbidden value ("
              + this.permissions
              + ") on element of HavenBagPermissionsUpdateRequestMessage.permissions.");
    }
  }
}
