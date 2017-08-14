package com.ankamagames.dofus.network.types.game.interactive.skill;

import java.lang.Exception;
import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class SkillActionDescriptionTimed extends SkillActionDescription implements INetworkType {

  public int time = 0;
  public static final int protocolId = 103;

  @Override
  public void serialize(ICustomDataOutput param1) {
    if (this.skillId < 0) {
      throw new Error("Forbidden value (" + this.skillId + ") on element skillId.");
    }
    param1.writeVarShort(this.skillId);

    if (this.time < 0 || this.time > 255) {
      throw new Error("Forbidden value (" + this.time + ") on element time.");
    }
    param1.writeByte(this.time);
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

    this.time = param1.readUnsignedByte();
    if (this.time < 0 || this.time > 255) {
      throw new Error(
          "Forbidden value (" + this.time + ") on element of SkillActionDescriptionTimed.time.");
    }
  }
}
