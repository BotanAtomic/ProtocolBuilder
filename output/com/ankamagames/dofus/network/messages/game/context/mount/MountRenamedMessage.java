package com.ankamagames.dofus.network.messages.game.context.mount;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class MountRenamedMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public int mountId = 0;
  public String name = "";
  public static final int protocolId = 5983;

  public void serialize(ICustomDataOutput param1) {
    param1.writeVarInt(this.mountId);
    param1.writeUTF(this.name);
  }

  public void deserialize(ICustomDataInput param1) {
    this.mountId = param1.readInt();
    if (this.mountId < 0) {
      throw new Error(
          "Forbidden value (" + this.mountId + ") on element of ObjectEffectMount.mountId.");
    }

    this.name = param1.readUTF();
  }
}
