package com.ankamagames.dofus.network.types.game.context.fight;

import java.lang.Exception;
import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.utils.BooleanByteWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class FightResultExperienceData extends FightResultAdditionalData implements INetworkType {

  public Number experience = 0;
  public boolean showExperience = false;
  public Number experienceLevelFloor = 0;
  public boolean showExperienceLevelFloor = false;
  public Number experienceNextLevelFloor = 0;
  public boolean showExperienceNextLevelFloor = false;
  public Number experienceFightDelta = 0;
  public boolean showExperienceFightDelta = false;
  public Number experienceForGuild = 0;
  public boolean showExperienceForGuild = false;
  public Number experienceForMount = 0;
  public boolean showExperienceForMount = false;
  public boolean isIncarnationExperience = false;
  public int rerollExperienceMul = 0;
  public static final int protocolId = 192;

  @Override
  public void serialize(ICustomDataOutput param1) {

    int _loc2_ = 0;
    _loc2_ = BooleanByteWrapper.setFlag(_loc2_, 0, this.showExperience);
    _loc2_ = BooleanByteWrapper.setFlag(_loc2_, 1, this.showExperienceLevelFloor);
    _loc2_ = BooleanByteWrapper.setFlag(_loc2_, 2, this.showExperienceNextLevelFloor);
    _loc2_ = BooleanByteWrapper.setFlag(_loc2_, 3, this.showExperienceFightDelta);
    _loc2_ = BooleanByteWrapper.setFlag(_loc2_, 4, this.showExperienceForGuild);
    _loc2_ = BooleanByteWrapper.setFlag(_loc2_, 5, this.showExperienceForMount);
    _loc2_ = BooleanByteWrapper.setFlag(_loc2_, 6, this.isIncarnationExperience);
    param1.writeByte(_loc2_);
    if (this.experience < 0 || this.experience > 9.007199254740992E15) {
      throw new Exception("Forbidden value (" + this.experience + ") on element experience.");
    }
    param1.writeVarLong(this.experience);
    if (this.experienceLevelFloor < 0 || this.experienceLevelFloor > 9.007199254740992E15) {
      throw new Exception(
          "Forbidden value (" + this.experienceLevelFloor + ") on element experienceLevelFloor.");
    }
    param1.writeVarLong(this.experienceLevelFloor);
    if (this.experienceNextLevelFloor < 0 || this.experienceNextLevelFloor > 9.007199254740992E15) {
      throw new Exception(
          "Forbidden value ("
              + this.experienceNextLevelFloor
              + ") on element experienceNextLevelFloor.");
    }
    param1.writeVarLong(this.experienceNextLevelFloor);
    if (this.experienceFightDelta < 0 || this.experienceFightDelta > 9.007199254740992E15) {
      throw new Exception(
          "Forbidden value (" + this.experienceFightDelta + ") on element experienceFightDelta.");
    }
    param1.writeVarLong(this.experienceFightDelta);
    if (this.experienceForGuild < 0 || this.experienceForGuild > 9.007199254740992E15) {
      throw new Exception(
          "Forbidden value (" + this.experienceForGuild + ") on element experienceForGuild.");
    }
    param1.writeVarLong(this.experienceForGuild);
    if (this.experienceForMount < 0 || this.experienceForMount > 9.007199254740992E15) {
      throw new Exception(
          "Forbidden value (" + this.experienceForMount + ") on element experienceForMount.");
    }
    param1.writeVarLong(this.experienceForMount);
    if (this.rerollExperienceMul < 0) {
      throw new Exception(
          "Forbidden value (" + this.rerollExperienceMul + ") on element rerollExperienceMul.");
    }
    param1.writeByte(this.rerollExperienceMul);
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

    int _loc2_ = param1.readByte();
    this.sex = BooleanByteWrapper.getFlag(_loc2_, 0);
    this.isRideable = BooleanByteWrapper.getFlag(_loc2_, 1);
    this.isWild = BooleanByteWrapper.getFlag(_loc2_, 2);
    this.isFecondationReady = BooleanByteWrapper.getFlag(_loc2_, 3);
    this.useHarnessColors = BooleanByteWrapper.getFlag(_loc2_, 4);

    this.experience = param1.readVarUhLong();
    if (this.experience < 0 || this.experience > 9.007199254740992E15) {
      throw new Exception(
          "Forbidden value (" + this.experience + ") on element of MountClientData.experience.");
    }

    this.experienceLevelFloor = param1.readVarUhLong();
    if (this.experienceLevelFloor < 0 || this.experienceLevelFloor > 9.007199254740992E15) {
      throw new Exception(
          "Forbidden value ("
              + this.experienceLevelFloor
              + ") on element of FightResultExperienceData.experienceLevelFloor.");
    }

    this.experienceNextLevelFloor = param1.readVarUhLong();
    if (this.experienceNextLevelFloor < 0 || this.experienceNextLevelFloor > 9.007199254740992E15) {
      throw new Exception(
          "Forbidden value ("
              + this.experienceNextLevelFloor
              + ") on element of FightResultExperienceData.experienceNextLevelFloor.");
    }

    this.experienceFightDelta = param1.readVarUhLong();
    if (this.experienceFightDelta < 0 || this.experienceFightDelta > 9.007199254740992E15) {
      throw new Exception(
          "Forbidden value ("
              + this.experienceFightDelta
              + ") on element of FightResultExperienceData.experienceFightDelta.");
    }

    this.experienceForGuild = param1.readInt();

    this.experienceForMount = param1.readVarUhLong();
    if (this.experienceForMount < 0 || this.experienceForMount > 9.007199254740992E15) {
      throw new Exception(
          "Forbidden value ("
              + this.experienceForMount
              + ") on element of FightResultExperienceData.experienceForMount.");
    }

    this.rerollExperienceMul = param1.readByte();
    if (this.rerollExperienceMul < 0) {
      throw new Exception(
          "Forbidden value ("
              + this.rerollExperienceMul
              + ") on element of FightResultExperienceData.rerollExperienceMul.");
    }
  }
}
