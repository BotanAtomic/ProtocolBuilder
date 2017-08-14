package com.ankamagames.dofus.network.types.game.context;

import java.lang.Exception;
import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class EntityDispositionInformations extends Object implements INetworkType {

  public int cellId = 0;
  public int direction = 1;
  public static final int protocolId = 60;

  public void serialize(ICustomDataOutput param1) {
    if (this.cellId < -1 || this.cellId > 559) {
      throw new Exception("Forbidden value (" + this.cellId + ") on element cellId.");
    }
    param1.writeShort(this.cellId);
    param1.writeByte(this.direction);
  }

  public void deserialize(ICustomDataInput param1) {
    this.cellId = param1.readVarUhShort();
    if (this.cellId < 0) {
      throw new Exception(
          "Forbidden value ("
              + this.cellId
              + ") on element of HavenBagFurnitureInformation.cellId.");
    }

    this.direction = param1.readByte();
    if (this.direction < 0) {
      throw new Exception(
          "Forbidden value ("
              + this.direction
              + ") on element of TreasureHuntStepFollowDirectionToPOI.direction.");
    }
  }
}
