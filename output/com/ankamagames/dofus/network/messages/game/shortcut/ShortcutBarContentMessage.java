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

public class ShortcutBarContentMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public int barType = 0;
  public Vector<Shortcut> shortcuts;
  private FuncTree _shortcutstree;
  public static final int protocolId = 6231;

  public void serialize(ICustomDataOutput param1) {
    param1.writeByte(this.barType);
    param1.writeShort(this.shortcuts.length);
    int _loc2_ = 0;
    while (_loc2_ < this.shortcuts.length) {
      param1.writeShort(((Shortcut) (this.shortcuts[_loc2_])).getTypeId());
      ((Shortcut) this.shortcuts[_loc2_]).serialize(param1);
      _loc2_++;
    }
  }

  public void deserialize(ICustomDataInput param1) {
    int _loc4_ = 0;
    Shortcut _loc5_ = null;
    this.barType = param1.readByte();
    if (this.barType < 0) {
      throw new Exception(
          "Forbidden value ("
              + this.barType
              + ") on element of ShortcutBarSwapRequestMessage.barType.");
    }

    int _loc2_ = param1.readUnsignedShort();
    int _loc3_ = 0;
    while (_loc3_ < _loc2_) {
      _loc4_ = param1.readUnsignedShort();
      _loc5_ = ProtocolTypeManager.getInstance(Shortcut, _loc4_);
      _loc5_.deserialize(param1);
      this.shortcuts.push(_loc5_);
      _loc3_++;
    }
  }
}
