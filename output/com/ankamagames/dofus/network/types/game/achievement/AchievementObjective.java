package com.ankamagames.dofus.network.types.game.achievement;

import java.lang.Exception;
import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class AchievementObjective extends Object implements INetworkType {

  public int id = 0;
  public int maxValue = 0;
  public static final int protocolId = 404;

  public void serialize(ICustomDataOutput param1) {
    if (this.id < 0) {
      throw new Error("Forbidden value (" + this.id + ") on element id.");
    }
    param1.writeVarInt(this.id);
    if (this.maxValue < 0) {
      throw new Error("Forbidden value (" + this.maxValue + ") on element maxValue.");
    }
    param1.writeVarShort(this.maxValue);
  }

  public void deserialize(ICustomDataInput param1) {
    this.id = param1.readUTF();

    this.maxValue = param1.readVarUhShort();
    if (this.maxValue < 0) {
      throw new Error(
          "Forbidden value (" + this.maxValue + ") on element of AchievementObjective.maxValue.");
    }
  }
}
