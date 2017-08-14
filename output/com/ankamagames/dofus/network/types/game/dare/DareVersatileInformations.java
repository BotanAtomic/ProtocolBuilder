package com.ankamagames.dofus.network.types.game.dare;

import java.lang.Exception;
import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class DareVersatileInformations extends Object implements INetworkType {

  public Number dareId = 0;
  public int countEntrants = 0;
  public int countWinners = 0;
  public static final int protocolId = 504;

  public void serialize(ICustomDataOutput param1) {
    if (this.dareId < 0 || this.dareId > 9.007199254740992E15) {
      throw new Exception("Forbidden value (" + this.dareId + ") on element dareId.");
    }
    param1.writeDouble(this.dareId);
    if (this.countEntrants < 0) {
      throw new Exception("Forbidden value (" + this.countEntrants + ") on element countEntrants.");
    }
    param1.writeInt(this.countEntrants);
    if (this.countWinners < 0) {
      throw new Exception("Forbidden value (" + this.countWinners + ") on element countWinners.");
    }
    param1.writeInt(this.countWinners);
  }

  public void deserialize(ICustomDataInput param1) {
    this.dareId = param1.readDouble();
    if (this.dareId < 0 || this.dareId > 9.007199254740992E15) {
      throw new Exception(
          "Forbidden value (" + this.dareId + ") on element of DareVersatileInformations.dareId.");
    }

    this.countEntrants = param1.readInt();
    if (this.countEntrants < 0) {
      throw new Exception(
          "Forbidden value ("
              + this.countEntrants
              + ") on element of DareVersatileInformations.countEntrants.");
    }

    this.countWinners = param1.readInt();
    if (this.countWinners < 0) {
      throw new Exception(
          "Forbidden value ("
              + this.countWinners
              + ") on element of DareVersatileInformations.countWinners.");
    }
  }
}
