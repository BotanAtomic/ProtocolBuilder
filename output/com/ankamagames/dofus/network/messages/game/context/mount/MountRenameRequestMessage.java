package com.ankamagames.dofus.network.messages.game.context.mount;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class MountRenameRequestMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public String name = "";
  public int mountId = 0;
  public static final int protocolId = 5987;

  public void serialize(ICustomDataOutput param1) {
    param1.writeUTF(this.name);
    param1.writeVarInt(this.mountId);
  }

  public void deserialize(ICustomDataInput param1) {
    this.name = param1.readUTF();

    this.mountId = param1.readInt();
    if (this.mountId < 0) {
      throw new Error(
          "Forbidden value (" + this.mountId + ") on element of ObjectEffectMount.mountId.");
    }
  }
}
