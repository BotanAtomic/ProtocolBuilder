package com.ankamagames.dofus.network.types.game.actions.fight;

import java.lang.Exception;
import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class GameActionMarkedCell extends Object implements INetworkType {

  public int cellId = 0;
  public int zoneSize = 0;
  public int cellColor = 0;
  public int cellsType = 0;
  public static final int protocolId = 85;

  public void serialize(ICustomDataOutput param1) {
    if (this.cellId < 0 || this.cellId > 559) {
      throw new Exception("Forbidden value (" + this.cellId + ") on element cellId.");
    }
    param1.writeVarShort(this.cellId);
    param1.writeByte(this.zoneSize);
    param1.writeInt(this.cellColor);
    param1.writeByte(this.cellsType);
  }

  public void deserialize(ICustomDataInput param1) {
    this.cellId = param1.readVarUhShort();
    if (this.cellId < 0) {
      throw new Exception(
          "Forbidden value ("
              + this.cellId
              + ") on element of HavenBagFurnitureInformation.cellId.");
    }

    this.zoneSize = param1.readByte();

    this.cellColor = param1.readInt();

    this.cellsType = param1.readByte();
  }
}
