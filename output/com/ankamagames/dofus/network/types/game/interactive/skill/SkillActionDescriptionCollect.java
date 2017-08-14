package com.ankamagames.dofus.network.types.game.interactive.skill;

import java.lang.Exception;
import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class SkillActionDescriptionCollect extends SkillActionDescriptionTimed
    implements INetworkType {

  public int min = 0;
  public int max = 0;
  public static final int protocolId = 99;

  @Override
  public void serialize(ICustomDataOutput param1) {
    if (this.skillId < 0) {
      throw new Exception("Forbidden value (" + this.skillId + ") on element skillId.");
    }
    param1.writeVarShort(this.skillId);

    if (this.time < 0 || this.time > 255) {
      throw new Exception("Forbidden value (" + this.time + ") on element time.");
    }
    param1.writeByte(this.time);

    if (this.min < 0) {
      throw new Exception("Forbidden value (" + this.min + ") on element min.");
    }
    param1.writeVarShort(this.min);
    if (this.max < 0) {
      throw new Exception("Forbidden value (" + this.max + ") on element max.");
    }
    param1.writeVarShort(this.max);
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

    this.min = param1.readVarUhShort();
    if (this.min < 0) {
      throw new Exception(
          "Forbidden value (" + this.min + ") on element of SkillActionDescriptionCollect.min.");
    }

    this.max = param1.readVarUhShort();
    if (this.max < 0) {
      throw new Exception(
          "Forbidden value (" + this.max + ") on element of SkillActionDescriptionCollect.max.");
    }
  }
}
