package com.ankamagames.dofus.network.messages.game.friend;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class FriendSetWarnOnConnectionMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public boolean enable = false;
  public static final int protocolId = 5602;

  public void serialize(ICustomDataOutput param1) {
    param1.writeBoolean(this.enable);
  }

  public void deserialize(ICustomDataInput param1) {
    int _loc2_ = param1.readByte();
    if (_loc2_ < 0) {
      throw new Exception("Forbidden value (" + _loc2_ + ") on elements of enable.");
    }
    this.enable.push(_loc2_);
  }
}
