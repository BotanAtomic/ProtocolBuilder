package com.ankamagames.dofus.network.messages.game.context.roleplay.job;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class JobAllowMultiCraftRequestMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public boolean enabled = false;
  public static final int protocolId = 5748;

  public void serialize(ICustomDataOutput param1) {
    param1.writeBoolean(this.enabled);
  }

  public void deserialize(ICustomDataInput param1) {
    this.enabled = param1.readBoolean();
  }
}
