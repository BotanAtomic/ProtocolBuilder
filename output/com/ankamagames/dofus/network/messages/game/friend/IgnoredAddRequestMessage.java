package com.ankamagames.dofus.network.messages.game.friend;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class IgnoredAddRequestMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public String name = "";
  public boolean session = false;
  public static final int protocolId = 5673;

  public void serialize(ICustomDataOutput param1) {
    param1.writeUTF(this.name);
    param1.writeBoolean(this.session);
  }

  public void deserialize(ICustomDataInput param1) {
    this.name = param1.readUTF();

    this.session = param1.readBoolean();
  }
}
