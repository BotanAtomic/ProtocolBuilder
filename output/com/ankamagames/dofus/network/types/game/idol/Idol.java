package com.ankamagames.dofus.network.types.game.idol;

import java.lang.Exception;
import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class Idol extends Object implements INetworkType {

  public int id = 0;
  public int xpBonusPercent = 0;
  public int dropBonusPercent = 0;
  public static final int protocolId = 489;

  public void serialize(ICustomDataOutput param1) {
    if (this.id < 0) {
      throw new Error("Forbidden value (" + this.id + ") on element id.");
    }
    param1.writeVarShort(this.id);
    if (this.xpBonusPercent < 0) {
      throw new Error("Forbidden value (" + this.xpBonusPercent + ") on element xpBonusPercent.");
    }
    param1.writeVarShort(this.xpBonusPercent);
    if (this.dropBonusPercent < 0) {
      throw new Error(
          "Forbidden value (" + this.dropBonusPercent + ") on element dropBonusPercent.");
    }
    param1.writeVarShort(this.dropBonusPercent);
  }

  public void deserialize(ICustomDataInput param1) {
    this.id = param1.readUTF();

    this.xpBonusPercent = param1.readVarUhShort();
    if (this.xpBonusPercent < 0) {
      throw new Error(
          "Forbidden value (" + this.xpBonusPercent + ") on element of Idol.xpBonusPercent.");
    }

    this.dropBonusPercent = param1.readVarUhShort();
    if (this.dropBonusPercent < 0) {
      throw new Error(
          "Forbidden value (" + this.dropBonusPercent + ") on element of Idol.dropBonusPercent.");
    }
  }
}
