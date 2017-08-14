package com.ankamagames.dofus.network.types.game.guild;

import java.lang.Exception;
import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class HavenBagFurnitureInformation extends Object implements INetworkType {

  public int cellId = 0;
  public int funitureId = 0;
  public int orientation = 0;
  public static final int protocolId = 498;

  public void serialize(ICustomDataOutput param1) {
    if (this.cellId < 0) {
      throw new Error("Forbidden value (" + this.cellId + ") on element cellId.");
    }
    param1.writeVarShort(this.cellId);
    param1.writeInt(this.funitureId);
    if (this.orientation < 0) {
      throw new Error("Forbidden value (" + this.orientation + ") on element orientation.");
    }
    param1.writeByte(this.orientation);
  }

  public void deserialize(ICustomDataInput param1) {
    this.cellId = param1.readVarUhShort();
    if (this.cellId < 0) {
      throw new Error(
          "Forbidden value ("
              + this.cellId
              + ") on element of HavenBagFurnitureInformation.cellId.");
    }

    this.funitureId = param1.readInt();

    this.orientation = param1.readByte();
    if (this.orientation < 0) {
      throw new Error(
          "Forbidden value ("
              + this.orientation
              + ") on element of HavenBagFurnitureInformation.orientation.");
    }
  }
}
