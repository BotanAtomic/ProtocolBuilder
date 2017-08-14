package com.ankamagames.dofus.network.types.game.fight;

import java.lang.Exception;
import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class ProtectedEntityWaitingForHelpInfo extends Object implements INetworkType {

  public int timeLeftBeforeFight = 0;
  public int waitTimeForPlacement = 0;
  public int nbPositionForDefensors = 0;
  public static final int protocolId = 186;

  public void serialize(ICustomDataOutput param1) {
    param1.writeInt(this.timeLeftBeforeFight);
    param1.writeInt(this.waitTimeForPlacement);
    if (this.nbPositionForDefensors < 0) {
      throw new Error(
          "Forbidden value ("
              + this.nbPositionForDefensors
              + ") on element nbPositionForDefensors.");
    }
    param1.writeByte(this.nbPositionForDefensors);
  }

  public void deserialize(ICustomDataInput param1) {
    this.timeLeftBeforeFight = param1.readInt();

    this.waitTimeForPlacement = param1.readInt();

    this.nbPositionForDefensors = param1.readByte();
    if (this.nbPositionForDefensors < 0) {
      throw new Error(
          "Forbidden value ("
              + this.nbPositionForDefensors
              + ") on element of ProtectedEntityWaitingForHelpInfo.nbPositionForDefensors.");
    }
  }
}
