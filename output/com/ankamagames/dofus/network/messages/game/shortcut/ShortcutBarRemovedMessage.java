package com.ankamagames.dofus.network.messages.game.shortcut;

import java.lang.Exception;
import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class ShortcutBarRemovedMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public int barType = 0;
  public int slot = 0;
  public static final int protocolId = 6224;

  public void serialize(ICustomDataOutput param1) {
    param1.writeByte(this.barType);
    if (this.slot < 0 || this.slot > 99) {
      throw new Exception("Forbidden value (" + this.slot + ") on element slot.");
    }
    param1.writeByte(this.slot);
  }

  public void deserialize(ICustomDataInput param1) {
    this.barType = param1.readByte();
    if (this.barType < 0) {
      throw new Exception(
          "Forbidden value ("
              + this.barType
              + ") on element of ShortcutBarSwapRequestMessage.barType.");
    }

    this.slot = param1.readByte();
    if (this.slot < 0 || this.slot > 99) {
      throw new Exception("Forbidden value (" + this.slot + ") on element of Shortcut.slot.");
    }
  }
}
