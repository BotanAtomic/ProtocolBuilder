package com.ankamagames.dofus.network.types.game.character.alignment;

import java.lang.Exception;
import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class ActorAlignmentInformations extends Object implements INetworkType {

  public int alignmentSide = 0;
  public int alignmentValue = 0;
  public int alignmentGrade = 0;
  public Number characterPower = 0;
  public static final int protocolId = 201;

  public void serialize(ICustomDataOutput param1) {
    param1.writeByte(this.alignmentSide);
    if (this.alignmentValue < 0) {
      throw new Exception(
          "Forbidden value (" + this.alignmentValue + ") on element alignmentValue.");
    }
    param1.writeByte(this.alignmentValue);
    if (this.alignmentGrade < 0) {
      throw new Exception(
          "Forbidden value (" + this.alignmentGrade + ") on element alignmentGrade.");
    }
    param1.writeByte(this.alignmentGrade);
    if (this.characterPower < -9.007199254740992E15 || this.characterPower > 9.007199254740992E15) {
      throw new Exception(
          "Forbidden value (" + this.characterPower + ") on element characterPower.");
    }
    param1.writeDouble(this.characterPower);
  }

  public void deserialize(ICustomDataInput param1) {
    this.alignmentSide = param1.readByte();

    this.alignmentValue = param1.readByte();
    if (this.alignmentValue < 0) {
      throw new Exception(
          "Forbidden value ("
              + this.alignmentValue
              + ") on element of ActorAlignmentInformations.alignmentValue.");
    }

    this.alignmentGrade = param1.readByte();
    if (this.alignmentGrade < 0) {
      throw new Exception(
          "Forbidden value ("
              + this.alignmentGrade
              + ") on element of ActorAlignmentInformations.alignmentGrade.");
    }

    this.characterPower = param1.readDouble();
    if (this.characterPower < -9.007199254740992E15 || this.characterPower > 9.007199254740992E15) {
      throw new Exception(
          "Forbidden value ("
              + this.characterPower
              + ") on element of ActorAlignmentInformations.characterPower.");
    }
  }
}
