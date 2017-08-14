package com.ankamagames.dofus.network.types.game.achievement;

import java.lang.Exception;
import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class AchievementStartedObjective extends AchievementObjective implements INetworkType {

  public int value = 0;
  public static final int protocolId = 402;

  @Override
  public void serialize(ICustomDataOutput param1) {
    if (this.id < 0) {
      throw new Exception("Forbidden value (" + this.id + ") on element id.");
    }
    param1.writeVarInt(this.id);
    if (this.maxValue < 0) {
      throw new Exception("Forbidden value (" + this.maxValue + ") on element maxValue.");
    }
    param1.writeVarShort(this.maxValue);

    if (this.value < 0) {
      throw new Exception("Forbidden value (" + this.value + ") on element value.");
    }
    param1.writeVarShort(this.value);
  }

  @Override
  public void deserialize(ICustomDataInput param1) {
    this.uid = param1.readUTF();

    this.figure = param1.readVarUhShort();
    if (this.figure < 0) {
      throw new Exception(
          "Forbidden value (" + this.figure + ") on element of KrosmasterFigure.figure.");
    }

    this.pedestal = param1.readVarUhShort();
    if (this.pedestal < 0) {
      throw new Exception(
          "Forbidden value (" + this.pedestal + ") on element of KrosmasterFigure.pedestal.");
    }

    this.bound = param1.readBoolean();

    this.value = param1.readInt();
  }
}
