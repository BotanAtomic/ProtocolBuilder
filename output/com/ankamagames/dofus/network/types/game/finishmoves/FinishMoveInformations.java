package com.ankamagames.dofus.network.types.game.finishmoves;

import java.lang.Exception;
import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class FinishMoveInformations extends Object implements INetworkType {

  public int finishMoveId = 0;
  public boolean finishMoveState = false;
  public static final int protocolId = 506;

  public void serialize(ICustomDataOutput param1) {
    if (this.finishMoveId < 0) {
      throw new Error("Forbidden value (" + this.finishMoveId + ") on element finishMoveId.");
    }
    param1.writeInt(this.finishMoveId);
    param1.writeBoolean(this.finishMoveState);
  }

  public void deserialize(ICustomDataInput param1) {
    this.finishMoveId = param1.readInt();
    if (this.finishMoveId < 0) {
      throw new Error(
          "Forbidden value ("
              + this.finishMoveId
              + ") on element of FinishMoveInformations.finishMoveId.");
    }

    this.finishMoveState = param1.readBoolean();
  }
}
