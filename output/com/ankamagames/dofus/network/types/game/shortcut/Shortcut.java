package com.ankamagames.dofus.network.types.game.shortcut;

import java.lang.Exception;
import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class Shortcut extends Object implements INetworkType {

  public int slot = 0;
  public static final int protocolId = 369;

  public void serialize(ICustomDataOutput param1) {
    if (this.slot < 0 || this.slot > 99) {
      throw new Exception("Forbidden value (" + this.slot + ") on element slot.");
    }
    param1.writeByte(this.slot);
  }

  public void deserialize(ICustomDataInput param1) {
    this.slot = param1.readByte();
    if (this.slot < 0 || this.slot > 99) {
      throw new Exception("Forbidden value (" + this.slot + ") on element of Shortcut.slot.");
    }
  }
}
