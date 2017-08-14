package com.ankamagames.dofus.network.types.game.context.fight;

import java.lang.Exception;
import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class FightResultPvpData extends FightResultAdditionalData implements INetworkType {

  public int grade = 0;
  public int minHonorForGrade = 0;
  public int maxHonorForGrade = 0;
  public int honor = 0;
  public int honorDelta = 0;
  public static final int protocolId = 190;

  @Override
  public void serialize(ICustomDataOutput param1) {

    if (this.grade < 0 || this.grade > 255) {
      throw new Error("Forbidden value (" + this.grade + ") on element grade.");
    }
    param1.writeByte(this.grade);
    if (this.minHonorForGrade < 0 || this.minHonorForGrade > 20000) {
      throw new Error(
          "Forbidden value (" + this.minHonorForGrade + ") on element minHonorForGrade.");
    }
    param1.writeVarShort(this.minHonorForGrade);
    if (this.maxHonorForGrade < 0 || this.maxHonorForGrade > 20000) {
      throw new Error(
          "Forbidden value (" + this.maxHonorForGrade + ") on element maxHonorForGrade.");
    }
    param1.writeVarShort(this.maxHonorForGrade);
    if (this.honor < 0 || this.honor > 20000) {
      throw new Error("Forbidden value (" + this.honor + ") on element honor.");
    }
    param1.writeVarShort(this.honor);
    param1.writeVarShort(this.honorDelta);
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

    this.grade = param1.readByte();
    if (this.grade < 0) {
      throw new Error(
          "Forbidden value ("
              + this.grade
              + ") on element of MonsterInGroupLightInformations.grade.");
    }

    this.minHonorForGrade = param1.readVarUhShort();
    if (this.minHonorForGrade < 0 || this.minHonorForGrade > 20000) {
      throw new Error(
          "Forbidden value ("
              + this.minHonorForGrade
              + ") on element of FightResultPvpData.minHonorForGrade.");
    }

    this.maxHonorForGrade = param1.readVarUhShort();
    if (this.maxHonorForGrade < 0 || this.maxHonorForGrade > 20000) {
      throw new Error(
          "Forbidden value ("
              + this.maxHonorForGrade
              + ") on element of FightResultPvpData.maxHonorForGrade.");
    }

    this.honor = param1.readVarUhShort();
    if (this.honor < 0 || this.honor > 20000) {
      throw new Error(
          "Forbidden value (" + this.honor + ") on element of FightResultPvpData.honor.");
    }

    this.honorDelta = param1.readVarShort();
  }
}
