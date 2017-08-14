package com.ankamagames.dofus.network.messages.game.pvp;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class SetEnableAVARequestMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public boolean enable = false;
  public static final int protocolId = 6443;

  public void serialize(ICustomDataOutput param1) {
    param1.writeBoolean(this.enable);
  }

  public void deserialize(ICustomDataInput param1) {
    int _loc2_ = param1.readByte();
    if (_loc2_ < 0) {
      throw new Error("Forbidden value (" + _loc2_ + ") on elements of enable.");
    }
    this.enable.push(_loc2_);
  }
}
