package com.ankamagames.dofus.network.types.game.interactive;

import java.lang.Exception;
import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class MapObstacle extends Object implements INetworkType {

  public int obstacleCellId = 0;
  public int state = 0;
  public static final int protocolId = 200;

  public void serialize(ICustomDataOutput param1) {
    if (this.obstacleCellId < 0 || this.obstacleCellId > 559) {
      throw new Error("Forbidden value (" + this.obstacleCellId + ") on element obstacleCellId.");
    }
    param1.writeVarShort(this.obstacleCellId);
    param1.writeByte(this.state);
  }

  public void deserialize(ICustomDataInput param1) {
    this.obstacleCellId = param1.readVarUhShort();
    if (this.obstacleCellId < 0 || this.obstacleCellId > 559) {
      throw new Error(
          "Forbidden value ("
              + this.obstacleCellId
              + ") on element of MapObstacle.obstacleCellId.");
    }

    this.state = param1.readByte();
    if (this.state < 0) {
      throw new Error("Forbidden value (" + this.state + ") on element of ContentPart.state.");
    }
  }
}
