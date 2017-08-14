package com.ankamagames.dofus.network.types.game.achievement;

import java.lang.Exception;
import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class AchievementRewardable extends Object implements INetworkType {

  public int id = 0;
  public int finishedlevel = 0;
  public static final int protocolId = 412;

  public void serialize(ICustomDataOutput param1) {
    if (this.id < 0) {
      throw new Error("Forbidden value (" + this.id + ") on element id.");
    }
    param1.writeVarShort(this.id);
    if (this.finishedlevel < 0 || this.finishedlevel > 206) {
      throw new Error("Forbidden value (" + this.finishedlevel + ") on element finishedlevel.");
    }
    param1.writeByte(this.finishedlevel);
  }

  public void deserialize(ICustomDataInput param1) {
    this.id = param1.readUTF();

    this.finishedlevel = param1.readUnsignedByte();
    if (this.finishedlevel < 0 || this.finishedlevel > 206) {
      throw new Error(
          "Forbidden value ("
              + this.finishedlevel
              + ") on element of AchievementRewardable.finishedlevel.");
    }
  }
}
