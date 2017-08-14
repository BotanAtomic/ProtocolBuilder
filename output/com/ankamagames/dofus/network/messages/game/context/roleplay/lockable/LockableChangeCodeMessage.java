package com.ankamagames.dofus.network.messages.game.context.roleplay.lockable;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class LockableChangeCodeMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public String code = "";
  public static final int protocolId = 5666;

  public void serialize(ICustomDataOutput param1) {
    param1.writeUTF(this.code);
  }

  public void deserialize(ICustomDataInput param1) {
    this.code = param1.readByte();
    if (this.code < 0) {
      throw new Exception(
          "Forbidden value ("
              + this.code
              + ") on element of InventoryPresetUseResultMessage.code.");
    }
  }
}
