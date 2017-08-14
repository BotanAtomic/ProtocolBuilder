package com.ankamagames.dofus.network.types.game.approach;

import java.lang.Exception;
import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class ServerSessionConstant extends Object implements INetworkType {

  public int id = 0;
  public static final int protocolId = 430;

  public void serialize(ICustomDataOutput param1) {
    if (this.id < 0) {
      throw new Error("Forbidden value (" + this.id + ") on element id.");
    }
    param1.writeVarShort(this.id);
  }

  public void deserialize(ICustomDataInput param1) {
    this.id = param1.readUTF();
  }
}
