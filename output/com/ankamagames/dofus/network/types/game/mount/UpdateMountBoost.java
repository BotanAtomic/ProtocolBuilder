package com.ankamagames.dofus.network.types.game.mount;

import java.lang.Exception;
import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class UpdateMountBoost extends Object implements INetworkType {

  public int type = 0;
  public static final int protocolId = 356;

  public void serialize(ICustomDataOutput param1) {
    param1.writeByte(this.type);
  }

  public void deserialize(ICustomDataInput param1) {
    this.type = param1.readByte();
    if (this.type < 0) {
      throw new Exception(
          "Forbidden value (" + this.type + ") on element of UpdateMountBoost.type.");
    }
  }
}
