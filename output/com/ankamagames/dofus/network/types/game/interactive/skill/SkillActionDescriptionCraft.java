package com.ankamagames.dofus.network.types.game.interactive.skill;

import java.lang.Exception;
import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class SkillActionDescriptionCraft extends SkillActionDescription implements INetworkType {

  public int probability = 0;
  public static final int protocolId = 100;

  @Override
  public void serialize(ICustomDataOutput param1) {
    if (this.skillId < 0) {
      throw new Error("Forbidden value (" + this.skillId + ") on element skillId.");
    }
    param1.writeVarShort(this.skillId);

    if (this.probability < 0) {
      throw new Error("Forbidden value (" + this.probability + ") on element probability.");
    }
    param1.writeByte(this.probability);
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

    this.probability = param1.readByte();
    if (this.probability < 0) {
      throw new Error(
          "Forbidden value ("
              + this.probability
              + ") on element of SkillActionDescriptionCraft.probability.");
    }
  }
}
