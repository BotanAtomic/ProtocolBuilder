package com.ankamagames.dofus.network.messages.game.shortcut;

import java.lang.Exception;
import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.shortcut.Shortcut;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import com.ankamagames.dofus.network.ProtocolTypeManager;

public class ShortcutBarRefreshMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public int barType = 0;
  public Shortcut shortcut;
  private FuncTree _shortcuttree;
  public static final int protocolId = 6229;

  public void serialize(ICustomDataOutput param1) {
    param1.writeByte(this.barType);
    param1.writeShort(this.shortcut.getTypeId());
    this.shortcut.serialize(param1);
  }

  public void deserialize(ICustomDataInput param1) {
    this.barType = param1.readByte();
    if (this.barType < 0) {
      throw new Exception(
          "Forbidden value ("
              + this.barType
              + ") on element of ShortcutBarSwapRequestMessage.barType.");
    }

    int _loc2_ = param1.readUnsignedShort();
    this.shortcut = ProtocolTypeManager.getInstance(Shortcut, _loc2_);
    this.shortcut.deserialize(param1);
  }
}
