package com.ankamagames.dofus.network.types.game.character.alignment;

import java.lang.Exception;
import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class ActorExtendedAlignmentInformations extends ActorAlignmentInformations
    implements INetworkType {

  public int honor = 0;
  public int honorGradeFloor = 0;
  public int honorNextGradeFloor = 0;
  public int aggressable = 0;
  public static final int protocolId = 202;

  @Override
  public void serialize(ICustomDataOutput param1) {
    param1.writeByte(this.alignmentSide);
    if (this.alignmentValue < 0) {
      throw new Error("Forbidden value (" + this.alignmentValue + ") on element alignmentValue.");
    }
    param1.writeByte(this.alignmentValue);
    if (this.alignmentGrade < 0) {
      throw new Error("Forbidden value (" + this.alignmentGrade + ") on element alignmentGrade.");
    }
    param1.writeByte(this.alignmentGrade);
    if (this.characterPower < -9.007199254740992E15 || this.characterPower > 9.007199254740992E15) {
      throw new Error("Forbidden value (" + this.characterPower + ") on element characterPower.");
    }
    param1.writeDouble(this.characterPower);

    if (this.honor < 0 || this.honor > 20000) {
      throw new Error("Forbidden value (" + this.honor + ") on element honor.");
    }
    param1.writeVarShort(this.honor);
    if (this.honorGradeFloor < 0 || this.honorGradeFloor > 20000) {
      throw new Error("Forbidden value (" + this.honorGradeFloor + ") on element honorGradeFloor.");
    }
    param1.writeVarShort(this.honorGradeFloor);
    if (this.honorNextGradeFloor < 0 || this.honorNextGradeFloor > 20000) {
      throw new Error(
          "Forbidden value (" + this.honorNextGradeFloor + ") on element honorNextGradeFloor.");
    }
    param1.writeVarShort(this.honorNextGradeFloor);
    param1.writeByte(this.aggressable);
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

    this.honor = param1.readVarUhShort();
    if (this.honor < 0 || this.honor > 20000) {
      throw new Error(
          "Forbidden value (" + this.honor + ") on element of FightResultPvpData.honor.");
    }

    this.honorGradeFloor = param1.readVarUhShort();
    if (this.honorGradeFloor < 0 || this.honorGradeFloor > 20000) {
      throw new Error(
          "Forbidden value ("
              + this.honorGradeFloor
              + ") on element of ActorExtendedAlignmentInformations.honorGradeFloor.");
    }

    this.honorNextGradeFloor = param1.readVarUhShort();
    if (this.honorNextGradeFloor < 0 || this.honorNextGradeFloor > 20000) {
      throw new Error(
          "Forbidden value ("
              + this.honorNextGradeFloor
              + ") on element of ActorExtendedAlignmentInformations.honorNextGradeFloor.");
    }

    this.aggressable = param1.readByte();
    if (this.aggressable < 0) {
      throw new Error(
          "Forbidden value ("
              + this.aggressable
              + ") on element of HumanOptionAlliance.aggressable.");
    }
  }
}
