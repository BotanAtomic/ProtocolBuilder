package com.ankamagames.dofus.network.types.game.data.items.effects;

import java.lang.Exception;
import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class ObjectEffect extends Object implements INetworkType {

  public int actionId = 0;
  public static final int protocolId = 76;

  public void serialize(ICustomDataOutput param1) {
    if (this.actionId < 0) {
      throw new Error("Forbidden value (" + this.actionId + ") on element actionId.");
    }
    param1.writeVarShort(this.actionId);
  }

  public void deserialize(ICustomDataInput param1) {
    this.actionId = param1.readVarUhShort();
    if (this.actionId < 0) {
      throw new Error(
          "Forbidden value (" + this.actionId + ") on element of ObjectEffect.actionId.");
    }
  }
}
