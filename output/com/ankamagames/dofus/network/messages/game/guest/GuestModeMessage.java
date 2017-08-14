package com.ankamagames.dofus.network.messages.game.guest;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class GuestModeMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public boolean active = false;
  public static final int protocolId = 6505;

  public void serialize(ICustomDataOutput param1) {
    param1.writeBoolean(this.active);
  }

  public void deserialize(ICustomDataInput param1) {
    this.active = param1.readBoolean();
  }
}
