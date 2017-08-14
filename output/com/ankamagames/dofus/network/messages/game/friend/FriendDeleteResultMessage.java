package com.ankamagames.dofus.network.messages.game.friend;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class FriendDeleteResultMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public boolean success = false;
  public String name = "";
  public static final int protocolId = 5601;

  public void serialize(ICustomDataOutput param1) {
    param1.writeBoolean(this.success);
    param1.writeUTF(this.name);
  }

  public void deserialize(ICustomDataInput param1) {
    this.success = param1.readBoolean();

    this.name = param1.readUTF();
  }
}
