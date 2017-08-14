package com.ankamagames.dofus.network.messages.game.prism;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class PrismInfoJoinLeaveRequestMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public boolean join = false;
  public static final int protocolId = 5844;

  public void serialize(ICustomDataOutput param1) {
    param1.writeBoolean(this.join);
  }

  public void deserialize(ICustomDataInput param1) {
    this.join = param1.readBoolean();
  }
}
