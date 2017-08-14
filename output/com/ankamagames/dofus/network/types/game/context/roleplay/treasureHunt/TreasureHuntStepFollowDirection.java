package com.ankamagames.dofus.network.types.game.context.roleplay.treasureHunt;

import java.lang.Exception;
import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class TreasureHuntStepFollowDirection extends TreasureHuntStep implements INetworkType {

  public int direction = 1;
  public int mapCount = 0;
  public static final int protocolId = 468;

  @Override
  public void serialize(ICustomDataOutput param1) {

    param1.writeByte(this.direction);
    if (this.mapCount < 0) {
      throw new Error("Forbidden value (" + this.mapCount + ") on element mapCount.");
    }
    param1.writeVarShort(this.mapCount);
  }

  @Override
  public void deserialize(ICustomDataInput param1) {
    this.uid = param1.readUTF();

    this.figure = param1.readVarUhShort();
    if (this.figure < 0) {
      throw new Error(
          "Forbidden value (" + this.figure + ") on element of KrosmasterFigure.figure.");
    }

    this.pedestal = param1.readVarUhShort();
    if (this.pedestal < 0) {
      throw new Error(
          "Forbidden value (" + this.pedestal + ") on element of KrosmasterFigure.pedestal.");
    }

    this.bound = param1.readBoolean();

    this.direction = param1.readByte();
    if (this.direction < 0) {
      throw new Error(
          "Forbidden value ("
              + this.direction
              + ") on element of TreasureHuntStepFollowDirectionToPOI.direction.");
    }

    this.mapCount = param1.readVarUhShort();
    if (this.mapCount < 0) {
      throw new Error(
          "Forbidden value ("
              + this.mapCount
              + ") on element of TreasureHuntStepFollowDirection.mapCount.");
    }
  }
}
