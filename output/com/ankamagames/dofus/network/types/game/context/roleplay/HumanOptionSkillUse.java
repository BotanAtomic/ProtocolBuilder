package com.ankamagames.dofus.network.types.game.context.roleplay;

import java.lang.Exception;
import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class HumanOptionSkillUse extends HumanOption implements INetworkType {

  public int elementId = 0;
  public int skillId = 0;
  public Number skillEndTime = 0;
  public static final int protocolId = 495;

  @Override
  public void serialize(ICustomDataOutput param1) {

    if (this.elementId < 0) {
      throw new Error("Forbidden value (" + this.elementId + ") on element elementId.");
    }
    param1.writeVarInt(this.elementId);
    if (this.skillId < 0) {
      throw new Error("Forbidden value (" + this.skillId + ") on element skillId.");
    }
    param1.writeVarShort(this.skillId);
    if (this.skillEndTime < -9.007199254740992E15 || this.skillEndTime > 9.007199254740992E15) {
      throw new Error("Forbidden value (" + this.skillEndTime + ") on element skillEndTime.");
    }
    param1.writeDouble(this.skillEndTime);
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

    this.elementId = param1.readInt();
    if (this.elementId < 0) {
      throw new Error(
          "Forbidden value (" + this.elementId + ") on element of StatedElement.elementId.");
    }

    this.skillId = param1.readVarUhShort();
    if (this.skillId < 0) {
      throw new Error(
          "Forbidden value (" + this.skillId + ") on element of SkillActionDescription.skillId.");
    }

    this.skillEndTime = param1.readDouble();
    if (this.skillEndTime < -9.007199254740992E15 || this.skillEndTime > 9.007199254740992E15) {
      throw new Error(
          "Forbidden value ("
              + this.skillEndTime
              + ") on element of HumanOptionSkillUse.skillEndTime.");
    }
  }
}
